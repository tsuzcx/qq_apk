package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class ChannelInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList dN;
  public ArrayList checksoft = null;
  public String id = "";
  public int isbuildin = 0;
  public int product = EProduct.EP_None.value();
  public String token = "";
  
  static
  {
    if (!ChannelInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ChannelInfo()
  {
    setId(this.id);
    setProduct(this.product);
    setIsbuildin(this.isbuildin);
    setToken(this.token);
    setChecksoft(this.checksoft);
  }
  
  public ChannelInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList paramArrayList)
  {
    setId(paramString1);
    setProduct(paramInt1);
    setIsbuildin(paramInt2);
    setToken(paramString2);
    setChecksoft(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ChannelInfo";
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
      paramObject = (ChannelInfo)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.product, paramObject.product)) || (!JceUtil.equals(this.isbuildin, paramObject.isbuildin)) || (!JceUtil.equals(this.token, paramObject.token)) || (!JceUtil.equals(this.checksoft, paramObject.checksoft)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ChannelInfo";
  }
  
  public ArrayList getChecksoft()
  {
    return this.checksoft;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getIsbuildin()
  {
    return this.isbuildin;
  }
  
  public int getProduct()
  {
    return this.product;
  }
  
  public String getToken()
  {
    return this.token;
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
    setId(paramJceInputStream.readString(0, true));
    setProduct(paramJceInputStream.read(this.product, 1, false));
    setIsbuildin(paramJceInputStream.read(this.isbuildin, 2, false));
    setToken(paramJceInputStream.readString(3, false));
    if (dN == null)
    {
      dN = new ArrayList();
      SoftKey localSoftKey = new SoftKey();
      dN.add(localSoftKey);
    }
    setChecksoft((ArrayList)paramJceInputStream.read(dN, 4, false));
  }
  
  public void setChecksoft(ArrayList paramArrayList)
  {
    this.checksoft = paramArrayList;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setIsbuildin(int paramInt)
  {
    this.isbuildin = paramInt;
  }
  
  public void setProduct(int paramInt)
  {
    this.product = paramInt;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.product, 1);
    paramJceOutputStream.write(this.isbuildin, 2);
    if (this.token != null) {
      paramJceOutputStream.write(this.token, 3);
    }
    if (this.checksoft != null) {
      paramJceOutputStream.write(this.checksoft, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */