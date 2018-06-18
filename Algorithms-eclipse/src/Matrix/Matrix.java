/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author Toghrul
 */
public abstract class Matrix <TT>{

	private Object[][] data;
	private Object[][] one;
	public abstract TT ad(Object data2, Object data3);
	public abstract TT mul(Object data2, Object data3);
	public Matrix(TT[][] data) {
		this.data = new Object[data.length][data[0].length];
		this.one = new Object[data.length][data[0].length];
		for(int i = 0;i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				this.data[i][j] = data[i][j];
				if(i == j) one[i][j] = 1;
				else one[i][j] = 0;
			}
		}
	}
	public TT[][] add(Matrix b) {
		int n = b.data.length;
		int m = b.data[0].length;
		Object[][] c = new Object[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				c[i][j] = ad(this.data[i][j],b.data[i][j]);
			}
		}
		return (TT[][]) c;
	}
	public TT[][] mull(Matrix b) {
		int n = data.length;
		int m = data[0].length;
		int p = b.data[0].length;
		if(data[0].length != b.data[0].length) throw new RuntimeException("dimension error");
		Object[][] c = new Object[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < p; j++) {
				// To Do
				TT res = null;
				for(int k = 0; k < m; k++) {
					res = ad(res, mul(data[i][k], b.data[k][j]));
				}
				c[i][j] = res;
			}
		}
		
		return (TT[][]) c;
	}
	
	public TT[][]pow(int n) {
		// To Do
		Object[][] res = one;
		while(n > 0) {
			if((n&1) == 0) {
				
			}else {
				
			}
		}
		return null;
	}
	

}