package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class HotWordResInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<HotwordInfo> eA;
  public ArrayList<HotwordInfo> hotwords = null;
  public int totalnum = 0;
  
  static
  {
    if (!HotWordResInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HotWordResInfo()
  {
    setTotalnum(this.totalnum);
    setHotwords(this.hotwords);
  }
  
  public HotWordResInfo(int paramInt, ArrayList<HotwordInfo> paramArrayList)
  {
    setTotalnum(paramInt);
    setHotwords(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.HotWordResInfo";
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
      paramObject = (HotWordResInfo)paramObject;
    } while ((!JceUtil.equals(this.totalnum, paramObject.totalnum)) || (!JceUtil.equals(this.hotwords, paramObject.hotwords)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.HotWordResInfo";
  }
  
  public ArrayList<HotwordInfo> getHotwords()
  {
    return this.hotwords;
  }
  
  public int getTotalnum()
  {
    return this.totalnum;
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
    setTotalnum(paramJceInputStream.read(this.totalnum, 0, true));
    if (eA == null)
    {
      eA = new ArrayList();
      HotwordInfo localHotwordInfo = new HotwordInfo();
      eA.add(localHotwordInfo);
    }
    setHotwords((ArrayList)paramJceInputStream.read(eA, 1, true));
  }
  
  public void setHotwords(ArrayList<HotwordInfo> paramArrayList)
  {
    this.hotwords = paramArrayList;
  }
  
  public void setTotalnum(int paramInt)
  {
    this.totalnum = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalnum, 0);
    paramJceOutputStream.write(this.hotwords, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.HotWordResInfo
 * JD-Core Version:    0.7.0.1
 */