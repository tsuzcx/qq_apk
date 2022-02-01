package wns_proxy;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class HttpRsp
  extends JceStruct
  implements Cloneable
{
  public static final String HTTP_HEADER_END = "\r\n\r\n";
  public static final String HTTP_HEADER_START = "HTTP";
  public String body = "";
  public String rspinfo = "";
  
  public HttpRsp() {}
  
  public HttpRsp(String paramString)
  {
    this.rspinfo = paramString;
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfByte.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.rspinfo, "rspinfo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.rspinfo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (HttpRsp)paramObject;
    return JceUtil.equals(this.rspinfo, paramObject.rspinfo);
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
    this.rspinfo = paramJceInputStream.readString(0, true);
    paramJceInputStream = this.rspinfo;
    if (paramJceInputStream == null) {
      return;
    }
    if (paramJceInputStream.indexOf("HTTP") < 0) {
      return;
    }
    int i = this.rspinfo.indexOf("\r\n\r\n");
    if (i < 0) {
      return;
    }
    this.body = this.rspinfo.substring(i + 4);
  }
  
  public int search(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length <= paramInt) {
        return -1;
      }
      if (paramArrayOfByte2 != null)
      {
        if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
          return -1;
        }
        while ((paramInt < paramArrayOfByte1.length) && (paramArrayOfByte1.length >= paramArrayOfByte2.length + paramInt))
        {
          if (paramInt >= 2147483647) {
            return -1;
          }
          int i = 0;
          while ((i < paramArrayOfByte2.length) && (paramArrayOfByte1[(paramInt + i)] == paramArrayOfByte2[i])) {
            i += 1;
          }
          if (i == paramArrayOfByte2.length) {
            return paramInt;
          }
          paramInt += 1;
        }
      }
    }
    return -1;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rspinfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wns_proxy.HttpRsp
 * JD-Core Version:    0.7.0.1
 */