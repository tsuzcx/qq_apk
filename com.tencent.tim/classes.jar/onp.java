import UserGrowth.stFollowFeedsReq;
import UserGrowth.stFollowFeedsRsp;

public class onp
  extends okw<stFollowFeedsRsp>
{
  public onp(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    super("FollowFeeds");
    stFollowFeedsReq localstFollowFeedsReq = new stFollowFeedsReq();
    localstFollowFeedsReq.attatch_info = paramString1;
    localstFollowFeedsReq.is_refresh = paramBoolean2;
    localstFollowFeedsReq.is_first = paramBoolean1;
    localstFollowFeedsReq.push_info = paramString2;
    localstFollowFeedsReq.scene = paramInt;
    this.req = localstFollowFeedsReq;
    ooz.e("FollowRequest", localstFollowFeedsReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onp
 * JD-Core Version:    0.7.0.1
 */