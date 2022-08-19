package marshalling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import marshalling.domain.Binding;
import marshalling.domain.Connection;
import marshalling.domain.DlvDb;
import marshalling.domain.Link;
import marshalling.domain.Mapping;

public class Marshalling {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(DlvDb.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		DlvDb dlvdb = new DlvDb();

		Connection conn1 = new Connection();
		conn1.setId("1");
		conn1.setUrl("jdbc:mysql://localhost/recursive");
		conn1.setUsername("root");
		conn1.setPassword("root");
		dlvdb.addConnection(conn1);

		Connection conn2 = new Connection();
		conn2.setId("2");
		conn2.setUrl("jdbc:oracle:thin:@/localhost/prova");
		conn2.setUsername("admin");
		conn2.setPassword("password");
		dlvdb.addConnection(conn2);

		Mapping mapping = new Mapping();
		mapping.setConnection(conn1.getId());
		mapping.setPredicate("parentOf");
		mapping.setRelation("parent");
		mapping.setType("input");

		Binding binding = new Binding();
		binding.setTerm("X");
		binding.setAttribute("father");
		binding.setType("string");
		mapping.addBinding(binding);

		binding = new Binding();
		binding.setTerm("Y");
		binding.setAttribute("son");
		binding.setType("string");
		mapping.addBinding(binding);
		dlvdb.addMapping(mapping);

		Link link = new Link();
		link.setClassName("spa.simone.domain.Program");
		link.setUri("http://www.example.com/users/0948/reachable.dl");
		dlvdb.setLink(link);

		marshaller.marshal(dlvdb, new FileOutputStream("dlvdbmapping.xml"));
	}

}
