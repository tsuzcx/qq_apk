import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxv
  implements View.OnClickListener
{
  public mxv(VideoFeedsTopicViewGroup paramVideoFeedsTopicViewGroup, VideoInfo.ChannelInfo paramChannelInfo) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (VideoFeedsTopicViewGroup.a(this.b).e(VideoFeedsTopicViewGroup.a(this.b)))
    {
      if (!TextUtils.isEmpty(this.a.WM)) {
        kxm.aJ(VideoFeedsTopicViewGroup.a(this.b), this.a.WM);
      }
    }
    else
    {
      str = new nce.a("", "", VideoFeedsTopicViewGroup.a(this.b).vid, VideoFeedsTopicViewGroup.a(this.b).Wz).t(this.a.channelID).u(muj.a(this.a)).a(VideoFeedsTopicViewGroup.a(this.b).videoReportInfo).a().toJsonString();
      if (!VideoFeedsTopicViewGroup.a(this.b)) {
        break label196;
      }
      kbp.a(null, "", "0X8009331", "0X8009331", 0, 0, "3", "", "", str, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kgw.b(VideoFeedsTopicViewGroup.a(this.b), this.a.channelID, this.a.channelName, this.a.channelType, 8, null);
      break;
      label196:
      kbp.a(null, "", "0X80092F9", "0X80092F9", 0, 0, "3", "", "", str, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxv
 * JD-Core Version:    0.7.0.1
 */