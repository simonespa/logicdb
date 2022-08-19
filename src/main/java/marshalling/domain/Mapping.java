package marshalling.domain;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mapping {

	private String predicate;
	private String relation;
	private String connection;
	private String type;
	private LinkedList<Binding> bindings = new LinkedList<>();

	@XmlAttribute
	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	@XmlAttribute
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@XmlAttribute
	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "binding")
	public LinkedList<Binding> getBindings() {
		return bindings;
	}

	public void setBindings(LinkedList<Binding> bindings) {
		this.bindings = bindings;
	}

	public boolean addBinding(Binding binding) {
		return bindings.add(binding);
	}

	public boolean removeBinding(Binding binding) {
		return bindings.remove(binding);
	}

}
