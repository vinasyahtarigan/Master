package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.Function;
import page.Settings;
//import page.utils.Captures;


public class Gist {
    public WebDriver driver;

    @Given("^User Home Page Github$")
    public void user_home_page_github() throws Throwable {
        driver.findElement(By.xpath("//input[@id='login_field']")).click();
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(Settings.getUserEmail());
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Settings.getPassword());

        driver.findElement(By.xpath("//input[@name='commit']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='commit']")));
    }

    @When("^User want have see list gist$")
    public void user_want_have_see_list_gist() throws Throwable {
        driver.findElement(By.xpath("//summary[@class='Header-link']//img[@class='avatar']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Your gists')]")).click();
        Thread.sleep(60);
    }

    @And("^Have File (.*)$")
    public void want_to_edit_file_testgist(String File) throws Throwable {
        driver.findElement(By.xpath("//div[@id='file-"+File+"-java']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='file-"+File+"-java']")));
    }

    @And("^Delete File$")
    public void delete_file() throws Throwable {
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger']")).click();
        driver.switchTo().alert().accept();
    }

    @And("^Edit File$")
    public void edit_file() throws Throwable {
        driver.findElement(By.xpath("//*[@class='octicon octicon-pencil']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Create public gist')]")));

    }

    @Then("^Delete File Succesfully$")
    public void delete_file_succesfully() throws Throwable {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-outline width-full text-center']")));
    }

    @Then("^Update File Succesfully$")
    public void update_file_succesfully() throws Throwable {
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));

    }


    @When("^User want to create gist$")
    public void user_want_to_create_gist() throws Throwable {
        driver.findElement(By.xpath("//*[@class='octicon octicon-plus']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'New gist')]")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Create public gist')]")));
    }

    @And("^have a filename (.*)$")
    public void have_a_filename_testgistjava(String FileName) throws Throwable {
        driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Filename including extension…']")).sendKeys(FileName);
    }

    @And("^put Description sourcecode$")
    public void put_description_sourcecode() throws Throwable {
        driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']")).click();
        driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']")).sendKeys("Testing Code");
    }

    @And("^Create Public Gist$")
    public void create_public_gist() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Create public gist')]")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Create public gist')]")));
    }

    @Then("^User sucessfully create public git$")
    public void user_sucessfully_create_public_git() throws Throwable {
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Create public gist')]")));
    }

    @Then("^Cant Create public Gist$")
    public void cant_create_public_gist() throws Throwable {
        new WebDriverWait(driver, 60).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Create public gist')]")));
    }

    @Then("^List will showing$")
    public void list_will_showing() throws Throwable {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'All gists')]")));
    }

}
