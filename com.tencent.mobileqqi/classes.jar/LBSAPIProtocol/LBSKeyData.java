package LBSAPIProtocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class LBSKeyData
  extends JceStruct
{
  static byte[] cache_vAuthName;
  static byte[] cache_vEncryptData;
  public byte[] vAuthName = null;
  public byte[] vEncryptData = null;
  
  static
  {
    if (!LBSKeyData.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public LBSKeyData()
  {
    setVAuthName(this.vAuthName);
    setVEncryptData(this.vEncryptData);
  }
  
  public LBSKeyData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    setVAuthName(paramArrayOfByte1);
    setVEncryptData(paramArrayOfByte2);
  }
  
  public String className()
  {
    return "LBSAPIProtocol.LBSKeyData";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.vAuthName, "vAuthName");
    paramStringBuilder.display(this.vEncryptData, "vEncryptData");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (LBSKeyData)paramObject;
    return (JceUtil.equals(this.vAuthName, paramObject.vAuthName)) && (JceUtil.equals(this.vEncryptData, paramObject.vEncryptData));
  }
  
  public byte[] getVAuthName()
  {
    return this.vAuthName;
  }
  
  public byte[] getVEncryptData()
  {
    return this.vEncryptData;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vAuthName == null)
    {
      cache_vAuthName = (byte[])new byte[1];
      ((byte[])cache_vAuthName)[0] = 0;
    }
    setVAuthName((byte[])paramJceInputStream.read(cache_vAuthName, 0, true));
    if (cache_vEncryptData == null)
    {
      cache_vEncryptData = (byte[])new byte[1];
      ((byte[])cache_vEncryptData)[0] = 0;
    }
    setVEncryptData((byte[])paramJceInputStream.read(cache_vEncryptData, 1, true));
  }
  
  public void setVAuthName(byte[] paramArrayOfByte)
  {
    this.vAuthName = paramArrayOfByte;
  }
  
  public void setVEncryptData(byte[] paramArrayOfByte)
  {
    this.vEncryptData = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vAuthName, 0);
    paramJceOutputStream.write(this.vEncryptData, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     LBSAPIProtocol.LBSKeyData
 * JD-Core Version:    0.7.0.1
 */