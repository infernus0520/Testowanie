package behave;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessengerSteps {
	
	private Messenger mess;
	private MessageService mss;
	
	@Given("a messenger")
	public void calulatorSetup(){
		mess = new Messenger(mss);
	}
	
	@When("set arguments to $a and $b and $c")
	public void setArguments(String a, String b,String c) throws MalformedRecipientException{
		mess.testConnection(a);
		mess.sendMessage(b, c);
	}
	
    @Then("sending should return $status")
    public void shouldSend(SendingStatus status){
    	assertEquals(status,mess.sendMessage()));
    }
    
    @Then("checkConnection should return $connection")
	public void shouldAdd(ConnectionStatus connection){
		assertEquals(connection, mess.testConnection());
	}
 
}
