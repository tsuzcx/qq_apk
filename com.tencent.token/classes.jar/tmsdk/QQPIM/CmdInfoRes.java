package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CmdInfoRes
  extends JceStruct
  implements Cloneable
{
  static ArrayList<CloudInfoRes> dW;
  public ArrayList<CloudInfoRes> infores = null;
  
  static
  {
    if (!CmdInfoRes.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CmdInfoRes()
  {
    setInfores(this.infores);
  }
  
  public CmdInfoRes(ArrayList<CloudInfoRes> paramArrayList)
  {
    setInfores(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CmdInfoRes";
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
    if (paramObject == null) {
      return false;
    }
    paramObject = (CmdInfoRes)paramObject;
    return JceUtil.equals(this.infores, paramObject.infores);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CmdInfoRes";
  }
  
  public ArrayList<CloudInfoRes> getInfores()
  {
    return this.infores;
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
    if (dW == null)
    {
      dW = new ArrayList();
      CloudInfoRes localCloudInfoRes = new CloudInfoRes();
      dW.add(localCloudInfoRes);
    }
    setInfores((ArrayList)paramJceInputStream.read(dW, 1, true));
  }
  
  public void setInfores(ArrayList<CloudInfoRes> paramArrayList)
  {
    this.infores = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.infores, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CmdInfoRes
 * JD-Core Version:    0.7.0.1
 */