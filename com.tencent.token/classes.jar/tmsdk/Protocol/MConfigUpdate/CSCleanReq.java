package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CSCleanReq
  extends JceStruct
  implements Cloneable
{
  static ArrayList bt;
  public ArrayList vecReq = null;
  
  static
  {
    if (!CSCleanReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CSCleanReq() {}
  
  public CSCleanReq(ArrayList paramArrayList)
  {
    this.vecReq = paramArrayList;
  }
  
  public String className()
  {
    return "MConfigUpdate.CSCleanReq";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vecReq, "vecReq");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (CSCleanReq)paramObject;
    return JceUtil.equals(this.vecReq, paramObject.vecReq);
  }
  
  public String fullClassName()
  {
    return "MConfigUpdate.CSCleanReq";
  }
  
  public ArrayList getVecReq()
  {
    return this.vecReq;
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
    if (bt == null)
    {
      bt = new ArrayList();
      stDirInfo localstDirInfo = new stDirInfo();
      bt.add(localstDirInfo);
    }
    this.vecReq = ((ArrayList)paramJceInputStream.read(bt, 0, true));
  }
  
  public void setVecReq(ArrayList paramArrayList)
  {
    this.vecReq = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.CSCleanReq
 * JD-Core Version:    0.7.0.1
 */