import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Rsp;

public class uop
  extends ukl<stQQGetFeedCommentListV2Rsp>
{
  public uop()
  {
    super("QQGetFeedCommentListV2");
    this.a = new stGetFeedCommentListV2Req("", "76C9BjPDT1HaN4nHs", "", 0, "", 0);
  }
  
  public uop(String paramString1, String paramString2, int paramInt)
  {
    super("QQGetFeedCommentListV2", 10003);
    this.a = new stQQGetFeedCommentListV2Req(new stGetFeedCommentListV2Req(paramString1, paramString2, "", 0, "", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uop
 * JD-Core Version:    0.7.0.1
 */