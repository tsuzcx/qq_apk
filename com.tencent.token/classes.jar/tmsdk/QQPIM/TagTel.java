package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TagTel
  extends JceStruct
  implements Cloneable
{
  public int black = 0;
  public String phonenum = "";
  public String tagmsg = "";
  public int tagtype = 0;
  public int white = 0;
  
  static
  {
    if (!TagTel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TagTel()
  {
    setPhonenum(this.phonenum);
    setWhite(this.white);
    setBlack(this.black);
    setTagtype(this.tagtype);
    setTagmsg(this.tagmsg);
  }
  
  public TagTel(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    setPhonenum(paramString1);
    setWhite(paramInt1);
    setBlack(paramInt2);
    setTagtype(paramInt3);
    setTagmsg(paramString2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.TagTel";
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
      paramObject = (TagTel)paramObject;
    } while ((!JceUtil.equals(this.phonenum, paramObject.phonenum)) || (!JceUtil.equals(this.white, paramObject.white)) || (!JceUtil.equals(this.black, paramObject.black)) || (!JceUtil.equals(this.tagtype, paramObject.tagtype)) || (!JceUtil.equals(this.tagmsg, paramObject.tagmsg)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.TagTel";
  }
  
  public int getBlack()
  {
    return this.black;
  }
  
  public String getPhonenum()
  {
    return this.phonenum;
  }
  
  public String getTagmsg()
  {
    return this.tagmsg;
  }
  
  public int getTagtype()
  {
    return this.tagtype;
  }
  
  public int getWhite()
  {
    return this.white;
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
    setPhonenum(paramJceInputStream.readString(0, true));
    setWhite(paramJceInputStream.read(this.white, 1, false));
    setBlack(paramJceInputStream.read(this.black, 2, false));
    setTagtype(paramJceInputStream.read(this.tagtype, 3, false));
    setTagmsg(paramJceInputStream.readString(4, false));
  }
  
  public void setBlack(int paramInt)
  {
    this.black = paramInt;
  }
  
  public void setPhonenum(String paramString)
  {
    this.phonenum = paramString;
  }
  
  public void setTagmsg(String paramString)
  {
    this.tagmsg = paramString;
  }
  
  public void setTagtype(int paramInt)
  {
    this.tagtype = paramInt;
  }
  
  public void setWhite(int paramInt)
  {
    this.white = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.phonenum, 0);
    paramJceOutputStream.write(this.white, 1);
    paramJceOutputStream.write(this.black, 2);
    paramJceOutputStream.write(this.tagtype, 3);
    if (this.tagmsg != null) {
      paramJceOutputStream.write(this.tagmsg, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TagTel
 * JD-Core Version:    0.7.0.1
 */