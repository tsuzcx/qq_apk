package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class NetInterfaceTypeInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<String> eD;
  public ArrayList<String> keySet = null;
  public String typeName = "";
  
  static
  {
    if (!NetInterfaceTypeInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public NetInterfaceTypeInfo() {}
  
  public NetInterfaceTypeInfo(String paramString, ArrayList<String> paramArrayList)
  {
    this.typeName = paramString;
    this.keySet = paramArrayList;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.NetInterfaceTypeInfo";
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
    paramStringBuilder.display(this.typeName, "typeName");
    paramStringBuilder.display(this.keySet, "keySet");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (NetInterfaceTypeInfo)paramObject;
    } while ((!JceUtil.equals(this.typeName, paramObject.typeName)) || (!JceUtil.equals(this.keySet, paramObject.keySet)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.NetInterfaceTypeInfo";
  }
  
  public ArrayList<String> getKeySet()
  {
    return this.keySet;
  }
  
  public String getTypeName()
  {
    return this.typeName;
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
    this.typeName = paramJceInputStream.readString(0, true);
    if (eD == null)
    {
      eD = new ArrayList();
      eD.add("");
    }
    this.keySet = ((ArrayList)paramJceInputStream.read(eD, 1, false));
  }
  
  public void setKeySet(ArrayList<String> paramArrayList)
  {
    this.keySet = paramArrayList;
  }
  
  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.typeName, 0);
    if (this.keySet != null) {
      paramJceOutputStream.write(this.keySet, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.NetInterfaceTypeInfo
 * JD-Core Version:    0.7.0.1
 */