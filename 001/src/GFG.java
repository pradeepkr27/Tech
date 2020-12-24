public class GFG{
	
	static int R = 3;
	static int C = 5;
	static int fresh=0;
	static int rotten=0;
	static int changecount = 0;
	
	
	
	static boolean issafe(int i, int j) {
		if (i >= 0 && i < R && j >= 0 && j < C) {
			return true;
		}
		return false;
	}
	
	static void rotOranges(int v[][]) {
		boolean changed = false;
		
		int no = 2;
     
		while (true) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if (v[i][j] == no) {
						if (issafe(i + 1, j) && v[i + 1][j] == 1) {
							v[i + 1][j] = v[i][j] + 1;
							changed = true;
							changecount++;
						}
						if (issafe(i, j + 1) && v[i][j + 1] == 1) {
							v[i][j + 1] = v[i][j] + 1;
							changed = true;
							changecount++;
						}
						if (issafe(i - 1, j) && v[i - 1][j] == 1) {
							v[i - 1][j] = v[i][j] + 1;
							changed = true;
							changecount++;
						}
						if (issafe(i, j - 1) && v[i][j - 1] == 1) {
							v[i][j - 1] = v[i][j] + 1;
							changed = true;
							changecount++;
						}
					}
				}
			}
			if (!changed)
            break;
             
			changed = false;
			no++;
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if (v[i][j] == 1) {
					fresh++;
				}else if (v[i][j] == 2) {
					rotten++;
				}

			}
		}
		
		int timeframe = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if (v[i][j] == 1)
					timeframe = -1;
				}
			}
			timeframe = no-2;
			
			System.out.println("time frames: " + (timeframe));
			System.out.println("fresh oranges: " + fresh);
			System.out.println("Rotten oranges: " + changecount);
		}
		


	public static void main(String[] args)
	{
		int v[][] = { 	{ 2, 1, 0, 2, 1 },
						{ 1, 0, 1, 2, 1 },
						{ 1, 0, 0, 2, 1 } 	};
		
		rotOranges(v);
		
  
		
	}
}