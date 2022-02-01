package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

final class MacHashFunction
  extends AbstractStreamingHashFunction
{
  private final int bits;
  private final Key key;
  private final Mac prototype;
  private final boolean supportsClone;
  private final String toString;
  
  MacHashFunction(String paramString1, Key paramKey, String paramString2)
  {
    this.prototype = getMac(paramString1, paramKey);
    this.key = ((Key)Preconditions.checkNotNull(paramKey));
    this.toString = ((String)Preconditions.checkNotNull(paramString2));
    this.bits = (this.prototype.getMacLength() * 8);
    this.supportsClone = supportsClone(this.prototype);
  }
  
  private static Mac getMac(String paramString, Key paramKey)
  {
    try
    {
      paramString = Mac.getInstance(paramString);
      paramString.init(paramKey);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private static boolean supportsClone(Mac paramMac)
  {
    try
    {
      paramMac.clone();
      return true;
    }
    catch (CloneNotSupportedException paramMac) {}
    return false;
  }
  
  public int bits()
  {
    return this.bits;
  }
  
  public Hasher newHasher()
  {
    if (this.supportsClone) {
      try
      {
        MacHasher localMacHasher = new MacHasher((Mac)this.prototype.clone(), null);
        return localMacHasher;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key), null);
  }
  
  public String toString()
  {
    return this.toString;
  }
  
  static final class MacHasher
    extends AbstractByteHasher
  {
    private boolean done;
    private final Mac mac;
    
    private MacHasher(Mac paramMac)
    {
      this.mac = paramMac;
    }
    
    private void checkNotDone()
    {
      if (!this.done) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Cannot re-use a Hasher after calling hash() on it");
        return;
      }
    }
    
    public HashCode hash()
    {
      checkNotDone();
      this.done = true;
      return HashCode.fromBytesNoCopy(this.mac.doFinal());
    }
    
    protected void update(byte paramByte)
    {
      checkNotDone();
      this.mac.update(paramByte);
    }
    
    protected void update(byte[] paramArrayOfByte)
    {
      checkNotDone();
      this.mac.update(paramArrayOfByte);
    }
    
    protected void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      checkNotDone();
      this.mac.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.MacHashFunction
 * JD-Core Version:    0.7.0.1
 */