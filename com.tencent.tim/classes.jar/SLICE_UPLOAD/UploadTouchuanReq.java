package SLICE_UPLOAD;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UploadTouchuanReq
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_vReqData;
  public int iUploadType = 0;
  public byte[] vReqData = null;
  
  static
  {
    if (!UploadTouchuanReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_vReqData = (byte[])new byte[1];
      ((byte[])cache_vReqData)[0] = 0;
      return;
    }
  }
  
  public UploadTouchuanReq() {}
  
  public UploadTouchuanReq(int paramInt, byte[] paramArrayOfByte)
  {
    this.iUploadType = paramInt;
    this.vReqData = paramArrayOfByte;
  }
  
  public String className()
  {
    return "SLICE_UPLOAD.UploadTouchuanReq";
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
    paramStringBuilder.display(this.iUploadType, "iUploadType");
    paramStringBuilder.display(this.vReqData, "vReqData");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iUploadType, true);
    paramStringBuilder.displaySimple(this.vReqData, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UploadTouchuanReq)paramObject;
    } while ((!JceUtil.equals(this.iUploadType, paramObject.iUploadType)) || (!JceUtil.equals(this.vReqData, paramObject.vReqData)));
    return true;
  }
  
  public String fullClassName()
  {
    return "SLICE_UPLOAD.UploadTouchuanReq";
  }
  
  public int getIUploadType()
  {
    return this.iUploadType;
  }
  
  public byte[] getVReqData()
  {
    return this.vReqData;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUploadType = paramJceInputStream.read(this.iUploadType, 0, true);
    this.vReqData = ((byte[])paramJceInputStream.read(cache_vReqData, 1, true));
  }
  
  public void setIUploadType(int paramInt)
  {
    this.iUploadType = paramInt;
  }
  
  public void setVReqData(byte[] paramArrayOfByte)
  {
    this.vReqData = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUploadType, 0);
    paramJceOutputStream.write(this.vReqData, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.UploadTouchuanReq
 * JD-Core Version:    0.7.0.1
 */