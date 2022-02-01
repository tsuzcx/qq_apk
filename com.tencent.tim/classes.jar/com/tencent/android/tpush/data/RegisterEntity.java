package com.tencent.android.tpush.data;

import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.logging.TLogger;
import java.io.Serializable;

public class RegisterEntity
  implements Serializable
{
  private static final String TAG = "RegisterEntity";
  public static final byte TYPE_REGISTER = 0;
  public static final byte TYPE_REMOTE_UNINSTALL = 4;
  public static final byte TYPE_REMOTE_UNREGISTER = 3;
  public static final byte TYPE_UNINSTALL = 2;
  public static final byte TYPE_UNREGISTER = 1;
  private static final long serialVersionUID = -7991157757568940718L;
  public long accessId;
  public String accessKey;
  public String appVersion;
  public long channelId;
  public long guid;
  public String packageName;
  public int state;
  public long timestamp;
  public String token;
  public String xgSDKVersion = "1.2.7.3";
  
  public static RegisterEntity decode(String paramString)
  {
    try
    {
      paramString = (RegisterEntity)d.a(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      TLogger.i("RegisterEntity", "RegisterEntity decode ClassNotFound");
      return null;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String encode(RegisterEntity paramRegisterEntity)
  {
    try
    {
      paramRegisterEntity = d.a(paramRegisterEntity);
      return paramRegisterEntity;
    }
    catch (Throwable paramRegisterEntity)
    {
      paramRegisterEntity.printStackTrace();
    }
    return null;
  }
  
  public long getGuid()
  {
    return this.guid;
  }
  
  public boolean isRegistered()
  {
    return this.state == 0;
  }
  
  public boolean isUnregistered()
  {
    return this.state == 1;
  }
  
  public boolean isUnstalled()
  {
    return this.state == 2;
  }
  
  public void setGuid(long paramLong)
  {
    this.guid = paramLong;
  }
  
  public void setRegistered()
  {
    this.state = 0;
  }
  
  public void setUnregistered()
  {
    this.state = 1;
  }
  
  public void setUnstalled()
  {
    this.state = 2;
  }
  
  public String toString()
  {
    return "RegisterEntity [accessId=" + this.accessId + ", accessKey=" + this.accessKey + ", token=" + this.token + ", packageName=" + this.packageName + ", state=" + this.state + ", timestamp=" + this.timestamp + ", xgSDKVersion=" + this.xgSDKVersion + ", appVersion=" + this.appVersion + ", guid=" + this.guid + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.data.RegisterEntity
 * JD-Core Version:    0.7.0.1
 */