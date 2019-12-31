import java.util.List;

public class SecurityCheck {
    private Line LineA;
    private Line LineB;

    public SecurityCheck(){
        this.LineA = new Line();
        this.LineB = new Line();
    }



//    public void addPerson(List<Person> addPersonList){
//        for (int i=0; i < addPersonList.size(); i++){
//            //I get the values of the person provided
//            Person newPerson = addPersonList.get(i);
//            String name = newPerson.getName();
//            int ticketNo = newPerson.getTicketNo();
//            //I find out which line has less people, and add the new person there
//            int counter1 = LineA.getCounter();
//            int counter2 = LineB.getCounter();
//
//
//            if (counter1 > counter2){
//                LineB.addPerson(name, ticketNo);
//            } else {
//                LineA.addPerson(name,ticketNo);
//            }
//        }
//    }

    public void addPerson(Person newPerson){
        //I get the values of the new person
        String name = newPerson.getName();
        int ticketNo = newPerson.getTicketNo();

        //I look at which line has less people in it
        int counter1 = LineA.getCounter();
        int counter2 = LineB.getCounter();
        if(counter1<=counter2){
            LineA.addPerson(name, ticketNo);
        } else {
            LineB.addPerson(name, ticketNo);
        }
    }

//    public void removePerson(List<Person> removePersonList) throws personNotFoundException {
//        boolean removed=false;
//        for (int i = 0; i < removePersonList.size(); i++) {
//            //I remove the person based on their ticket number
//
//            Person newPerson = removePersonList.get(i);
//            int ticketNo = newPerson.getTicketNo();
//            //I try to remove the person from lineA
//            try {
//                LineA.removePerson(ticketNo);
//                removed=true;
//            } catch (Exception personNotFoundException) {
//
//            }
//            //if the person was not in line A, I try to remove them from line b
//            if(removed==false) {
//                try {
//                    LineB.removePerson(ticketNo);
//                    removed=true;
//                } catch (Exception personNotFoundException) {
//
//                }
//            }
//            //If the person was not in either line, I throw the exception
//            if(removed == false){
//                throw new personNotFoundException();
//            }
//
//            //I get the count of each list and balance the lists
//            int count1 = LineA.getCounter();
//            int count2 = LineB.getCounter();
//            if (count1>=(count2+2)){
//
//            } else if (count2 >= (count1+2)){
//
//            }
//
//        }
//    }


//    public void removePerson(Person personN) throws personNotFoundException{
//        int personFound = 0;
//        //I get the information of the person we wish to remove
//        String name = personN.getName();
//        int ticketNo = personN.getTicketNo();
//
//        //I set the cursors for each line to the head
//        Person cursor1 = LineA.getHead();
//        Person cursor2 = LineB.getHead();
//
//        Person tail1 = LineA.getTail();
//        Person tail2 = LineB.getTail();
//
//        //If both the lines are empty, I throw an error
//        if((cursor1==null)&&(cursor2==null)){
//            throw new personNotFoundException("There are no people in either LineA or LineB");
//        } else {
//            while(cursor1 != null){
//                Person tempPerson = new Person(cursor1.getName(), cursor1.getTicketNo());
//                if((tempPerson == personN) && (cursor1==LineA.getHead())){
//                    personFound = 1;
//                    //The person is found at the head of LineA
//                    cursor1 = cursor1.nextPerson();
//                    LineA.getHead().setNextPerson(null);
//                    cursor1.setPrevPerson(null);
//                } else if ((tempPerson == personN) && (cursor1!= tail1)) {
//                    personFound = 1;
//                    //The person is found in the middle of LineA
//                    cursor1=cursor1.prevPerson();
//                    cursor1.setNextPerson(cursor1.nextPerson().nextPerson());
//                    cursor1.nextPerson().nextPerson().setPrevPerson(cursor1);
//                } else if((tempPerson == personN) && (cursor1==tail1)){
//                    personFound = 1;
//                    //The person is found at the tail of LineA
//                    cursor1 = cursor1.prevPerson();
//                    cursor1.setNextPerson(null);
//                }
//                cursor1 = cursor1.nextPerson();
//           }
//            if(personFound==0){
//                while(cursor2!=null){
//                    Person tempPerson = new Person(cursor2.getName(), cursor2.getTicketNo());
//                    if((tempPerson == personN) && (cursor2==LineA.getHead())){
//                        personFound = 1;
//                        //The person is found at the head of LineA
//                        cursor2 = cursor2.nextPerson();
//                        LineA.getHead().setNextPerson(null);
//                        cursor2.setPrevPerson(null);
//                    } else if ((tempPerson == personN) && (cursor2!= tail2)) {
//                        personFound = 1;
//                        //The person is found in the middle of LineA
//                        cursor2=cursor2.prevPerson();
//                        cursor2.setNextPerson(cursor2.nextPerson().nextPerson());
//                        cursor2.nextPerson().nextPerson().setPrevPerson(cursor2);
//                    } else if((tempPerson == personN) && (cursor2==tail2)){
//                        personFound = 1;
//                        //The person is found at the tail of LineA
//                        cursor2 = cursor2.prevPerson();
//                        cursor2.setNextPerson(null);
//                    }
//                    cursor2 = cursor2.nextPerson();
//                }
//            }
//        }
//        if(personFound==0){
//            throw new personNotFoundException();
//        }
//
//
//    }

    public void removePerson(Person person) throws personNotFoundException{
        int ticketNo = person.getTicketNo();
        int personRemoved = 0;

        //I first check if LineA and LineB have people, if not I throw an error
        if((LineA.getHead()==null) && (LineB.getHead()==null)){
            throw new personNotFoundException("There are no people in either LineA or LineB.");
        }

        //I check if LineA has the person I'm looking for
        try{
            LineA.removePerson(ticketNo);
            personRemoved = 1;
        } catch (Exception personNotFoundException){

        }
        //I check if LineB has the person I'm looking for
        try {
            LineB.removePerson(ticketNo);
            personRemoved = 1;
        } catch (Exception personNotFoundException) {

        }
        //If neither LineA or LineB has the person I'm looking for, I throw an error
        if(personRemoved == 0){
            throw new personNotFoundException();
        }

        int counter1 = LineA.getCounter();
        int counter2 = LineB.getCounter();
        //I make sure that the lists are balanced
            if (counter1 >= (counter2+2)) { //Since only one person is being removed at a time, counter difference should not be greater than 2
                Person tailA = LineA.getTail();
                addPerson(tailA); // the add person function will handle which Line to put the tail
                tailA.prevPerson().setNextPerson(null);

            } else if (counter2 >= (counter1 + 2)) {
                Person tailB = LineB.getTail();
                addPerson(tailB);
                tailB.prevPerson().setNextPerson(null);
            }

    }

    public void printSecurityCheck(){
        Person cursor = LineA.getHead();
        Person cursor2 = LineB.getHead();

        //I print the values for lineA
        System.out.print("\nLineA: ");
        while(cursor!=null){
            String name = cursor.getName();
            int ticketNo = cursor.getTicketNo();
            System.out.print(toString(name, ticketNo));
            cursor = cursor.nextPerson();
        }
        //I print the values for lineB
        System.out.print("\nLineB: ");
        while(cursor2!=null){
            String name = cursor2.getName();
            int ticketNo = cursor2.getTicketNo();
            System.out.print(toString(name, ticketNo));
            cursor2 = cursor2.nextPerson();
        }
    }

    public void printReverse(){
        Person cursor = LineA.getTail();
        Person cursor2 = LineB.getTail();

        //I print the values for lineA
        System.out.print("\nLineA: ");
        while(cursor!=null){
            String name = cursor.getName();
            int ticketNo = cursor.getTicketNo();
            System.out.print(toString(name, ticketNo));
            cursor = cursor.prevPerson();
        }
        //I print the values for lineB
        System.out.print("\nLineB: ");
        while(cursor2!=null){
            String name = cursor2.getName();
            int ticketNo = cursor2.getTicketNo();
            System.out.print(toString(name, ticketNo));
            cursor2 = cursor2.prevPerson();
        }

    }

    public String findPerson(int ticketNo) throws personNotFoundException{ // ASK ABOUT IF NAME IS BEING RETURNED AS WELL AS COUNTER
        Person cursor1= LineA.getHead();
        Person cursor2 = LineB.getHead();

        int personFound = 0;
        String name = "";
        //I first check that both the lists are not

        //I check if the ticketNo can be found in LineA
        while (cursor1!=null){
            if(cursor1.getTicketNo()==ticketNo){
                personFound = 1;
                name = cursor1.getName();

            }
            cursor1 = cursor1.nextPerson();
        }
        //If the ticketNo has not yet been found, I check LineB
        if (personFound==0){
            while (cursor2!=null){
                if(cursor2.getTicketNo()==ticketNo){
                    personFound = 1;
                    name = cursor2.getName();
                }
                cursor2 = cursor2.nextPerson();
            }
        }
        //If the ticketNo cannot be found, the person does not exist, and I throw an error
        if(personFound==0){
            throw new personNotFoundException();
        }
        return name;

    }


    public String toString(String name, int ticketNo){
       return ("[name: " + name + ", ticketNo: " + ticketNo + "] ");
    }
}
