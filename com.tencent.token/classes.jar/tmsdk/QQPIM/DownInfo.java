package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class DownInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<DownSoftInfo> ed;
  public ArrayList<DownSoftInfo> listDownSoftItems = null;
  public int nGUID = 0;
  public String sQUA = "";
  
  static
  {
    if (!DownInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DownInfo()
  {
    setSQUA(this.sQUA);
    setNGUID(this.nGUID);
    setListDownSoftItems(this.listDownSoftItems);
  }
  
  public DownInfo(String paramString, int paramInt, ArrayList<DownSoftInfo> paramArrayList)
  {
    setSQUA(paramString);
    setNGUID(paramInt);
    setListDownSoftItems(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.DownInfo";
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (DownInfo)paramObject;
    } while ((!JceUtil.equals(this.sQUA, paramObject.sQUA)) || (!JceUtil.equals(this.nGUID, paramObject.nGUID)) || (!JceUtil.equals(this.listDownSoftItems, paramObject.listDownSoftItems)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.DownInfo";
  }
  
  public ArrayList<DownSoftInfo> getListDownSoftItems()
  {
    return this.listDownSoftItems;
  }
  
  public int getNGUID()
  {
    return this.nGUID;
  }
  
  public String getSQUA()
  {
    return this.sQUA;
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
    setSQUA(paramJceInputStream.readString(0, true));
    setNGUID(paramJceInputStream.read(this.nGUID, 1, true));
    if (ed == null)
    {
      ed = new ArrayList();
      DownSoftInfo localDownSoftInfo = new DownSoftInfo();
      ed.add(localDownSoftInfo);
    }
    setListDownSoftItems((ArrayList)paramJceInputStream.read(ed, 2, true));
  }
  
  public void setListDownSoftItems(ArrayList<DownSoftInfo> paramArrayList)
  {
    this.listDownSoftItems = paramArrayList;
  }
  
  public void setNGUID(int paramInt)
  {
    this.nGUID = paramInt;
  }
  
  public void setSQUA(String paramString)
  {
    this.sQUA = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sQUA, 0);
    paramJceOutputStream.write(this.nGUID, 1);
    paramJceOutputStream.write(this.listDownSoftItems, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.DownInfo
 * JD-Core Version:    0.7.0.1
 */