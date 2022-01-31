package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class ScanTypeInfoList
  extends JceStruct
  implements Cloneable
{
  static ArrayList eU;
  public ArrayList vctscans = null;
  
  static
  {
    if (!ScanTypeInfoList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ScanTypeInfoList() {}
  
  public ScanTypeInfoList(ArrayList paramArrayList)
  {
    this.vctscans = paramArrayList;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ScanTypeInfoList";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vctscans, "vctscans");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (ScanTypeInfoList)paramObject;
    return JceUtil.equals(this.vctscans, paramObject.vctscans);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ScanTypeInfoList";
  }
  
  public ArrayList getVctscans()
  {
    return this.vctscans;
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
    if (eU == null)
    {
      eU = new ArrayList();
      ScanTypeInfo localScanTypeInfo = new ScanTypeInfo();
      eU.add(localScanTypeInfo);
    }
    this.vctscans = ((ArrayList)paramJceInputStream.read(eU, 0, true));
  }
  
  public void setVctscans(ArrayList paramArrayList)
  {
    this.vctscans = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vctscans, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ScanTypeInfoList
 * JD-Core Version:    0.7.0.1
 */