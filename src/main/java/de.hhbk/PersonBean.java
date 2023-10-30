package de.hhbk;

import pojo.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "personBean") 
@SessionScoped
public class PersonBean implements Serializable
{
  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------     
    public PersonBean() { }
 

  //-------------------------------------------------------------------------
  //  Var(s), Get / Set
  //-------------------------------------------------------------------------     
    private Person person = new Person();
    List<Person> personList = new ArrayList();

    public Person getPerson() { return person; }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() { return personList; }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;


    }
    
    public void resetPerson() {
        Person newPerson = new Person();
        this.person = newPerson;
    }
    

  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void addPerson()
    {

        if (this.person.getFirstname() == null || this.person.getFirstname().isBlank())
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Vorname fehlt"));
            return;
        }

        if (this.person.getLastname() == null || this.person.getLastname().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Nachname fehlt"));
            return;
        }

        if (!personList.contains(person)) {

            personList.add(person);

        }

        resetPerson();

    }



    
    public void deletePerson(Person p) {
        personList.remove(p);
    }

}
