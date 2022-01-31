package LBSAPIProtocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqHeader
  extends JceStruct
{
  static int cache_eDeviceType;
  static int cache_eUinType;
  public int eDeviceType = 0;
  public int eUinType = 0;
  public short shVersion = 1;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public String strUin = "";
  
  static
  {
    if (!ReqHeader.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqHeader()
  {
    setShVersion(this.shVersion);
    setEUinType(this.eUinType);
    setStrUin(this.strUin);
    setStrAuthName(this.strAuthName);
    setStrAuthPassword(this.strAuthPassword);
    setEDeviceType(this.eDeviceType);
  }
  
  public ReqHeader(short paramShort, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    setShVersion(paramShort);
    setEUinType(paramInt1);
    setStrUin(paramString1);
    setStrAuthName(paramString2);
    setStrAuthPassword(paramString3);
    setEDeviceType(paramInt2);
  }
  
  public String className()
  {
    return "LBSAPIProtocol.ReqHeader";
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
    paramStringBuilder.display(this.shVersion, "shVersion");
    paramStringBuilder.display(this.eUinType, "eUinType");
    paramStringBuilder.display(this.strUin, "strUin");
    paramStringBuilder.display(this.strAuthName, "strAuthName");
    paramStringBuilder.display(this.strAuthPassword, "strAuthPassword");
    paramStringBuilder.display(this.eDeviceType, "eDeviceType");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ReqHeader)paramObject;
    return (JceUtil.equals(this.shVersion, paramObject.shVersion)) && (JceUtil.equals(this.eUinType, paramObject.eUinType)) && (JceUtil.equals(this.strUin, paramObject.strUin)) && (JceUtil.equals(this.strAuthName, paramObject.strAuthName)) && (JceUtil.equals(this.strAuthPassword, paramObject.strAuthPassword)) && (JceUtil.equals(this.eDeviceType, paramObject.eDeviceType));
  }
  
  public String fullClassName()
  {
    return "LBSAPIProtocol.ReqHeader";
  }
  
  public int getEDeviceType()
  {
    return this.eDeviceType;
  }
  
  public int getEUinType()
  {
    return this.eUinType;
  }
  
  public short getShVersion()
  {
    return this.shVersion;
  }
  
  public String getStrAuthName()
  {
    return this.strAuthName;
  }
  
  public String getStrAuthPassword()
  {
    return this.strAuthPassword;
  }
  
  public String getStrUin()
  {
    return this.strUin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setShVersion(paramJceInputStream.read(this.shVersion, 0, true));
    setEUinType(paramJceInputStream.read(this.eUinType, 1, true));
    setStrUin(paramJceInputStream.readString(2, true));
    setStrAuthName(paramJceInputStream.readString(3, true));
    setStrAuthPassword(paramJceInputStream.readString(4, true));
    setEDeviceType(paramJceInputStream.read(this.eDeviceType, 5, false));
  }
  
  public void setEDeviceType(int paramInt)
  {
    this.eDeviceType = paramInt;
  }
  
  public void setEUinType(int paramInt)
  {
    this.eUinType = paramInt;
  }
  
  public void setShVersion(short paramShort)
  {
    this.shVersion = paramShort;
  }
  
  public void setStrAuthName(String paramString)
  {
    this.strAuthName = paramString;
  }
  
  public void setStrAuthPassword(String paramString)
  {
    this.strAuthPassword = paramString;
  }
  
  public void setStrUin(String paramString)
  {
    this.strUin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.eUinType, 1);
    paramJceOutputStream.write(this.strUin, 2);
    paramJceOutputStream.write(this.strAuthName, 3);
    paramJceOutputStream.write(this.strAuthPassword, 4);
    paramJceOutputStream.write(this.eDeviceType, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSAPIProtocol.ReqHeader
 * JD-Core Version:    0.7.0.1
 */