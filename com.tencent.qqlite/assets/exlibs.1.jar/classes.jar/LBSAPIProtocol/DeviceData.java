package LBSAPIProtocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class DeviceData
  extends JceStruct
{
  static int cache_eDeviceType;
  static Measure cache_stCurMeasure;
  static ArrayList cache_vMeasures;
  public int eDeviceType = 0;
  public Measure stCurMeasure = null;
  public String strAppUA = "";
  public String strImei = "";
  public ArrayList vMeasures = null;
  
  static
  {
    if (!DeviceData.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DeviceData()
  {
    setStCurMeasure(this.stCurMeasure);
    setVMeasures(this.vMeasures);
    setStrAppUA(this.strAppUA);
    setStrImei(this.strImei);
    setEDeviceType(this.eDeviceType);
  }
  
  public DeviceData(Measure paramMeasure, ArrayList paramArrayList, String paramString1, String paramString2, int paramInt)
  {
    setStCurMeasure(paramMeasure);
    setVMeasures(paramArrayList);
    setStrAppUA(paramString1);
    setStrImei(paramString2);
    setEDeviceType(paramInt);
  }
  
  public String className()
  {
    return "LBSAPIProtocol.DeviceData";
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
    paramStringBuilder.display(this.stCurMeasure, "stCurMeasure");
    paramStringBuilder.display(this.vMeasures, "vMeasures");
    paramStringBuilder.display(this.strAppUA, "strAppUA");
    paramStringBuilder.display(this.strImei, "strImei");
    paramStringBuilder.display(this.eDeviceType, "eDeviceType");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (DeviceData)paramObject;
    return (JceUtil.equals(this.stCurMeasure, paramObject.stCurMeasure)) && (JceUtil.equals(this.vMeasures, paramObject.vMeasures)) && (JceUtil.equals(this.strAppUA, paramObject.strAppUA)) && (JceUtil.equals(this.strImei, paramObject.strImei)) && (JceUtil.equals(this.eDeviceType, paramObject.eDeviceType));
  }
  
  public String fullClassName()
  {
    return "LBSAPIProtocol.DeviceData";
  }
  
  public int getEDeviceType()
  {
    return this.eDeviceType;
  }
  
  public Measure getStCurMeasure()
  {
    return this.stCurMeasure;
  }
  
  public String getStrAppUA()
  {
    return this.strAppUA;
  }
  
  public String getStrImei()
  {
    return this.strImei;
  }
  
  public ArrayList getVMeasures()
  {
    return this.vMeasures;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stCurMeasure == null) {
      cache_stCurMeasure = new Measure();
    }
    setStCurMeasure((Measure)paramJceInputStream.read(cache_stCurMeasure, 0, true));
    if (cache_vMeasures == null)
    {
      cache_vMeasures = new ArrayList();
      Measure localMeasure = new Measure();
      cache_vMeasures.add(localMeasure);
    }
    setVMeasures((ArrayList)paramJceInputStream.read(cache_vMeasures, 1, true));
    setStrAppUA(paramJceInputStream.readString(2, true));
    setStrImei(paramJceInputStream.readString(3, true));
    setEDeviceType(paramJceInputStream.read(this.eDeviceType, 4, true));
  }
  
  public void setEDeviceType(int paramInt)
  {
    this.eDeviceType = paramInt;
  }
  
  public void setStCurMeasure(Measure paramMeasure)
  {
    this.stCurMeasure = paramMeasure;
  }
  
  public void setStrAppUA(String paramString)
  {
    this.strAppUA = paramString;
  }
  
  public void setStrImei(String paramString)
  {
    this.strImei = paramString;
  }
  
  public void setVMeasures(ArrayList paramArrayList)
  {
    this.vMeasures = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCurMeasure, 0);
    paramJceOutputStream.write(this.vMeasures, 1);
    paramJceOutputStream.write(this.strAppUA, 2);
    paramJceOutputStream.write(this.strImei, 3);
    paramJceOutputStream.write(this.eDeviceType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSAPIProtocol.DeviceData
 * JD-Core Version:    0.7.0.1
 */