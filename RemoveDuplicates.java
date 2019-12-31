public class RemoveDuplicates extends emptyListException {
    public IntNode original_list;
    public int length;

    public RemoveDuplicates(IntNode original_list, int length) {
        this.length = length;
        this.original_list = original_list;
    }

    private IntNode head;
    private IntNode tail;
    private IntNode cursor;
    private IntNode trailCursor;

    public RemoveDuplicates() {
        head = null;
        tail = null;
        cursor = null;
        trailCursor = null;
    }

    public void remove_duplicates(IntNode original_list) throws emptyListException {
        //I make sure that there are values stored in the list, otherwise, I throw an error
        if (head == null) {
            throw new emptyListException();
        }
        IntNode cursor = head;
        IntNode trailCursor = null;
        //If the cursor value is equal to the value to the right, I remove the cursor
        while (cursor != null) {
            if (cursor.getData() == cursor.getLink().getData()) {
                //If this happens at the head
                if (cursor == head) {
                    head = head.getLink();
                    cursor = head;
                    trailCursor = null;
                    length --;
                } else {
                    //If this happens in the middle --> tail does not need to be accounted for
                    cursor = cursor.getLink();
                    trailCursor.setLink(cursor);
                    //trailCursor =
                    length--;
                }
            } else {
                trailCursor = cursor;
                cursor = cursor.getLink();
            }
        }
    }

    public IntNode getList(){
        return original_list;
    }
}