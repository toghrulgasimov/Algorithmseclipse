/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author Toghrul
 */
public abstract class SegmentTree <TT>{
	

	public abstract Object merge(Object t2, Object t3);

	public int height, maxsize, n;
	public Object T[];
	public TT INF;

	public SegmentTree(TT[] a, TT INF) {
		n = a.length;
		height = (int) Math.ceil((Math.log(a.length) / Math.log(2)));
		maxsize = (int) (2 * Math.pow(2, height) - 1);
		
        this.T = new Object[maxsize + 1];
        this.INF = INF;
		init(1, a, 0, a.length - 1);
	}

	public void init(int x, TT[] a, int l, int r) {
		if (l == r) {
			T[x] = (a[l]);
		} else {
			int m = (l + r) >> 1;
			init(x << 1, a, l, m);
			init((x << 1) | 1, a, m + 1, r);
			
			T[x] =  merge(T[x << 1], T[(x << 1) | 1]);
		}
	}

	public TT get(int x, int l, int r, int ll, int rr) {
		if (ll <= l && r <= rr)
			return (TT)T[x];
		if (r < ll || rr < l) {
			
			return INF;
		}
			
		int m = (l + r) >> 1;
		return (TT) merge(get(x << 1, l, m, ll, rr), get((x << 1) | 1, m + 1, r, ll, rr));
	}

	public void update(int x, int l, int r, int i, TT v) {
		if (l == r && l == i) {
			T[x] = (v);
			return;
		}
		int m = (l + r) >> 1;
		if (l <= i && i <= m)
			update(x << 1, l, m, i, v);
		else if (m + 1 <= i && i <= r)
			update(x << 1 | 1, m + 1, r, i, v);
		T[x] =  merge(T[x << 1], T[x << 1 | 1]);
	}

	public void update(int i, TT v) {
		update(1, 0, n - 1, i, v);
	}

	public TT get(int l, int r) {
		return get(1, 0, n - 1, l, r);
	}

	
}