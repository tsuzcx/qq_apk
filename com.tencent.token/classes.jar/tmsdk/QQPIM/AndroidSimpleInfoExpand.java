package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class AndroidSimpleInfoExpand
  extends JceStruct
  implements Cloneable
{
  static ArrayList<String> dF;
  public ArrayList<String> picurls = null;
  public String recommend = "";
  public int sign = 0;
  public String signature = "";
  
  public AndroidSimpleInfoExpand()
  {
    setRecommend(this.recommend);
    setSign(this.sign);
    setSignature(this.signature);
    setPicurls(this.picurls);
  }
  
  public AndroidSimpleInfoExpand(String paramString1, int paramInt, String paramString2, ArrayList<String> paramArrayList)
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
    paramObject = (AndroidSimpleInfoExpand)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.recommend, paramObject.recommend))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.sign, paramObject.sign))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.signature, paramObject.signature))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.picurls, paramObject.picurls)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.AndroidSimpleInfoExpand";
  }
  
  public ArrayList<String> getPicurls()
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
  
  public void setPicurls(ArrayList<String> paramArrayList)
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
    Object localObject = this.recommend;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.sign, 1);
    localObject = this.signature;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.picurls;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.AndroidSimpleInfoExpand
 * JD-Core Version:    0.7.0.1
 */