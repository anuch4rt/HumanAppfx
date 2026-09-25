package Subject;

public class Subject {
    private String code;
    private String name;
    private int unit;

    public Subject() {
    }

    public Subject(String code, String name, int unit) {
        this.code = code;
        this.name = name;
        this.unit = unit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}