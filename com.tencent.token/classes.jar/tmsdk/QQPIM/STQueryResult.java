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
  static ArrayList<STQueryInfo> eO;
  public ArrayList<STQueryInfo> queryinfo = null;
  
  public STQueryResult()
  {
    setQueryinfo(this.queryinfo);
  }
  
  public STQueryResult(ArrayList<STQueryInfo> paramArrayList)
  {
    setQueryinfo(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.STQueryResult";
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
  
  public ArrayList<STQueryInfo> getQueryinfo()
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
  
  public void setQueryinfo(ArrayList<STQueryInfo> paramArrayList)
  {
    this.queryinfo = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.queryinfo;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STQueryResult
 * JD-Core Version:    0.7.0.1
 */