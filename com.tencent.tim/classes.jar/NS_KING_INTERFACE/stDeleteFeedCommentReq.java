package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaComment;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stDeleteFeedCommentReq
  extends JceStruct
  implements Cloneable
{
  static stMetaComment cache_comment;
  public stMetaComment comment;
  public String feed_id = "";
  
  static
  {
    if (!stDeleteFeedCommentReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_comment = new stMetaComment();
      return;
    }
  }
  
  public stDeleteFeedCommentReq() {}
  
  public stDeleteFeedCommentReq(String paramString, stMetaComment paramstMetaComment)
  {
    this.feed_id = paramString;
    this.comment = paramstMetaComment;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.comment, "comment");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.comment, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stDeleteFeedCommentReq)paramObject;
    } while ((!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.comment, paramObject.comment)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stDeleteFeedCommentReq";
  }
  
  public stMetaComment getComment()
  {
    return this.comment;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
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
    this.feed_id = paramJceInputStream.readString(0, true);
    this.comment = ((stMetaComment)paramJceInputStream.read(cache_comment, 1, true));
  }
  
  public void setComment(stMetaComment paramstMetaComment)
  {
    this.comment = paramstMetaComment;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_id, 0);
    paramJceOutputStream.write(this.comment, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stDeleteFeedCommentReq
 * JD-Core Version:    0.7.0.1
 */