import java.util.*;
public class SetCardGame {
	public static void main(String[] args){
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
		System.out.println(game.setArrayToString());
	}
}
