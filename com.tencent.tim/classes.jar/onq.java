import NS_KING_INTERFACE.stGetFeedCommentListReq;
import UserGrowth.stQQGetFeedCommentListReq;
import UserGrowth.stQQGetFeedCommentListRsp;

public class onq
  extends okw<stQQGetFeedCommentListRsp>
{
  public onq()
  {
    super("QQGetFeedCommentList");
    this.req = new stGetFeedCommentListReq("", "76C9BjPDT1HaN4nHs", "", 0, "", 0);
  }
  
  public onq(String paramString1, String paramString2, int paramInt)
  {
    super("QQGetFeedCommentList");
    this.req = new stQQGetFeedCommentListReq(new stGetFeedCommentListReq(paramString1, paramString2, "", 0, "", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onq
 * JD-Core Version:    0.7.0.1
 */