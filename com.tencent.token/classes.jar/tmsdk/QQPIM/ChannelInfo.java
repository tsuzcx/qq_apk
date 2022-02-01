package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class ChannelInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<SoftKey> dN;
  public ArrayList<SoftKey> checksoft = null;
  public String id = "";
  public int isbuildin = 0;
  public int product = EProduct.EP_None.value();
  public String token = "";
  
  public ChannelInfo()
  {
    setId(this.id);
    setProduct(this.product);
    setIsbuildin(this.isbuildin);
    setToken(this.token);
    setChecksoft(this.checksoft);
  }
  
  public ChannelInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<SoftKey> paramArrayList)
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
    paramObject = (ChannelInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.product, paramObject.product))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.isbuildin, paramObject.isbuildin))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.token, paramObject.token))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.checksoft, paramObject.checksoft)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ChannelInfo";
  }
  
  public ArrayList<SoftKey> getChecksoft()
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
  
  public void setChecksoft(ArrayList<SoftKey> paramArrayList)
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
    Object localObject = this.token;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.checksoft;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */