package com.tencent.moai.mailsdk.model;

public class Contact
{
  private String email;
  private String nick;
  
  public Contact() {}
  
  public Contact(String paramString1, String paramString2)
  {
    this.email = paramString1;
    this.nick = paramString2;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getNick()
  {
    return this.nick;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setNick(String paramString)
  {
    this.nick = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Contact
 * JD-Core Version:    0.7.0.1
 */