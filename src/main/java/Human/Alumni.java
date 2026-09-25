package Human;

public class Alumni extends Person {
    private int salary;


    public Alumni() {
        super();
    }


    public Alumni(String id, String name, String lastname, int salary) {
        super(id, name, lastname);
        this.salary = salary;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public int computeBonus(int bonus) {
        this.salary += bonus;
        return this.salary;
    }


    public int computeBonus(int bonus, String type) {
        computeBonus(bonus);


        if ("manager".equalsIgnoreCase(type)) {
            this.salary += 2000;
        }
        return this.salary;
    }


    @Override
    public void showInfo() {
        System.out.println("ไอดีศิษย์เก่า " + getId() + " ชื่อ " + getName() + " " + getLastname() + " เงินเดือน " + salary);
    }
}