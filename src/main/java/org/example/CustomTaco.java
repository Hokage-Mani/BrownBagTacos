package org.example;

public class CustomTaco extends Taco{
    public CustomTaco(TacoSize size, ShellType shell) {
        super(size, shell);
    }
    @Override
    public String toString() {
        return "Custom " + super.toString();
    }
}
