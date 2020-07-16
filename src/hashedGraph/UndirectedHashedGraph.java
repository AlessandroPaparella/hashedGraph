package hashedGraph;

public class UndirectedHashedGraph<T> extends HashedGraph<T> {

	public UndirectedHashedGraph() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void insArc(T start, T end) {
		super.insArc(start, end);
		super.insArc(end, start);
	}

	@Override
	public void removeArc(T start, T end) {
		super.removeArc(start, end);
		super.removeArc(end, start);
	}

}
