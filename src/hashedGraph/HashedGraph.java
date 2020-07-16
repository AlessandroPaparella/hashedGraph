package hashedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashedGraph<T> {
	private Set<T> nodes= new HashSet<T>();
	private Map<T, Set<T>> arcs = new HashMap<T, Set<T>>();

	public Boolean isEmpty() {
		Boolean empty=true;
		if(nodes.isEmpty()==false) {
			empty=false;
		}
		return empty;
	}

	public void insNode(T node) {
		if(nodes.add(node)==true)
			arcs.put(node, new HashSet<T>());
	}

	public Boolean contains(T node) {
		return nodes.contains(node);
	}

	public void removeNode(T node) {
		nodes.remove(node);
		arcs.remove(node);
		for(T k: arcs.keySet()) {
			arcs.get(k).remove(node);
		}
	}

	public Set<T> getAdjacents(T node) throws hashedGraphException {
		if(!this.contains(node)) {
			throw new hashedGraphException("Node doesn't exist!");
		}
		return arcs.get(node);
	}

	public Boolean containsArc(T start, T end) throws hashedGraphException {
		if(!this.contains(start) || !this.contains(end)) {
			throw new hashedGraphException("Node doesn't exist!");
		}
		Boolean exists = false;
		Set<T> adjacents=arcs.get(start);
		if(adjacents.contains(end))
			exists = true;
		return exists;
	}

	public void insArc(T start, T end) {
		if(!this.contains(start)) {
			this.insNode(start);
		}
		if(!this.contains(end)) {
			this.insNode(end);
		}
		Set<T> adjacents = arcs.get(start);
		adjacents.add(end);
	}

	public void removeArc(T start, T end) {
		Set<T> adjacents=arcs.get(start);
		adjacents.remove(end);
	}
}
