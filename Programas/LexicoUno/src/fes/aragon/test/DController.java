package fes.aragon.test;

public class DController {
	private int[][] _matrix = { { 1, 0, 0, 0 }, { 2, 1, 1, 0 }, { 3, 2, 2, 0 }, 
			{ 4, 3, 3, 1 }, { 4, 4, 4, 0 } };

	private char[] _alphabet = { 'a', 'b', 'c' };

	Boolean evaluate(String val) {
		int actualState = 0;
		
		for (int i = 0; i < val.length(); i++) {
			Boolean invalid = false;
			for (int j = 0; j < _alphabet.length && !invalid; j++) {
				if (_alphabet[j] != val.charAt(i))
					continue;
				actualState = _matrix[actualState][j];
				invalid = !invalid;
				break;
			}
			if (!invalid) return false;
		}
		return _matrix[actualState][_matrix[1].length - 1] == 1;

	}

	public static void main(String[] args) {
		DController app = new DController();
		System.out.println(app.evaluate("ccccajaa"));
	}

}
