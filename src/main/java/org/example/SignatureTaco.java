package org.example;

public class SignatureTaco extends Taco{
    private String name;
    public SignatureTaco(String name, TacoSize size, ShellType shell) {
        super(size, shell);
        this.name = name;
    }
    public String getname(){
        return name;
    }
    @Override
    public String toString(){
        return "*** " + name.toUpperCase() + " ***\n" + super.toString();
    }
}
