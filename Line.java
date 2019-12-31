
public class Line extends Person{
   // PersonNotFoundException personNotFoundException = new PersonNotFoundException();

    //I create variables of a link list
    private Person head;
    private Person tail;
    private Person cursor;
    private int counter;

    //Initial values of pointers
    public Line() {
        head = null;
        tail = null;
        cursor = null;
        counter=0;
    }


    public void addPerson(String name, int ticketNo) {
        //If there are no people, this new person becomes the first of the list
        counter++;
        Person newPerson = new Person(name, ticketNo);
        int count = 0;
        if (head == null) {
            head = newPerson;
            tail = newPerson;
            cursor = newPerson;
            head.setPrevPerson(null);
        } else {
            cursor = head;
            while (cursor != null) {
                if (cursor.getTicketNo() > ticketNo) {
                    //If I need to add the new person before the head
                    if (cursor == head){
                        newPerson.setNextPerson(cursor);
                        cursor.setPrevPerson(newPerson);
                        head = newPerson;
                    } else {
                    //If I need to add the person either in the middle
                        newPerson.setNextPerson(cursor);
                        newPerson.setPrevPerson(cursor.prevPerson());
                        cursor.prevPerson().setNextPerson(newPerson);
                        cursor.setPrevPerson(newPerson);
                    }
                    count = 1;
                    break;
                }
                cursor = cursor.nextPerson();
            }
            //If I need to add the person at the end of the list
            if (count == 0) {
                tail.setNextPerson(newPerson);
                newPerson.setPrevPerson(tail);
                tail = newPerson; //MUST REMEMBER TO DO
            }
        }
    }

    public void removePerson(String name) throws personNotFoundException {
        int count = 0;

        //If there are no people, I throw an error
        if (head == null) {
            throw new personNotFoundException("There are no people present.");

        } else {
            while (cursor != null) {
                //if the person is located at the middle
                if ((cursor.getName() == name) && (cursor.nextPerson() != null)) {
                    cursor.prevPerson().setNextPerson(cursor.nextPerson());
                    cursor.nextPerson().setPrevPerson(cursor.prevPerson());
                    count = 1;
                    counter--;
                    //If the person is at the tail
                } else if ((cursor.getName() == name) && (cursor == tail)) {
                    tail = cursor.prevPerson();
                    cursor.prevPerson().setNextPerson(null);
                    count = 1;
                    counter--;
                }
                cursor = cursor.nextPerson();
            }
            if (count == 0) {
                throw new personNotFoundException();
            }
        }
    }

    public void removePerson(int ticketNo) throws personNotFoundException{
        int count = 0;
        //if there are no people, I throw an error
        if (head == null) {
            throw new personNotFoundException("There are no people present.");
        } else {
            while(cursor!=null){
                //If the person is located in the middle
                if((cursor.getTicketNo() == ticketNo) && (cursor!=tail)){
                    cursor.prevPerson().setNextPerson(cursor.nextPerson());
                    cursor.nextPerson().setPrevPerson(cursor.prevPerson());
                    count = 1;
                    counter--;
                } else if ((cursor.getTicketNo() == ticketNo) && (cursor == tail)){
                    tail = cursor.prevPerson();
                    cursor.prevPerson().setNextPerson(null);
                    count = 1;
                    counter--;
                }
                cursor = cursor.nextPerson();
            }
            if (count==0){
                throw new personNotFoundException();
            }
        }
    }

    public int getCounter(){
        return this.counter;
    }

    public Person getHead(){
        return head;
    }

    public Person getTail(){
        return tail;
    }


}


