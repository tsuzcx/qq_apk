package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import java.io.File;

public abstract class ExchangeRequest
{
  protected String cmdType;
  protected ExchangeInfo exchangeInfo;
  
  public ExchangeRequest(ExchangeInfo paramExchangeInfo, String paramString)
  {
    this.exchangeInfo = paramExchangeInfo;
    this.cmdType = paramString;
  }
  
  public byte[] buildCmdData()
  {
    return null;
  }
  
  public File buildCmdDataFile()
  {
    return null;
  }
  
  public String getCmdType()
  {
    return this.cmdType;
  }
  
  public ExchangeInfo getExchangeInfo()
  {
    return this.exchangeInfo;
  }
  
  public void setCmdType(String paramString)
  {
    this.cmdType = paramString;
  }
  
  public void setExchangeInfo(ExchangeInfo paramExchangeInfo)
  {
    this.exchangeInfo = paramExchangeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.ExchangeRequest
 * JD-Core Version:    0.7.0.1
 */