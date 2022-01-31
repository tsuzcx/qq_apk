package com.tencent.mobileqq.activity.voip;

import java.io.Serializable;

public class VoipDialData
  implements Serializable
{
  private static final long serialVersionUID = 8693074562669571731L;
  public String countryCode = "";
  public String phoneNumberWithoutContry = "";
  
  public VoipDialData(String paramString1, String paramString2)
  {
    this.countryCode = paramString1;
    this.phoneNumberWithoutContry = paramString2;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getPhoneNumberWithoutContry()
  {
    return this.phoneNumberWithoutContry;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setPhoneNumberWithoutContry(String paramString)
  {
    this.phoneNumberWithoutContry = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDialData
 * JD-Core Version:    0.7.0.1
 */