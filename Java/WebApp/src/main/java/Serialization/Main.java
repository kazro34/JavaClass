package Serialization;

import jakarta.xml.bind.*;

import java.beans.*;
import java.io.*;

import javax.imageio.spi.ImageOutputStreamSpi;

public class Main {

	public static void main(String[] args) {
		try{
			Person adam= new Person("Adam","Budapest",1995);
			
			/*ObjectOutputStream oos= new ObjectOutputStream(System.out);
			oos.writeObject(adam);
			oos.close();*/
			
			/*FileOutputStream fo = new FileOutputStream("test.txt");
			ObjectOutputStream oos= new ObjectOutputStream(fo);
			oos.writeObject(adam);
			oos.close();
			
			FileInputStream fi = new FileInputStream("test.txt");
			ObjectInputStream ois= new ObjectInputStream(fi);
			Person p=(Person)ois.readObject();
			ois.close();
			System.out.println(p);*/
			
			//XMLEncoder can serialize JavaBeans (no-argument constructor, getter-setter methods)
			/*FileOutputStream fo = new FileOutputStream("test.txt");
			XMLEncoder xe= new XMLEncoder(fo);
			xe.writeObject(adam);
			xe.close();
			
			FileInputStream fi = new FileInputStream("test.txt");
			XMLDecoder xd= new XMLDecoder(fi);
			Person p=(Person)xd.readObject();
			xd.close();
			System.out.println(p);*/
			
			//Annotation necessary for the class: @XmlRootElement
			//JAXB serializes properties with getter&setter, or annotated field: @XmlElement
			JAXBContext ctx = JAXBContext.newInstance(Person.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(adam, System.out);

			
		} catch (Exception ex) {}

	}

}
