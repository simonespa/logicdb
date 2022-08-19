package marshalling.domain;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dlvdb-mapping")
public class DlvDb {

	private LinkedList<Connection> connections = new LinkedList<>();
	private LinkedList<Mapping> mappings = new LinkedList<>();
	private Link link;

	@XmlElement(name = "connection")
	public LinkedList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(LinkedList<Connection> connections) {
		this.connections = connections;
	}

	public boolean addConnection(Connection connection) {
		return this.connections.add(connection);
	}

	public boolean removeConnection(Connection connection) {
		return this.connections.remove(connection);
	}

	@XmlElement(name = "mapping")
	public LinkedList<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(LinkedList<Mapping> mappings) {
		this.mappings = mappings;
	}

	public boolean addMapping(Mapping mapping) {
		return mappings.add(mapping);
	}

	public boolean removeMapping(Mapping mapping) {
		return mappings.remove(mapping);
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

}
