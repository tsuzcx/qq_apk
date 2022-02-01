package UserGrowth;

import NS_KING_INTERFACE.stGetFeedCommentListReq;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stQQGetFeedCommentListReq
  extends JceStruct
{
  static stGetFeedCommentListReq cache_req = new stGetFeedCommentListReq();
  public stGetFeedCommentListReq req;
  
  public stQQGetFeedCommentListReq() {}
  
  public stQQGetFeedCommentListReq(stGetFeedCommentListReq paramstGetFeedCommentListReq)
  {
    this.req = paramstGetFeedCommentListReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.req = ((stGetFeedCommentListReq)paramJceInputStream.read(cache_req, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.req != null) {
      paramJceOutputStream.write(this.req, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stQQGetFeedCommentListReq
 * JD-Core Version:    0.7.0.1
 */