import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Rsp;

public class onr
  extends okw<stQQGetFeedCommentListV2Rsp>
{
  public onr()
  {
    super("QQGetFeedCommentListV2");
    this.req = new stGetFeedCommentListV2Req("", "76C9BjPDT1HaN4nHs", "", 0, "", 0);
  }
  
  public onr(String paramString1, String paramString2, int paramInt)
  {
    super("QQGetFeedCommentListV2");
    this.req = new stQQGetFeedCommentListV2Req(new stGetFeedCommentListV2Req(paramString1, paramString2, "", 0, "", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onr
 * JD-Core Version:    0.7.0.1
 */