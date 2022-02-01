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
  static ArrayList<CloudInfo> dx;
  public ArrayList<CloudInfo> cloudinfos = null;
  public String newtipsid = "";
  public int nextcheckinterval = 0;
  
  public ServerCmdInfo()
  {
    setCloudinfos(this.cloudinfos);
    setNextcheckinterval(this.nextcheckinterval);
    setNewtipsid(this.newtipsid);
  }
  
  public ServerCmdInfo(ArrayList<CloudInfo> paramArrayList, int paramInt, String paramString)
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
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ServerCmdInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.cloudinfos, paramObject.cloudinfos))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.nextcheckinterval, paramObject.nextcheckinterval))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.newtipsid, paramObject.newtipsid)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ServerCmdInfo";
  }
  
  public ArrayList<CloudInfo> getCloudinfos()
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
  
  public void setCloudinfos(ArrayList<CloudInfo> paramArrayList)
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
    String str = this.newtipsid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ServerCmdInfo
 * JD-Core Version:    0.7.0.1
 */