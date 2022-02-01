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
    paramObject = (HotWordResInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.totalnum, paramObject.totalnum))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.hotwords, paramObject.hotwords)) {
        bool1 = true;
      }
    }
    return bool1;
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