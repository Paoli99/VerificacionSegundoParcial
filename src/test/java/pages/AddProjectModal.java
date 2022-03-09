package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddProjectModal {
    public TextBox projectNameTxtBox = new TextBox(By.xpath("//*[@id=\"edit_project_modal_field_name\"]"));
    public Button addProjectBtn = new Button(By.xpath("//*[@id=\"reactist-modal-box-6\"]/form/footer/button[2]"));
}
