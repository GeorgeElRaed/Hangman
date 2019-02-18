
public class HangMan {
	//Private Variables
	private static int aboutToDie;
	private static String Word;
	private static String remaining;
	
	
	//Private Methods
	private String toFill() {
		String toFill="";
		for (int i = 0; i < Word.length(); i++) {
			if (Word.toCharArray()[i] != ' ')
				toFill += "_ ";
			else
				toFill += "  ";
		}
		return toFill;
	}
	
	//Public Methods
	public HangMan(String Word) {
		aboutToDie = 6;
		HangMan.Word = Word;
		remaining=toFill();
	}

	public String getRemaining() {
		return remaining;
	}
	
	public void StartTheKillin() {
		if (aboutToDie == 6) {
			System.out.println("-----\n|    |\n|\n|\n|\n|\n|\n---\n");
			return;
		}
		if (aboutToDie == 5) {
			System.out.println("-----\n|    |\n|    O\n|\n|\n|\n|\n---\n");
			return;
		}
		if (aboutToDie == 4) {
			System.out.println("-----\n|    |\n|    O\n|    |\n|    |\n|\n|\n---\n");
			return;
		}
		if (aboutToDie == 3) {
			System.out.println("-----\n|    |\n|    O\n|   \\|\n|    |\n|\n|\n---\n");
			return;
		}
		if (aboutToDie == 2) {
			System.out.println("-----\n|    |\n|    O\n|   \\|/\n|    |\n|\n|\n---\n");
			return;
		}
		if (aboutToDie == 1) {
			System.out.println("-----\n|    |\n|    O\n|   \\|/\n|    |\n|     \\\n|\n---\n");
			return;
		}
		if (aboutToDie == 0) {
			System.out.println("-----\n|    |\n|    O\n|   \\|/\n|    |\n|   / \\\n|\n---\n");
			return;
		}
	}

	public void Kill() {
		aboutToDie--;
	}

	public boolean isDead() {
		return aboutToDie == 0;
	}

	public boolean isLetter(CharSequence Try) {
		return Word.contains(Try);
	}

	public void winCondition(CharSequence Try) {
		char[] swap=remaining.toCharArray();
		if(remaining.contains(Try)) { System.out.println("Already Used"); return;}
		for(int i=0,j=0;i<Word.length();i++) {
			for(j=0;j<Try.length();j++) {
				if(Word.charAt(i)==Try.charAt(j%Try.length())) {
					swap[i*2]=Word.charAt(i);
				}
			}
		}
		remaining=String.valueOf(swap);
		
	}
	
	public boolean hasWon() {
		return !remaining.contains("_ ");
	}
}

