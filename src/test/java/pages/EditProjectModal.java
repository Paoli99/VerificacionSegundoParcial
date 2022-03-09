package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal {
    public TextBox editProjectNameTxt = new TextBox(By.xpath("//*[@id=\"edit_project_modal_field_name\"]"));
    public Button saveEditBtn = new Button(By.xpath("//button[text()='Save']"));

}
