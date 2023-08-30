package de.hhbk;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped; 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "testBean")
@RequestScoped 
public class TestBean implements Serializable
{
  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------     
    public TestBean() { }

  
  //-------------------------------------------------------------------------
  //  Var(s)
  //-------------------------------------------------------------------------     
    private String firstname;
    private String lastname;

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }
 

  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void doTest()
    {
        System.out.println(">>> CALL doTest()");
        
        if (this.firstname == null || this.firstname.isBlank())
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Vorname fehlt"));
            return;
        }

        if (this.lastname == null || this.lastname.isBlank())
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Nachname fehlt"));
            return;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hallo", this.firstname+" "+this.lastname));       
    }

    
    public void resetFields()
    {
        this.firstname = null;
        this.lastname = null;
    }

    
}
