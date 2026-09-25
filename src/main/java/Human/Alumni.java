package Human;

public class Alumni extends Person {
    private int salary;

    // Constructor แบบไม่มีพารามิเตอร์
    public Alumni() {
        super();
    }

    // Constructor กำหนดค่าเริ่มต้น
    public Alumni(String id, String name, String lastname, int salary) {
        super(id, name, lastname);
        this.salary = salary;
    }

    // Getter / Setter
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // คำนวณโบนัสพื้นฐาน (อัปเดตเข้าเงินเดือนจริง)
    public int computeBonus(int bonus) {
        this.salary += bonus;
        return this.salary;
    }

    // คำนวณโบนัสตามตำแหน่ง (Overloading)
    public int computeBonus(int bonus, String type) {
        computeBonus(bonus); // เรียกใช้การคำนวณโบนัสพื้นฐานเพื่อลดการซ้ำซ้อนของโค้ด

        // ตรวจสอบประเภทตำแหน่งแบบ Null-safe
        if ("manager".equalsIgnoreCase(type)) {
            this.salary += 2000;
        }
        return this.salary;
    }

    // แสดงข้อมูลศิษย์เก่า (Override จากคลาส Person)
    @Override
    public void showInfo() {
        System.out.println("ไอดีศิษย์เก่า " + getId() + " ชื่อ " + getName() + " " + getLastname() + " เงินเดือน " + salary);
    }
}