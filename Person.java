
public class Person {
    //Every person has a name and a ticket number

    private String name;
    private int ticketNo;

    private Person nextPerson;
    private Person prevPerson;
    public Person(){}
    public Person(String name, int ticketNo){
        this.name = name;
        this.ticketNo = ticketNo;
    }
    //Ways to set/get the name and ticket number of each person
    public void setName(String newName){
        this.name = newName;
    }

    public void setTicketNo(int newTicketNo){
        this.ticketNo = ticketNo;
    }

    public String getName(){
        return this.name;
    }

    public int getTicketNo(){
        return this.ticketNo;
    }



    public Person nextPerson ()
    {
        return nextPerson;
    }

    public Person prevPerson()
    {
        return prevPerson;
    }

    public void setNextPerson(Person personN){
        nextPerson = personN;
    }

    public void setPrevPerson(Person personN){
        prevPerson = personN;
    }


}


