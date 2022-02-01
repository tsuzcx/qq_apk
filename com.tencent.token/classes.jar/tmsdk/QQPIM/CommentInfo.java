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
    paramObject = (CommentInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.softkey, paramObject.softkey))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.score, paramObject.score))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.comment, paramObject.comment)) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    String str = this.comment;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommentInfo
 * JD-Core Version:    0.7.0.1
 */