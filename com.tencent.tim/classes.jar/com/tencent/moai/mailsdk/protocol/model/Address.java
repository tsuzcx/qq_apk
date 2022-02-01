package com.tencent.moai.mailsdk.protocol.model;

public abstract class Address
{
  protected String email;
  protected String nick;
  
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.Address
 * JD-Core Version:    0.7.0.1
 */