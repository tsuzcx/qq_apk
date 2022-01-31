package LBSAPIProtocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class GPS
  extends JceStruct
{
  static int cache_eType;
  public int eType = 0;
  public int iAlt = -1;
  public int iLat = 900000000;
  public int iLon = 900000000;
  
  static
  {
    if (!GPS.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GPS()
  {
    setILat(this.iLat);
    setILon(this.iLon);
    setIAlt(this.iAlt);
    setEType(this.eType);
  }
  
  public GPS(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setILat(paramInt1);
    setILon(paramInt2);
    setIAlt(paramInt3);
    setEType(paramInt4);
  }
  
  public String className()
  {
    return "LBSAPIProtocol.GPS";
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
    paramStringBuilder.display(this.iLat, "iLat");
    paramStringBuilder.display(this.iLon, "iLon");
    paramStringBuilder.display(this.iAlt, "iAlt");
    paramStringBuilder.display(this.eType, "eType");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (GPS)paramObject;
    return (JceUtil.equals(this.iLat, paramObject.iLat)) && (JceUtil.equals(this.iLon, paramObject.iLon)) && (JceUtil.equals(this.iAlt, paramObject.iAlt)) && (JceUtil.equals(this.eType, paramObject.eType));
  }
  
  public String fullClassName()
  {
    return "LBSAPIProtocol.GPS";
  }
  
  public int getEType()
  {
    return this.eType;
  }
  
  public int getIAlt()
  {
    return this.iAlt;
  }
  
  public int getILat()
  {
    return this.iLat;
  }
  
  public int getILon()
  {
    return this.iLon;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setILat(paramJceInputStream.read(this.iLat, 0, true));
    setILon(paramJceInputStream.read(this.iLon, 1, true));
    setIAlt(paramJceInputStream.read(this.iAlt, 2, true));
    setEType(paramJceInputStream.read(this.eType, 3, true));
  }
  
  public void setEType(int paramInt)
  {
    this.eType = paramInt;
  }
  
  public void setIAlt(int paramInt)
  {
    this.iAlt = paramInt;
  }
  
  public void setILat(int paramInt)
  {
    this.iLat = paramInt;
  }
  
  public void setILon(int paramInt)
  {
    this.iLon = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.iAlt, 2);
    paramJceOutputStream.write(this.eType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     LBSAPIProtocol.GPS
 * JD-Core Version:    0.7.0.1
 */