package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class CommentInfo
  extends JceStruct
  implements Cloneable
{
  static SoftKey dw;
  public String comment = "";
  public int score = 0;
  public SoftKey softkey = null;
  
  static
  {
    if (!CommentInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CommentInfo()
  {
    setSoftkey(this.softkey);
    setScore(this.score);
    setComment(this.comment);
  }
  
  public CommentInfo(SoftKey paramSoftKey, int paramInt, String paramString)
  {
    setSoftkey(paramSoftKey);
    setScore(paramInt);
    setComment(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CommentInfo";
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
      paramObject = (CommentInfo)paramObject;
    } while ((!JceUtil.equals(this.softkey, paramObject.softkey)) || (!JceUtil.equals(this.score, paramObject.score)) || (!JceUtil.equals(this.comment, paramObject.comment)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CommentInfo";
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public SoftKey getSoftkey()
  {
    return this.softkey;
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
    if (dw == null) {
      dw = new SoftKey();
    }
    setSoftkey((SoftKey)paramJceInputStream.read(dw, 0, true));
    setScore(paramJceInputStream.read(this.score, 1, false));
    setComment(paramJceInputStream.readString(2, false));
  }
  
  public void setComment(String paramString)
  {
    this.comment = paramString;
  }
  
  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }
  
  public void setSoftkey(SoftKey paramSoftKey)
  {
    this.softkey = paramSoftKey;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.softkey, 0);
    paramJceOutputStream.write(this.score, 1);
    if (this.comment != null) {
      paramJceOutputStream.write(this.comment, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommentInfo
 * JD-Core Version:    0.7.0.1
 */