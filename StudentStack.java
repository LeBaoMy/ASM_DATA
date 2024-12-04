import java.util.EmptyStackException;

class StudentStack {
    private Node top;

    public StudentStack() {
        this.top = null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    public Student pop() {
        if (top == null) throw new EmptyStackException();
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    public Student peek() {
        if (top == null) throw new EmptyStackException();
        return top.student;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
