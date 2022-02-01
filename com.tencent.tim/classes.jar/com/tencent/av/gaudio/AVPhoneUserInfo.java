package com.tencent.av.gaudio;

import java.io.Serializable;

public class AVPhoneUserInfo
  implements Serializable
{
  public long account;
  public int accountType;
  public TelInfo telInfo = new TelInfo();
  
  public String toString()
  {
    return "AVUserInfo-->Account = " + this.account + " , AccountType = " + this.accountType + " , TelInfo = " + this.telInfo + " .";
  }
  
  public class TelInfo
    implements Serializable
  {
    public String mobile;
    public String nation;
    public int nationState;
    public String prefix;
    
    public TelInfo() {}
    
    public String toString()
    {
      return "TelInfo--> Nation = " + this.nation + ", Prefix = " + this.prefix + ", Mobile = " + this.mobile + ", nationState = " + this.nationState;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.AVPhoneUserInfo
 * JD-Core Version:    0.7.0.1
 */