import java.util.*;
public class SetCardGame {

  static Scanner input = new Scanner(System.in);
  static int status = 9;
  
  public static void main(String[] args){/*
    Scanner input = new Scanner(System.in);
    //Game game = new Game("1drf/2drf/3drf/1dgf/1dpf");
    Game game = new Game("1orf/1drf/1srf/2sgs/2dps/2ors/3dpe/3orf/3sgs/1ops/2sre/3dgf");//5 sets
    //Game game = new Game("1ogf/2ogf/3sgf/3sps/3spe/1ops/2ops/3srf/2spf/1spf/1opf/2opf/3drs/2dgs/1dgs/1ogs/2ogs/3dgf/3dps/3dge");//No sets
    System.out.println(game.getRules());
    while(game.hasSets()){
      System.out.println(game.toString());
      System.out.println("Enter a set to submit:");
      if(!game.submitSet(input.nextLine())) System.out.println("The set could not be submitted");
      //System.out.println(game.toString());
    }
    //game.addCard(game.decodeString("2crf/2cgs/3drs/2dre"));;
    //System.out.println(game.toString());
    System.out.println(game.setArrayToString());*/
    

    while(status!=0){
      for(int i=0;i<30;i++) System.out.println();

      switch(status){
        case 1:
          playGame(true);
          break;
        case 2:
          playGame(false);
          break;
        default:
          displayMenu();
          break;
      }
    }

    
  }
  private static void displayMenu(){
    //Display the menu
    System.out.printf("Welcome to the game of SET!!\n\n\nPlease select one of the following options and press ENTER:\n\n1. Play Game\n2. Set up a game\n\n0. Exit\n");

    //Select option
    try{
      status = input.nextInt();

    }catch(InputMismatchException e){}
    input.nextLine();
  }
  private static void playGame(boolean random){
    boolean completed = false;

    Game game = new Game();
    Deck deck = new Deck();
    
    //Set up a random game
    if(random){
      game.deal(12, deck);
    }else{
      //Set up a game
      System.out.println("Please enter the cards to play with separated by / (e.g 1ore/2dgs/3spf):");
      String[] strArray = input.nextLine().split("/");

      // Add each of the given cards to the game
      for(String c : strArray){
        if(Card.isCard(c)){
          game.deal(Card.decodeCard(c), deck);
        }
      }
    }


    //Play the game
    while(!completed){
      String userInput = input.nextLine().toLowerCase();
      // Exit the game
      if(userInput.equals("exit")) 
        completed=true;
      // Output a hint (valid set) or submit a set(not from the user)
      else if(userInput.contains("hint") || userInput.equals("submit"))
        if(game.hasSets()) 
          if(userInput.contains("hint")){
            int i;
            // Determine which hint, or if it does not matter give the first one
            try{
              i = Integer.parseInt(userInput.replaceAll("^.*hint\\D*", "").replaceAll("\\D.*$", ""))-1;
            }catch(Exception e){
              i = 0;
            }
            System.out.println(game.getValidSet(i));
          }
          // Submit the first valid set found
          else {
            game.submitSet(0);
            game.deal(3, deck);
          }
        else System.out.println("No sets on the table! Type deal to get more cards");
      // Deal more cards
      else if(userInput.equals("deal")) 
        game.deal(3, deck);
      // Output the number of sets on the table
      else if(userInput.toLowerCase().matches(".*how[ ]*many.*(sets?)?.*\\??")){
        System.out.println(game.getSetCount());
      }
      // Submit a set given by the user
      else if(Game.isSet(userInput)){
        if(game.submitSet(userInput)){
          System.out.println("Set submitted correctly.\n");
          game.deal(3, deck);
        }
        else
          System.out.println("The set is not valid");
      }
      // Add a card from the deck
      else if(userInput.contains("add") && !random){
            try{
              String s = userInput.replaceAll("^.*add\\D*", "").replaceAll("\\D.*$", "");
              game.addCard(s, deck);
            }catch(Exception e){
              System.out.println("Card could not be added");
            }
      }
    }
    status = 9;
  }
}
