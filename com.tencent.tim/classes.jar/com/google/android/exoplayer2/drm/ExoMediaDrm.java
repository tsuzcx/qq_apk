package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(18)
public abstract interface ExoMediaDrm<T extends ExoMediaCrypto>
{
  public static final int EVENT_KEY_EXPIRED = 3;
  public static final int EVENT_KEY_REQUIRED = 2;
  public static final int EVENT_PROVISION_REQUIRED = 1;
  public static final int KEY_TYPE_OFFLINE = 2;
  public static final int KEY_TYPE_RELEASE = 3;
  public static final int KEY_TYPE_STREAMING = 1;
  
  public abstract void closeSession(byte[] paramArrayOfByte);
  
  public abstract T createMediaCrypto(byte[] paramArrayOfByte)
    throws MediaCryptoException;
  
  public abstract KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt, HashMap<String, String> paramHashMap)
    throws NotProvisionedException;
  
  public abstract byte[] getPropertyByteArray(String paramString);
  
  public abstract String getPropertyString(String paramString);
  
  public abstract ProvisionRequest getProvisionRequest();
  
  public abstract byte[] openSession()
    throws MediaDrmException;
  
  public abstract byte[] provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException;
  
  public abstract void provideProvisionResponse(byte[] paramArrayOfByte)
    throws DeniedByServerException;
  
  public abstract Map<String, String> queryKeyStatus(byte[] paramArrayOfByte);
  
  public abstract void release();
  
  public abstract void restoreKeys(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void setOnEventListener(OnEventListener<? super T> paramOnEventListener);
  
  public abstract void setOnKeyStatusChangeListener(OnKeyStatusChangeListener<? super T> paramOnKeyStatusChangeListener);
  
  public abstract void setPropertyByteArray(String paramString, byte[] paramArrayOfByte);
  
  public abstract void setPropertyString(String paramString1, String paramString2);
  
  public static final class DefaultKeyRequest
    implements ExoMediaDrm.KeyRequest
  {
    private final byte[] data;
    private final String defaultUrl;
    
    public DefaultKeyRequest(byte[] paramArrayOfByte, String paramString)
    {
      this.data = paramArrayOfByte;
      this.defaultUrl = paramString;
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public String getDefaultUrl()
    {
      return this.defaultUrl;
    }
  }
  
  public static final class DefaultKeyStatus
    implements ExoMediaDrm.KeyStatus
  {
    private final byte[] keyId;
    private final int statusCode;
    
    DefaultKeyStatus(int paramInt, byte[] paramArrayOfByte)
    {
      this.statusCode = paramInt;
      this.keyId = paramArrayOfByte;
    }
    
    public byte[] getKeyId()
    {
      return this.keyId;
    }
    
    public int getStatusCode()
    {
      return this.statusCode;
    }
  }
  
  public static final class DefaultProvisionRequest
    implements ExoMediaDrm.ProvisionRequest
  {
    private final byte[] data;
    private final String defaultUrl;
    
    public DefaultProvisionRequest(byte[] paramArrayOfByte, String paramString)
    {
      this.data = paramArrayOfByte;
      this.defaultUrl = paramString;
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public String getDefaultUrl()
    {
      return this.defaultUrl;
    }
  }
  
  public static abstract interface KeyRequest
  {
    public abstract byte[] getData();
    
    public abstract String getDefaultUrl();
  }
  
  public static abstract interface KeyStatus
  {
    public abstract byte[] getKeyId();
    
    public abstract int getStatusCode();
  }
  
  public static abstract interface OnEventListener<T extends ExoMediaCrypto>
  {
    public abstract void onEvent(ExoMediaDrm<? extends T> paramExoMediaDrm, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2);
  }
  
  public static abstract interface OnKeyStatusChangeListener<T extends ExoMediaCrypto>
  {
    public abstract void onKeyStatusChange(ExoMediaDrm<? extends T> paramExoMediaDrm, byte[] paramArrayOfByte, List<ExoMediaDrm.KeyStatus> paramList, boolean paramBoolean);
  }
  
  public static abstract interface ProvisionRequest
  {
    public abstract byte[] getData();
    
    public abstract String getDefaultUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ExoMediaDrm
 * JD-Core Version:    0.7.0.1
 */