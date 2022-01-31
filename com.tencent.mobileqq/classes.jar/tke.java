import UserGrowth.stFollowFeedsReq;
import UserGrowth.stFollowFeedsRsp;

public class tke
  extends thb<stFollowFeedsRsp>
{
  public tke(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    super("FollowFeeds");
    stFollowFeedsReq localstFollowFeedsReq = new stFollowFeedsReq();
    localstFollowFeedsReq.attatch_info = paramString1;
    localstFollowFeedsReq.is_refresh = paramBoolean2;
    localstFollowFeedsReq.is_first = paramBoolean1;
    localstFollowFeedsReq.push_info = paramString2;
    localstFollowFeedsReq.scene = paramInt;
    this.a = localstFollowFeedsReq;
    tlo.d("FollowRequest", localstFollowFeedsReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tke
 * JD-Core Version:    0.7.0.1
 */