package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import singleton.Session;

import java.util.List;

public class CUDProjectTest extends BaseTodoist {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    HeaderSection headerSection = new HeaderSection();
    LeftSection leftSection =  new LeftSection();
    AddProjectModal addProjectModal = new AddProjectModal();
    ProjectOptionsSection projectOptionsSection = new ProjectOptionsSection();
    EditProjectModal editProjectModal = new EditProjectModal();
    DeleteProjectModal deleteProjectModal = new DeleteProjectModal();

    String projectName = "Project";
    String projectNameUpdate = "Project Updated";

    @Test
    public void verifyCUDTodoist() throws InterruptedException {
        mainPage.loginLink.click();
        Thread.sleep(1000);

        //login
        loginPage.emailTxtBox.setText("paola_api@api.com");
        loginPage.pwdTxtBox.setText("12345678");
        loginPage.loginBtn.click();

        Thread.sleep(1000);

        // verfication
        Assertions.assertTrue(headerSection.profileImage.isControlDisplayed(), "Error, no se pudo iniciar sesion");

        //create project
        leftSection.addProjectBtn.click();
        Thread.sleep(1000);

        addProjectModal.projectNameTxtBox.setText(projectName);
        addProjectModal.addProjectBtn.click();

        String currentName=Session.getInstance().getDriver().findElement(By.xpath("//*[@id=\"editor\"]/div[2]/header/div/h1/span")).getAttribute("textContent");
        Assertions.assertEquals(projectName, currentName,"ERROR no se creo el projecto");
        System.out.println(currentName);

        Thread.sleep(2000);

        //update project
        leftSection.clickProjectBtn.click();
        Thread.sleep(1000);
        leftSection.optionsBtn.click();
        Thread.sleep(1000);
        projectOptionsSection.editProjectBtn.click();
        editProjectModal.editProjectNameTxt.clearSetText(projectNameUpdate);
        Thread.sleep(1000);
        editProjectModal.saveEditBtn.click();
        Thread.sleep(1000);
        String updatedName=Session.getInstance().getDriver().findElement(By.xpath("//*[@id=\"editor\"]/div[2]/header/div/h1/span")).getAttribute("textContent");
        Assertions.assertEquals(projectNameUpdate, updatedName,"ERROR no se actualizo el projecto");
        Thread.sleep(1000);

        //delete project
        leftSection.clickProjectUpdatedBtn.click();
        Thread.sleep(1000);
        leftSection.optionsBtn.click();
        Thread.sleep(1000);
        projectOptionsSection.deleteProjectBtn.click();
        Thread.sleep(2000);
        deleteProjectModal.confirmDelteBtn.click();
        Thread.sleep(1000);

        String inbox=Session.getInstance().getDriver().findElement(By.xpath("//*[@id=\"editor\"]/div[2]/header/div/h1/span")).getAttribute("textContent");
        Assertions.assertNotEquals(projectNameUpdate,inbox,"ERROR no se elimino el projecto");

    }

}
