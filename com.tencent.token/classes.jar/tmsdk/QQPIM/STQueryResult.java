package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class STQueryResult
  extends JceStruct
  implements Cloneable
{
  static ArrayList eO;
  public ArrayList queryinfo = null;
  
  static
  {
    if (!STQueryResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public STQueryResult()
  {
    setQueryinfo(this.queryinfo);
  }
  
  public STQueryResult(ArrayList paramArrayList)
  {
    setQueryinfo(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.STQueryResult";
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
    paramObject = (STQueryResult)paramObject;
    return JceUtil.equals(this.queryinfo, paramObject.queryinfo);
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.STQueryResult";
  }
  
  public ArrayList getQueryinfo()
  {
    return this.queryinfo;
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
    if (eO == null)
    {
      eO = new ArrayList();
      STQueryInfo localSTQueryInfo = new STQueryInfo();
      eO.add(localSTQueryInfo);
    }
    setQueryinfo((ArrayList)paramJceInputStream.read(eO, 0, false));
  }
  
  public void setQueryinfo(ArrayList paramArrayList)
  {
    this.queryinfo = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.queryinfo != null) {
      paramJceOutputStream.write(this.queryinfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STQueryResult
 * JD-Core Version:    0.7.0.1
 */