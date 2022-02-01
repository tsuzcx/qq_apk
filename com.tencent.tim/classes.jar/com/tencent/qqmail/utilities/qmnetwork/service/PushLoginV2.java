package com.tencent.qqmail.utilities.qmnetwork.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.UMA.LongConnSig;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class PushLoginV2
  extends PushLogin<byte[]>
{
  private static final String PREFIX_PUSH_LONG_CONNECTION_SESSION_KEY = "pushlongconnectionsig_";
  private volatile byte[] mLongConnSig = null;
  
  public PushLoginV2(SharedPreferences paramSharedPreferences)
  {
    super(paramSharedPreferences);
  }
  
  public SendPacket getLoginPacket(long paramLong, String paramString, int paramInt)
  {
    byte[] arrayOfByte = this.mLongConnSig;
    Log.v("PushLogin", "getLoginPacket: " + arrayOfByte);
    if ((paramLong != 0L) && (arrayOfByte != null))
    {
      paramString = new SendPacket(paramString);
      paramString.uin = paramLong;
      paramString.msg_id = paramInt;
      paramString.cmd_id = 22;
      paramString.body = arrayOfByte;
      paramString.body_len = paramString.body.length;
      return paramString;
    }
    return null;
  }
  
  public byte[] getOldSessionKey()
  {
    Object localObject2 = null;
    String str = this.mSharedPreferences.getString("pushlongconnectionsig_" + this.mVid, null);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      str = Aes.decode(str, Aes.getIMEIKey());
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = StringExtention.decode(str);
      }
      return localObject1;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      QMLog.log(4, "PushLogin", "getOldSessionKey old2new");
    }
    return null;
  }
  
  public byte[] getSessionKey()
  {
    return this.mLongConnSig;
  }
  
  public String getVersion()
  {
    return "v2";
  }
  
  public boolean hasSessionKey()
  {
    return (this.mLongConnSig != null) && (this.mLongConnSig.length > 0);
  }
  
  public boolean isResultValid(CloudProtocolResult paramCloudProtocolResult)
  {
    return (paramCloudProtocolResult.longconn_sig_ != null) && (paramCloudProtocolResult.longconn_sig_.crypted_sig != null);
  }
  
  public boolean isSessiontKeyValid(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0);
  }
  
  public void saveResult(CloudProtocolResult paramCloudProtocolResult)
  {
    this.mLongConnSig = paramCloudProtocolResult.longconn_sig_.crypted_sig.toByteArray();
    setSessionKey(this.mLongConnSig);
  }
  
  public void setSessionKey(byte[] paramArrayOfByte)
  {
    this.mLongConnSig = paramArrayOfByte;
    if ((this.mLongConnSig != null) && (this.mLongConnSig.length > 0))
    {
      Log.v("PushLogin", "requestSessionKey longConnSig: " + StringExtention.base64Encode(this.mLongConnSig, this.mLongConnSig.length));
      paramArrayOfByte = Aes.encode(StringExtention.base64Encode(this.mLongConnSig, this.mLongConnSig.length), Aes.getIMEIKey());
      Log.v("PushLogin", "requestSessionKey longconnEncryptedString: " + paramArrayOfByte);
      this.mEditor.putString("pushlongconnectionsig_" + this.mVid, paramArrayOfByte).apply();
      return;
    }
    this.mEditor.remove("pushlongconnectionsig_" + this.mVid).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushLoginV2
 * JD-Core Version:    0.7.0.1
 */