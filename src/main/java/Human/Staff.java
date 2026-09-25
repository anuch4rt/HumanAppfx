package Human;

public class Staff extends Person {
    private int age;

    public Staff() {
        super();
    }

    public Staff(String id, String name, String lastname, int age) {
        super(id, name, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void showInfo() {
        System.out.println("ไอดีเจ้าหน้าที่ " + getId() + " ชื่อ " + getName() + " " + getLastname() + " อายุการทำงาน " + age + " ปี");
    }
}