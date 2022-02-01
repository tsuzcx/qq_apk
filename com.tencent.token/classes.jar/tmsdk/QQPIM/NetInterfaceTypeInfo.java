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
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.typeName, "typeName");
    paramStringBuilder.display(this.keySet, "keySet");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (NetInterfaceTypeInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.typeName, paramObject.typeName))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.keySet, paramObject.keySet)) {
        bool1 = true;
      }
    }
    return bool1;
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
    ArrayList localArrayList = this.keySet;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.NetInterfaceTypeInfo
 * JD-Core Version:    0.7.0.1
 */