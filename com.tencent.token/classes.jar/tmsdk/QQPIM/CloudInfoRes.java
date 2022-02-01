package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CloudInfoRes
  extends JceStruct
  implements Cloneable
{
  static ArrayList<CloudCmdRes> dV;
  public int action = 0;
  public ArrayList<CloudCmdRes> cmdres = null;
  public int confirmtype = 0;
  public int phase = 0;
  public int res = 0;
  public int time = 0;
  public String tipsid = "";
  
  static
  {
    if (!CloudInfoRes.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CloudInfoRes()
  {
    setTipsid(this.tipsid);
    setAction(this.action);
    setRes(this.res);
    setCmdres(this.cmdres);
    setPhase(this.phase);
    setConfirmtype(this.confirmtype);
    setTime(this.time);
  }
  
  public CloudInfoRes(String paramString, int paramInt1, int paramInt2, ArrayList<CloudCmdRes> paramArrayList, int paramInt3, int paramInt4, int paramInt5)
  {
    setTipsid(paramString);
    setAction(paramInt1);
    setRes(paramInt2);
    setCmdres(paramArrayList);
    setPhase(paramInt3);
    setConfirmtype(paramInt4);
    setTime(paramInt5);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CloudInfoRes";
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
      paramObject = (CloudInfoRes)paramObject;
    } while ((!JceUtil.equals(this.tipsid, paramObject.tipsid)) || (!JceUtil.equals(this.action, paramObject.action)) || (!JceUtil.equals(this.res, paramObject.res)) || (!JceUtil.equals(this.cmdres, paramObject.cmdres)) || (!JceUtil.equals(this.phase, paramObject.phase)) || (!JceUtil.equals(this.confirmtype, paramObject.confirmtype)) || (!JceUtil.equals(this.time, paramObject.time)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CloudInfoRes";
  }
  
  public int getAction()
  {
    return this.action;
  }
  
  public ArrayList<CloudCmdRes> getCmdres()
  {
    return this.cmdres;
  }
  
  public int getConfirmtype()
  {
    return this.confirmtype;
  }
  
  public int getPhase()
  {
    return this.phase;
  }
  
  public int getRes()
  {
    return this.res;
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public String getTipsid()
  {
    return this.tipsid;
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
    setTipsid(paramJceInputStream.readString(1, true));
    setAction(paramJceInputStream.read(this.action, 2, true));
    setRes(paramJceInputStream.read(this.res, 3, true));
    if (dV == null)
    {
      dV = new ArrayList();
      CloudCmdRes localCloudCmdRes = new CloudCmdRes();
      dV.add(localCloudCmdRes);
    }
    setCmdres((ArrayList)paramJceInputStream.read(dV, 4, true));
    setPhase(paramJceInputStream.read(this.phase, 5, false));
    setConfirmtype(paramJceInputStream.read(this.confirmtype, 6, false));
    setTime(paramJceInputStream.read(this.time, 7, false));
  }
  
  public void setAction(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void setCmdres(ArrayList<CloudCmdRes> paramArrayList)
  {
    this.cmdres = paramArrayList;
  }
  
  public void setConfirmtype(int paramInt)
  {
    this.confirmtype = paramInt;
  }
  
  public void setPhase(int paramInt)
  {
    this.phase = paramInt;
  }
  
  public void setRes(int paramInt)
  {
    this.res = paramInt;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void setTipsid(String paramString)
  {
    this.tipsid = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tipsid, 1);
    paramJceOutputStream.write(this.action, 2);
    paramJceOutputStream.write(this.res, 3);
    paramJceOutputStream.write(this.cmdres, 4);
    paramJceOutputStream.write(this.phase, 5);
    paramJceOutputStream.write(this.confirmtype, 6);
    paramJceOutputStream.write(this.time, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudInfoRes
 * JD-Core Version:    0.7.0.1
 */