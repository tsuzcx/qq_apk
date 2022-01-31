package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Comment
  extends JceStruct
  implements Cloneable
{
  public String comment = "";
  public int score = 0;
  public String title = "";
  public String user = "";
  
  static
  {
    if (!Comment.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Comment()
  {
    setTitle(this.title);
    setComment(this.comment);
    setUser(this.user);
    setScore(this.score);
  }
  
  public Comment(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    setTitle(paramString1);
    setComment(paramString2);
    setUser(paramString3);
    setScore(paramInt);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.Comment";
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
      paramObject = (Comment)paramObject;
    } while ((!JceUtil.equals(this.title, paramObject.title)) || (!JceUtil.equals(this.comment, paramObject.comment)) || (!JceUtil.equals(this.user, paramObject.user)) || (!JceUtil.equals(this.score, paramObject.score)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.Comment";
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUser()
  {
    return this.user;
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
    setTitle(paramJceInputStream.readString(0, true));
    setComment(paramJceInputStream.readString(1, true));
    setUser(paramJceInputStream.readString(2, true));
    setScore(paramJceInputStream.read(this.score, 3, true));
  }
  
  public void setComment(String paramString)
  {
    this.comment = paramString;
  }
  
  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUser(String paramString)
  {
    this.user = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.title, 0);
    paramJceOutputStream.write(this.comment, 1);
    paramJceOutputStream.write(this.user, 2);
    paramJceOutputStream.write(this.score, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.Comment
 * JD-Core Version:    0.7.0.1
 */