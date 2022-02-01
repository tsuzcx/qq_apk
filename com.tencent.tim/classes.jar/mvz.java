import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;

public class mvz
  implements RIJRedPacketManager.a
{
  public mvz(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, VideoInfo paramVideoInfo, int paramInt) {}
  
  public void e(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.adJ = paramBoolean;
    this.a.WG = paramString;
    this.a.adL = paramBoolean;
    this.a.aHh = paramInt;
    if (((VideoFeedsRecommendFragment.a(this.this$0) instanceof mtg.k)) && (VideoFeedsRecommendFragment.a(this.this$0).aUv == this.val$position)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramInt != 0)) {
        ((mtg.j)VideoFeedsRecommendFragment.a(this.this$0).a).r(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvz
 * JD-Core Version:    0.7.0.1
 */