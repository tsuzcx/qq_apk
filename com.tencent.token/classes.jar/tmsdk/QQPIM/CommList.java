package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CommList
  extends JceStruct
  implements Cloneable
{
  static ArrayList<CommElementInfo> dZ;
  public ArrayList<CommElementInfo> vctCommList = null;
  
  public CommList() {}
  
  public CommList(ArrayList<CommElementInfo> paramArrayList)
  {
    this.vctCommList = paramArrayList;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CommList";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vctCommList, "vctCommList");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (CommList)paramObject;
    return JceUtil.equals(this.vctCommList, paramObject.vctCommList);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CommList";
  }
  
  public ArrayList<CommElementInfo> getVctCommList()
  {
    return this.vctCommList;
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
    if (dZ == null)
    {
      dZ = new ArrayList();
      CommElementInfo localCommElementInfo = new CommElementInfo();
      dZ.add(localCommElementInfo);
    }
    this.vctCommList = ((ArrayList)paramJceInputStream.read(dZ, 0, true));
  }
  
  public void setVctCommList(ArrayList<CommElementInfo> paramArrayList)
  {
    this.vctCommList = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vctCommList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommList
 * JD-Core Version:    0.7.0.1
 */