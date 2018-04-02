package newpackage;

import javax.ejb.Stateless;

@Stateless
public class lembrete 
{
    private String username;
    private String title;
    private String body;
    
    public lembrete()
    {
        
    }
    
    public lembrete (String username, String title, String body)
    {
        this.username = username;
        this.title = title;
        this.body = body;
    }
    
    public void SetUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void SetTitle(String title)
    {
        this.title = title;
    }
    
    public String GetTitle()
    {
        return title;
    }
    
    public void SetBody(String body)
    {
        this.body = body;
    }
    
    public String GetBody()
    {
        return body;
    }
}
