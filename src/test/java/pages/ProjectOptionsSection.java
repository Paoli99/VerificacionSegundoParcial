package pages;

import control.Button;
import org.openqa.selenium.By;

public class ProjectOptionsSection {
    public Button editProjectBtn = new Button(By.xpath("//li//div[text()='Edit project']"));
    //html/body/div[5]/div[2]/div/ul/li[4]/div[2]

    public Button deleteProjectBtn = new Button(By.xpath("//li//div[text()='Delete project']"));

}
