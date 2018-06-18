package search;

public abstract class TrenarySearch<T> {
	public abstract int compare(T a, T b);
	int search(T[] a, int l, int r, T x) {
		if (r >= l) {
			int mid1 = l + (r - l) / 3;
			int mid2 = r - (r - l) / 3;
			if (compare(a[mid1], x) == 0)
				return mid1;
			if (compare(a[mid2], x) == 0)
				return mid2;
			if (compare(x, a[mid1]) == 1)
				return search(a, l, mid1 - 1, x);
			else if (compare(x, a[mid2]) == -1)
				return search(a, mid2 + 1, r, x);
			else
				return search(a, mid1 + 1, mid2 - 1, x);

		}
		return -1;
	}
}