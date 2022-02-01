package com.tencent.intervideo.nowproxy.common.login;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.common.AccountUtil;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import java.io.Serializable;

public class LoginData
  implements Serializable
{
  protected String authAppId;
  protected byte[] mKey;
  protected long mLoginAppid;
  protected LoginType mLoginType = LoginType.TOURIST;
  protected String mOriginalId;
  protected byte[] mOriginalKey;
  protected LoginType mOriginalLoginType;
  protected String mQBId;
  protected byte[] mST;
  protected byte[] mSTkey;
  protected byte[] mSkey;
  protected String mUserId;
  protected String wxAccessToken;
  protected String wxOpenid;
  
  public static Bundle getLoginBundle(LoginData paramLoginData)
  {
    Bundle localBundle = new Bundle();
    if (paramLoginData.mLoginType == LoginType.WTLOGIN) {}
    try
    {
      localBundle.putLong("QQ", Long.parseLong(paramLoginData.mUserId));
      localBundle.putLong("WTAPPID", paramLoginData.mLoginAppid);
      localBundle.putByteArray("A2", paramLoginData.mKey);
      localBundle.putByteArray("SKEY", paramLoginData.mSkey);
      localBundle.putByteArray("ST", paramLoginData.mST);
      localBundle.putByteArray("STKEY", paramLoginData.mSTkey);
      if (paramLoginData.mLoginType != LoginType.QQConnect) {}
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        localBundle.putByteArray("A2", paramLoginData.mKey);
        localBundle.putByteArray("SKEY", paramLoginData.mSkey);
        localBundle.putByteArray("ST", paramLoginData.mST);
        localBundle.putByteArray("STKEY", paramLoginData.mSTkey);
        localBundle.putLong("QQ", Long.parseLong(paramLoginData.mUserId));
        localBundle.putString("UID", paramLoginData.mUserId);
        localBundle.putByteArray("KEY", paramLoginData.mKey);
        localBundle.putString("AUTH_APP_ID", paramLoginData.authAppId);
        localBundle.putString("ORIGINAL_ID", paramLoginData.mOriginalId);
        localBundle.putByteArray("ORIGINAL_KEY", paramLoginData.mOriginalKey);
        localBundle.putInt("ORIGINAL_LOGIN_TYPE", AccountUtil.getOriginalAccountType(paramLoginData.mOriginalLoginType));
        localBundle.putInt("platform", AccountUtil.getAccountType(paramLoginData.mLoginType));
        localBundle.putString("ORIGINAL_ID", paramLoginData.mOriginalId);
        localBundle.putString("ORIGINAL_ID", paramLoginData.mOriginalId);
        localBundle.putString("QBID", paramLoginData.mQBId);
        return localBundle;
        localNumberFormatException1 = localNumberFormatException1;
        localNumberFormatException1.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          XLog.e("NowLogin", "QQConnect login happen NumberFormatException e = " + localNumberFormatException2.getMessage());
          localNumberFormatException2.printStackTrace();
        }
      }
    }
  }
  
  public String getAuthAppId()
  {
    return this.authAppId;
  }
  
  public byte[] getKey()
  {
    return this.mKey;
  }
  
  public long getLoginAppid()
  {
    return this.mLoginAppid;
  }
  
  public LoginType getLoginType()
  {
    return this.mLoginType;
  }
  
  public String getQBId()
  {
    return this.mQBId;
  }
  
  public byte[] getSkey()
  {
    return this.mSkey;
  }
  
  public String getUserId()
  {
    return this.mUserId;
  }
  
  public String getWxAccessToken()
  {
    return this.wxAccessToken;
  }
  
  public String getWxOpenid()
  {
    return this.wxOpenid;
  }
  
  public void setAuthAppId(String paramString)
  {
    this.authAppId = paramString;
  }
  
  public void setKey(byte[] paramArrayOfByte)
  {
    this.mKey = paramArrayOfByte;
  }
  
  public void setLoginAppid(long paramLong)
  {
    this.mLoginAppid = paramLong;
  }
  
  public void setLoginType(LoginType paramLoginType)
  {
    this.mLoginType = paramLoginType;
  }
  
  public void setOriginalId(String paramString)
  {
    this.mOriginalId = paramString;
  }
  
  public void setOriginalKey(byte[] paramArrayOfByte)
  {
    this.mOriginalKey = paramArrayOfByte;
  }
  
  public void setOriginalLoginType(LoginType paramLoginType)
  {
    this.mOriginalLoginType = paramLoginType;
  }
  
  public void setQBId(String paramString)
  {
    this.mQBId = paramString;
  }
  
  public void setST(byte[] paramArrayOfByte)
  {
    this.mST = paramArrayOfByte;
  }
  
  public void setSTKey(byte[] paramArrayOfByte)
  {
    this.mSTkey = paramArrayOfByte;
  }
  
  public void setSkey(byte[] paramArrayOfByte)
  {
    this.mSkey = paramArrayOfByte;
  }
  
  public void setUserId(String paramString)
  {
    this.mUserId = paramString;
  }
  
  public void setWxAccessToken(String paramString)
  {
    this.wxAccessToken = paramString;
  }
  
  public void setWxOpenid(String paramString)
  {
    this.wxOpenid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.login.LoginData
 * JD-Core Version:    0.7.0.1
 */