package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class NetInterfaceTypeInfoList
  extends JceStruct
  implements Cloneable
{
  static ArrayList eE;
  public ArrayList vctInterfaceInfos = null;
  
  static
  {
    if (!NetInterfaceTypeInfoList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public NetInterfaceTypeInfoList() {}
  
  public NetInterfaceTypeInfoList(ArrayList paramArrayList)
  {
    this.vctInterfaceInfos = paramArrayList;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.NetInterfaceTypeInfoList";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vctInterfaceInfos, "vctInterfaceInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (NetInterfaceTypeInfoList)paramObject;
    return JceUtil.equals(this.vctInterfaceInfos, paramObject.vctInterfaceInfos);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.NetInterfaceTypeInfoList";
  }
  
  public ArrayList getVctInterfaceInfos()
  {
    return this.vctInterfaceInfos;
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
    if (eE == null)
    {
      eE = new ArrayList();
      NetInterfaceTypeInfo localNetInterfaceTypeInfo = new NetInterfaceTypeInfo();
      eE.add(localNetInterfaceTypeInfo);
    }
    this.vctInterfaceInfos = ((ArrayList)paramJceInputStream.read(eE, 0, true));
  }
  
  public void setVctInterfaceInfos(ArrayList paramArrayList)
  {
    this.vctInterfaceInfos = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vctInterfaceInfos, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.NetInterfaceTypeInfoList
 * JD-Core Version:    0.7.0.1
 */