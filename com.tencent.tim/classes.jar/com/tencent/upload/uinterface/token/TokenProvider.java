package com.tencent.upload.uinterface.token;

import SLICE_UPLOAD.AuthToken;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.UploadLog;

public class TokenProvider
{
  private static final String TAG = "TokenProvider";
  private static volatile TokenProvider sInstance;
  private ITokenEncryptor mTokenEncryptor;
  
  public static AuthToken getAuthToken(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = getInstance().getEncryptTokenData(paramArrayOfByte1);
    int i = getInstance().getTokenEncTye();
    AuthToken localAuthToken = new AuthToken(i, paramArrayOfByte1, paramArrayOfByte2, UploadGlobalConfig.getConfig().getAppId());
    StringBuilder localStringBuilder = new StringBuilder().append(" vLoginData.size: ");
    if (paramArrayOfByte1 == null) {}
    for (paramArrayOfByte1 = "null";; paramArrayOfByte1 = Integer.valueOf(paramArrayOfByte1.length))
    {
      UploadLog.i("TokenProvider", paramArrayOfByte1 + " vLoginKey.size: " + paramArrayOfByte2.length + " tokenEncType: " + i);
      return localAuthToken;
    }
  }
  
  public static TokenProvider getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new TokenProvider();
      }
      return sInstance;
    }
    finally {}
  }
  
  public byte[] getEncryptTokenData(byte[] paramArrayOfByte)
  {
    if (this.mTokenEncryptor == null) {
      return paramArrayOfByte;
    }
    return this.mTokenEncryptor.getTokenData(paramArrayOfByte);
  }
  
  public int getTokenEncTye()
  {
    if (this.mTokenEncryptor == null) {
      return 2;
    }
    return this.mTokenEncryptor.getTokenEncTye();
  }
  
  public TokenProvider setTokenEncryptor(ITokenEncryptor paramITokenEncryptor)
  {
    this.mTokenEncryptor = paramITokenEncryptor;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.uinterface.token.TokenProvider
 * JD-Core Version:    0.7.0.1
 */