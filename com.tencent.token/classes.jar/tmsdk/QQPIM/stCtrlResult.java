package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stCtrlResult
  extends JceStruct
  implements Cloneable
{
  public double accuracy = 0.0D;
  public short cmd = 0;
  public String imei = "";
  public double latitude = 0.0D;
  public double longitude = 0.0D;
  public short result = 0;
  public long uin = 0L;
  public long ulkey = 0L;
  
  public stCtrlResult() {}
  
  public stCtrlResult(short paramShort1, short paramShort2, long paramLong1, String paramString, long paramLong2, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.cmd = paramShort1;
    this.result = paramShort2;
    this.uin = paramLong1;
    this.imei = paramString;
    this.ulkey = paramLong2;
    this.longitude = paramDouble1;
    this.latitude = paramDouble2;
    this.accuracy = paramDouble3;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.stCtrlResult";
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
    paramObject = (stCtrlResult)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.cmd, paramObject.cmd))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.result, paramObject.result))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.uin, paramObject.uin))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.imei, paramObject.imei))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.ulkey, paramObject.ulkey))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.longitude, paramObject.longitude))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.latitude, paramObject.latitude))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.accuracy, paramObject.accuracy)) {
                    bool1 = true;
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
    return "tmsdk.QQPIM.stCtrlResult";
  }
  
  public double getAccuracy()
  {
    return this.accuracy;
  }
  
  public short getCmd()
  {
    return this.cmd;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public short getResult()
  {
    return this.result;
  }
  
  public long getUin()
  {
    return this.uin;
  }
  
  public long getUlkey()
  {
    return this.ulkey;
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
    this.cmd = paramJceInputStream.read(this.cmd, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.imei = paramJceInputStream.readString(3, true);
    this.ulkey = paramJceInputStream.read(this.ulkey, 4, true);
    this.longitude = paramJceInputStream.read(this.longitude, 5, false);
    this.latitude = paramJceInputStream.read(this.latitude, 6, false);
    this.accuracy = paramJceInputStream.read(this.accuracy, 7, false);
  }
  
  public void setAccuracy(double paramDouble)
  {
    this.accuracy = paramDouble;
  }
  
  public void setCmd(short paramShort)
  {
    this.cmd = paramShort;
  }
  
  public void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
  
  public void setResult(short paramShort)
  {
    this.result = paramShort;
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
  }
  
  public void setUlkey(long paramLong)
  {
    this.ulkey = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.imei, 3);
    paramJceOutputStream.write(this.ulkey, 4);
    paramJceOutputStream.write(this.longitude, 5);
    paramJceOutputStream.write(this.latitude, 6);
    paramJceOutputStream.write(this.accuracy, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.stCtrlResult
 * JD-Core Version:    0.7.0.1
 */