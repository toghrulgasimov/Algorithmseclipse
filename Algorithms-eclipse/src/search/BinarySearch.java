package search;

public abstract class BinarySearch <T>{
	public abstract int compare(T a, T b);
    public int searchl(T[] a, int l, int r, T x) {
        int ans = -1;
        while(l <= r) {
            int m = (l + r) / 2; // 1 2 3 5 5 5 5 7
            if(compare(x, a[m]) == 1) {
                ans = m;
                r = m - 1;
            }else {
                l = m;
            }
        }
        return ans;
    }
    public  int searchr(T[] a, int l, int r, T x) {
        int ans = -1;
        while(l <= r) {
            int m = (l + r) / 2; // 1 2 3 5 5 5 5 7
            if(compare(a[m], x) == 1) {
                ans = m;
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return ans;
    }
}