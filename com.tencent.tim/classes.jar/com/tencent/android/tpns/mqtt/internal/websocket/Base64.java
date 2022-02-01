package com.tencent.android.tpns.mqtt.internal.websocket;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

public class Base64
{
  private static final Base64Encoder ENCODER;
  private static final Base64 INSTANCE = new Base64();
  
  static
  {
    Base64 localBase64 = INSTANCE;
    localBase64.getClass();
    ENCODER = new Base64Encoder();
  }
  
  public static String encode(String paramString)
  {
    ENCODER.putByteArray("akey", paramString.getBytes());
    return ENCODER.getBase64String();
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    ENCODER.putByteArray("aKey", paramArrayOfByte);
    return ENCODER.getBase64String();
  }
  
  public class Base64Encoder
    extends AbstractPreferences
  {
    private String base64String = null;
    
    public Base64Encoder()
    {
      super("");
    }
    
    protected AbstractPreferences childSpi(String paramString)
    {
      return null;
    }
    
    protected String[] childrenNamesSpi()
      throws BackingStoreException
    {
      return null;
    }
    
    protected void flushSpi()
      throws BackingStoreException
    {}
    
    public String getBase64String()
    {
      return this.base64String;
    }
    
    protected String getSpi(String paramString)
    {
      return null;
    }
    
    protected String[] keysSpi()
      throws BackingStoreException
    {
      return null;
    }
    
    protected void putSpi(String paramString1, String paramString2)
    {
      this.base64String = paramString2;
    }
    
    protected void removeNodeSpi()
      throws BackingStoreException
    {}
    
    protected void removeSpi(String paramString) {}
    
    protected void syncSpi()
      throws BackingStoreException
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.Base64
 * JD-Core Version:    0.7.0.1
 */