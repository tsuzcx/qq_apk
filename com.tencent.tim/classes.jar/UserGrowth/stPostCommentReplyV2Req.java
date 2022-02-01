package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostCommentReplyV2Req
  extends JceStruct
{
  static stSimpleMetaReply cache_reply = new stSimpleMetaReply();
  public String commentId = "";
  public String feed_id = "";
  public stSimpleMetaReply reply;
  
  public stPostCommentReplyV2Req() {}
  
  public stPostCommentReplyV2Req(String paramString1, String paramString2, stSimpleMetaReply paramstSimpleMetaReply)
  {
    this.feed_id = paramString1;
    this.commentId = paramString2;
    this.reply = paramstSimpleMetaReply;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_id = paramJceInputStream.readString(0, false);
    this.commentId = paramJceInputStream.readString(1, false);
    this.reply = ((stSimpleMetaReply)paramJceInputStream.read(cache_reply, 2, false));
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
 * Qualified Name:     UserGrowth.stPostCommentReplyV2Req
 * JD-Core Version:    0.7.0.1
 */