package com.tencent.moai.mailsdk.protocol.exchange.model;

public class ExchangeInfo
{
  private String exchangeDomain;
  private boolean exchangeHttpLM;
  private String exchangeName;
  private String exchangePassword;
  private String exchangeServer;
  private boolean exchangeUsingSSL;
  private String exchangeVersion;
  
  public String getExchangeDomain()
  {
    return this.exchangeDomain;
  }
  
  public String getExchangeName()
  {
    return this.exchangeName;
  }
  
  public String getExchangePassword()
  {
    return this.exchangePassword;
  }
  
  public String getExchangeServer()
  {
    return this.exchangeServer;
  }
  
  public String getExchangeVersion()
  {
    return this.exchangeVersion;
  }
  
  public boolean isExchangeHttpLM()
  {
    return this.exchangeHttpLM;
  }
  
  public boolean isExchangeUsingSSL()
  {
    return this.exchangeUsingSSL;
  }
  
  public void setExchangeDomain(String paramString)
  {
    this.exchangeDomain = paramString;
  }
  
  public void setExchangeHttpLM(boolean paramBoolean)
  {
    this.exchangeHttpLM = paramBoolean;
  }
  
  public void setExchangeName(String paramString)
  {
    this.exchangeName = paramString;
  }
  
  public void setExchangePassword(String paramString)
  {
    this.exchangePassword = paramString;
  }
  
  public void setExchangeServer(String paramString)
  {
    this.exchangeServer = paramString;
  }
  
  public void setExchangeUsingSSL(boolean paramBoolean)
  {
    this.exchangeUsingSSL = paramBoolean;
  }
  
  public void setExchangeVersion(String paramString)
  {
    this.exchangeVersion = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo
 * JD-Core Version:    0.7.0.1
 */