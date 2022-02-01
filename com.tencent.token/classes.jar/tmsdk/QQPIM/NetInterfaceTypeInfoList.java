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
  static ArrayList<NetInterfaceTypeInfo> eE;
  public ArrayList<NetInterfaceTypeInfo> vctInterfaceInfos = null;
  
  public NetInterfaceTypeInfoList() {}
  
  public NetInterfaceTypeInfoList(ArrayList<NetInterfaceTypeInfo> paramArrayList)
  {
    this.vctInterfaceInfos = paramArrayList;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.NetInterfaceTypeInfoList";
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
  
  public ArrayList<NetInterfaceTypeInfo> getVctInterfaceInfos()
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
  
  public void setVctInterfaceInfos(ArrayList<NetInterfaceTypeInfo> paramArrayList)
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