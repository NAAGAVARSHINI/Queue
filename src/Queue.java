import java.util.Scanner;

public class Queue {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    Node front;
    Node rear;
    int length;

    Queue(){

    }
    void display(){
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;

        }
        System.out.println();
    }

    void getLength(){
        System.out.println(length);
    }

    void getFirst(){
        System.out.println(front.value);
    }

    void getRear(){
        System.out.println(rear.value);
    }

    void enque(int value){
        Node newNode = new Node(value);
        if(length ==0){
            front=newNode;
            rear = newNode;
        }
        else{
           rear.next=newNode;
           rear = newNode;

        }
        length++;

    }

    Node deque(){
        if(length ==0){
            return null;
        }
        Node temp = front;
        if(length == 1){
            front=null;
            rear=null;
        }
        else{
            front = front.next;
            temp.next= null;
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue myqueue = new Queue();
        System.out.println("********************");
        System.out.println("Queue Implementation");
        System.out.println("********************");

        System.out.println("Enter the values to insert in queue: ");
        int data=0;
        while(true){
            data= sc.nextInt();
            if(data == -1){
                break;
            }
            myqueue.enque(data);
        }
        System.out.println("Stack after insertion");
        myqueue.display();
        char ch='y';
        while(ch =='y'){
            System.out.println();
            System.out.println("Stack Operations");
            System.out.println("1.Insert an element \n2.Remove an element \n3.Display \n4. Get the front node \n5.Get rear node \n6.Get length of queue");
            System.out.println();
            System.out.println("Enter the value of the operation to be performed");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the value to be inserted");
                    myqueue.enque(sc.nextInt());
                    System.out.println("After Inserting...");
                    myqueue.display();
                    break;

                case 2:
                    System.out.println("Queue Elements: ");
                    myqueue.display();
                    myqueue.deque();
                    System.out.println("After Removing...");
                    myqueue.display();
                    break;

                case 3:
                    System.out.println("Queue Elements: ");
                    myqueue.display();
                    break;

                case 4:
                    System.out.println("Front node");
                    myqueue.getFirst();
                    break;

                case 5:
                    System.out.println("Last node");
                    myqueue.getRear();
                    break;

                case 6:
                    System.out.println("Length of queue: ");
                    myqueue.getLength();
                    break;
            }

            System.out.println("Do you want to continue(y/n): ");
            ch=sc.next().charAt(0);

        }
    }

}
