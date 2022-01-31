package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class ServerCmdInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList dx;
  public ArrayList cloudinfos = null;
  public String newtipsid = "";
  public int nextcheckinterval = 0;
  
  static
  {
    if (!ServerCmdInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ServerCmdInfo()
  {
    setCloudinfos(this.cloudinfos);
    setNextcheckinterval(this.nextcheckinterval);
    setNewtipsid(this.newtipsid);
  }
  
  public ServerCmdInfo(ArrayList paramArrayList, int paramInt, String paramString)
  {
    setCloudinfos(paramArrayList);
    setNextcheckinterval(paramInt);
    setNewtipsid(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ServerCmdInfo";
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
      paramObject = (ServerCmdInfo)paramObject;
    } while ((!JceUtil.equals(this.cloudinfos, paramObject.cloudinfos)) || (!JceUtil.equals(this.nextcheckinterval, paramObject.nextcheckinterval)) || (!JceUtil.equals(this.newtipsid, paramObject.newtipsid)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ServerCmdInfo";
  }
  
  public ArrayList getCloudinfos()
  {
    return this.cloudinfos;
  }
  
  public String getNewtipsid()
  {
    return this.newtipsid;
  }
  
  public int getNextcheckinterval()
  {
    return this.nextcheckinterval;
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
    if (dx == null)
    {
      dx = new ArrayList();
      CloudInfo localCloudInfo = new CloudInfo();
      dx.add(localCloudInfo);
    }
    setCloudinfos((ArrayList)paramJceInputStream.read(dx, 1, true));
    setNextcheckinterval(paramJceInputStream.read(this.nextcheckinterval, 2, true));
    setNewtipsid(paramJceInputStream.readString(3, false));
  }
  
  public void setCloudinfos(ArrayList paramArrayList)
  {
    this.cloudinfos = paramArrayList;
  }
  
  public void setNewtipsid(String paramString)
  {
    this.newtipsid = paramString;
  }
  
  public void setNextcheckinterval(int paramInt)
  {
    this.nextcheckinterval = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cloudinfos, 1);
    paramJceOutputStream.write(this.nextcheckinterval, 2);
    if (this.newtipsid != null) {
      paramJceOutputStream.write(this.newtipsid, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ServerCmdInfo
 * JD-Core Version:    0.7.0.1
 */