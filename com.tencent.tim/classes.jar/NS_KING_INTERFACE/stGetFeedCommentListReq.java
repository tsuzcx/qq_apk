package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stGetFeedCommentListReq
  extends JceStruct
  implements Cloneable
{
  public String attach_info = "";
  public String commentId = "";
  public String feed_id = "";
  public int getRepyListByPage;
  public String replyId = "";
  public int reqFrom;
  
  static
  {
    if (!stGetFeedCommentListReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stGetFeedCommentListReq() {}
  
  public stGetFeedCommentListReq(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.attach_info = paramString1;
    this.feed_id = paramString2;
    this.commentId = paramString3;
    this.reqFrom = paramInt1;
    this.replyId = paramString4;
    this.getRepyListByPage = paramInt2;
  }
  
  public String className()
  {
    return "NS_KING_INTERFACE.stGetFeedCommentListReq";
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
    paramStringBuilder.display(this.attach_info, "attach_info");
    paramStringBuilder.display(this.feed_id, "feed_id");
    paramStringBuilder.display(this.commentId, "commentId");
    paramStringBuilder.display(this.reqFrom, "reqFrom");
    paramStringBuilder.display(this.replyId, "replyId");
    paramStringBuilder.display(this.getRepyListByPage, "getRepyListByPage");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.attach_info, true);
    paramStringBuilder.displaySimple(this.feed_id, true);
    paramStringBuilder.displaySimple(this.commentId, true);
    paramStringBuilder.displaySimple(this.reqFrom, true);
    paramStringBuilder.displaySimple(this.replyId, true);
    paramStringBuilder.displaySimple(this.getRepyListByPage, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stGetFeedCommentListReq)paramObject;
    } while ((!JceUtil.equals(this.attach_info, paramObject.attach_info)) || (!JceUtil.equals(this.feed_id, paramObject.feed_id)) || (!JceUtil.equals(this.commentId, paramObject.commentId)) || (!JceUtil.equals(this.reqFrom, paramObject.reqFrom)) || (!JceUtil.equals(this.replyId, paramObject.replyId)) || (!JceUtil.equals(this.getRepyListByPage, paramObject.getRepyListByPage)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_KING_INTERFACE.stGetFeedCommentListReq";
  }
  
  public String getAttach_info()
  {
    return this.attach_info;
  }
  
  public String getCommentId()
  {
    return this.commentId;
  }
  
  public String getFeed_id()
  {
    return this.feed_id;
  }
  
  public int getGetRepyListByPage()
  {
    return this.getRepyListByPage;
  }
  
  public String getReplyId()
  {
    return this.replyId;
  }
  
  public int getReqFrom()
  {
    return this.reqFrom;
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
    this.attach_info = paramJceInputStream.readString(0, true);
    this.feed_id = paramJceInputStream.readString(1, true);
    this.commentId = paramJceInputStream.readString(2, false);
    this.reqFrom = paramJceInputStream.read(this.reqFrom, 3, false);
    this.replyId = paramJceInputStream.readString(4, false);
    this.getRepyListByPage = paramJceInputStream.read(this.getRepyListByPage, 5, false);
  }
  
  public void setAttach_info(String paramString)
  {
    this.attach_info = paramString;
  }
  
  public void setCommentId(String paramString)
  {
    this.commentId = paramString;
  }
  
  public void setFeed_id(String paramString)
  {
    this.feed_id = paramString;
  }
  
  public void setGetRepyListByPage(int paramInt)
  {
    this.getRepyListByPage = paramInt;
  }
  
  public void setReplyId(String paramString)
  {
    this.replyId = paramString;
  }
  
  public void setReqFrom(int paramInt)
  {
    this.reqFrom = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.attach_info, 0);
    paramJceOutputStream.write(this.feed_id, 1);
    if (this.commentId != null) {
      paramJceOutputStream.write(this.commentId, 2);
    }
    paramJceOutputStream.write(this.reqFrom, 3);
    if (this.replyId != null) {
      paramJceOutputStream.write(this.replyId, 4);
    }
    paramJceOutputStream.write(this.getRepyListByPage, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stGetFeedCommentListReq
 * JD-Core Version:    0.7.0.1
 */