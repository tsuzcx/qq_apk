package NS_KING_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetFeedCommentListV2Req
  extends JceStruct
{
  public String attach_info = "";
  public String commentId = "";
  public String feed_id = "";
  public int getRepyListByPage;
  public String replyId = "";
  public int reqFrom;
  
  public stGetFeedCommentListV2Req() {}
  
  public stGetFeedCommentListV2Req(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.attach_info = paramString1;
    this.feed_id = paramString2;
    this.commentId = paramString3;
    this.reqFrom = paramInt1;
    this.replyId = paramString4;
    this.getRepyListByPage = paramInt2;
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
 * Qualified Name:     NS_KING_INTERFACE.stGetFeedCommentListV2Req
 * JD-Core Version:    0.7.0.1
 */