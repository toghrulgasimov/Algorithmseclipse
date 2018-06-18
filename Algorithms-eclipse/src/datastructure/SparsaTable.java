package datastructure;


public abstract class SparsaTable <TT>{
    public Object[][] M;
    public int[] log;
    public int n, k;
    public abstract TT merge(Object a, Object b);
    public SparsaTable(TT[] a) {
        log = new int[a.length + 1];
        log[1] = 0;
        this.n = a.length;
        
        for(int i = 2; i <= n; i++) {
            log[i] = log[i >> 1] + 1;
        }
        
        this.k = log[n];
        M = new Object[n][k + 1];
        init(a);
    }
    public void init(TT[] a) {
        for(int i = 0; i < n; i++) {
            M[i][0] = a[i];
            //System.out.println(M[i][0]);
        }
        for(int j = 1; j <= k; j++) {
            for(int i = 0; i + (1<<j) - 1 < n; i++) {
                M[i][j] = merge(M[i][j - 1], M[i + (1<<(j - 1))][j - 1]);
            }
        }
    }
    public TT get(int l, int r) {
        if(r < l) throw new RuntimeException("r > l");
        int k = log[r - l + 1];
        return merge(M[l][k], M[r - (1<<k) + 1][k]);
    }
}