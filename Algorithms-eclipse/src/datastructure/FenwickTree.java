package datastructure;

import java.lang.reflect.Array;

public abstract class FenwickTree <T>{

	T[] a;
	T NEUTRAL; // in decimal 0
	public FenwickTree(Class<T> c, int n, T NEUTRAL) {
		@SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(c, n);
        this.a = a;
        this.NEUTRAL = NEUTRAL;
	}
	public abstract T add(T a, T b);
	public T rsq(int ind) {
        T sum = NEUTRAL;
        while (ind > 0) {
            sum = add(sum, a[ind]);
            ind -= ind & (-ind);
        }
        return sum;
    }
	public void update(int ind, T value) {
        assert ind > 0;
        while (ind < a.length) {
            a[ind] = add(a[ind], value);
            ind += ind & (-ind);
        }
    }
}
