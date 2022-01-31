package oicq.wlogin_sdk.request;

import java.io.Serializable;

public class WloginLastLoginInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String mAccount = new String();
  public long mUin = 0L;
  
  public WloginLastLoginInfo()
  {
    this.mAccount = "";
  }
  
  public WloginLastLoginInfo(String paramString, long paramLong)
  {
    this.mAccount = paramString;
    this.mUin = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */