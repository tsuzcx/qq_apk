package NS_KING_INTERFACE;

import NS_KING_SOCIALIZE_META.stMetaReply;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyReq
  extends JceStruct
{
  static stMetaReply cache_reply = new stMetaReply();
  public String commentId = "";
  public String feed_id = "";
  public stMetaReply reply;
  
  public stPostCommentReplyReq() {}
  
  public stPostCommentReplyReq(String paramString1, String paramString2, stMetaReply paramstMetaReply)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.reply = paramstMetaReply;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, false);
    this.commentId = paramJceInputStream.readString(1, false);
    this.reply = ((stMetaReply)paramJceInputStream.read(cache_reply, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feed_id != null) {
      paramJceOutputStream.write(this.feed_id, 0);
    }
    if (this.commentId != null) {
      paramJceOutputStream.write(this.commentId, 1);
    }
    if (this.reply != null) {
      paramJceOutputStream.write(this.reply, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostCommentReplyReq
 * JD-Core Version:    0.7.0.1
 */