package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class AndroidSimpleInfoExpand
  extends JceStruct
  implements Cloneable
{
  static ArrayList dF;
  public ArrayList picurls = null;
  public String recommend = "";
  public int sign = 0;
  public String signature = "";
  
  static
  {
    if (!AndroidSimpleInfoExpand.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public AndroidSimpleInfoExpand()
  {
    setRecommend(this.recommend);
    setSign(this.sign);
    setSignature(this.signature);
    setPicurls(this.picurls);
  }
  
  public AndroidSimpleInfoExpand(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    setRecommend(paramString1);
    setSign(paramInt);
    setSignature(paramString2);
    setPicurls(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.AndroidSimpleInfoExpand";
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
      paramObject = (AndroidSimpleInfoExpand)paramObject;
    } while ((!JceUtil.equals(this.recommend, paramObject.recommend)) || (!JceUtil.equals(this.sign, paramObject.sign)) || (!JceUtil.equals(this.signature, paramObject.signature)) || (!JceUtil.equals(this.picurls, paramObject.picurls)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.AndroidSimpleInfoExpand";
  }
  
  public ArrayList getPicurls()
  {
    return this.picurls;
  }
  
  public String getRecommend()
  {
    return this.recommend;
  }
  
  public int getSign()
  {
    return this.sign;
  }
  
  public String getSignature()
  {
    return this.signature;
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
    setRecommend(paramJceInputStream.readString(0, false));
    setSign(paramJceInputStream.read(this.sign, 1, false));
    setSignature(paramJceInputStream.readString(2, false));
    if (dF == null)
    {
      dF = new ArrayList();
      dF.add("");
    }
    setPicurls((ArrayList)paramJceInputStream.read(dF, 3, false));
  }
  
  public void setPicurls(ArrayList paramArrayList)
  {
    this.picurls = paramArrayList;
  }
  
  public void setRecommend(String paramString)
  {
    this.recommend = paramString;
  }
  
  public void setSign(int paramInt)
  {
    this.sign = paramInt;
  }
  
  public void setSignature(String paramString)
  {
    this.signature = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.recommend != null) {
      paramJceOutputStream.write(this.recommend, 0);
    }
    paramJceOutputStream.write(this.sign, 1);
    if (this.signature != null) {
      paramJceOutputStream.write(this.signature, 2);
    }
    if (this.picurls != null) {
      paramJceOutputStream.write(this.picurls, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.AndroidSimpleInfoExpand
 * JD-Core Version:    0.7.0.1
 */