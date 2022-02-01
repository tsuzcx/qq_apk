package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ConfSrc
  extends JceStruct
  implements Cloneable
{
  static byte[] dj;
  public String checksum = "";
  public byte[] data = null;
  public String filename = "";
  public int isincreupdate = 0;
  public String iuchecksum = "";
  public int rnum = 0;
  public int size = 0;
  public int timestamp = 0;
  public String url = "";
  
  public ConfSrc()
  {
    setFilename(this.filename);
    setChecksum(this.checksum);
    setTimestamp(this.timestamp);
    setUrl(this.url);
    setIsincreupdate(this.isincreupdate);
    setIuchecksum(this.iuchecksum);
    setData(this.data);
    setRnum(this.rnum);
    setSize(this.size);
  }
  
  public ConfSrc(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    setFilename(paramString1);
    setChecksum(paramString2);
    setTimestamp(paramInt1);
    setUrl(paramString3);
    setIsincreupdate(paramInt2);
    setIuchecksum(paramString4);
    setData(paramArrayOfByte);
    setRnum(paramInt3);
    setSize(paramInt4);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ConfSrc";
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
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ConfSrc)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.filename, paramObject.filename))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.checksum, paramObject.checksum))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.timestamp, paramObject.timestamp))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.url, paramObject.url))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.isincreupdate, paramObject.isincreupdate))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.iuchecksum, paramObject.iuchecksum))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.data, paramObject.data))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.rnum, paramObject.rnum))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.size, paramObject.size)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ConfSrc";
  }
  
  public String getChecksum()
  {
    return this.checksum;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public int getIsincreupdate()
  {
    return this.isincreupdate;
  }
  
  public String getIuchecksum()
  {
    return this.iuchecksum;
  }
  
  public int getRnum()
  {
    return this.rnum;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getUrl()
  {
    return this.url;
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
    setFilename(paramJceInputStream.readString(0, true));
    setChecksum(paramJceInputStream.readString(1, true));
    setTimestamp(paramJceInputStream.read(this.timestamp, 2, true));
    setUrl(paramJceInputStream.readString(3, true));
    setIsincreupdate(paramJceInputStream.read(this.isincreupdate, 4, false));
    setIuchecksum(paramJceInputStream.readString(5, false));
    if (dj == null)
    {
      dj = (byte[])new byte[1];
      ((byte[])dj)[0] = 0;
    }
    setData((byte[])paramJceInputStream.read(dj, 6, false));
    setRnum(paramJceInputStream.read(this.rnum, 7, false));
    setSize(paramJceInputStream.read(this.size, 8, false));
  }
  
  public void setChecksum(String paramString)
  {
    this.checksum = paramString;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void setFilename(String paramString)
  {
    this.filename = paramString;
  }
  
  public void setIsincreupdate(int paramInt)
  {
    this.isincreupdate = paramInt;
  }
  
  public void setIuchecksum(String paramString)
  {
    this.iuchecksum = paramString;
  }
  
  public void setRnum(int paramInt)
  {
    this.rnum = paramInt;
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public void setTimestamp(int paramInt)
  {
    this.timestamp = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.filename, 0);
    paramJceOutputStream.write(this.checksum, 1);
    paramJceOutputStream.write(this.timestamp, 2);
    paramJceOutputStream.write(this.url, 3);
    paramJceOutputStream.write(this.isincreupdate, 4);
    Object localObject = this.iuchecksum;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.data;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
    paramJceOutputStream.write(this.rnum, 7);
    paramJceOutputStream.write(this.size, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ConfSrc
 * JD-Core Version:    0.7.0.1
 */