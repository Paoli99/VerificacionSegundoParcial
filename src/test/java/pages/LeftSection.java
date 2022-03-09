package pages;

import control.Button;
import org.openqa.selenium.By;
import singleton.Session;
import tests.CUDProjectTest;

public class LeftSection {
    public String projectName = "Project";
    String projectNameUpdate = "Project Updated";

    public Button addProjectBtn = new Button(By.xpath("//*[@id=\"list_holder\"]/div/div[1]/div/button"));
    public Button optionsBtn = new Button(By.xpath("//*[@id=\"projects_list\"]/li[last()]/div/div/div/button"));
    public Button clickProjectBtn = new Button(By.xpath("//li[last()]//span[text()='"+projectName+"']"));
    public Button clickProjectUpdatedBtn = new Button(By.xpath("//li[last()]//span[text()='"+projectNameUpdate+"']"));


}
