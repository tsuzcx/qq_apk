import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import feedcloud.FeedCloudMeta.StFeed;

class txj
  implements View.OnClickListener
{
  txj(txe paramtxe) {}
  
  public void onClick(View paramView)
  {
    tru localtru = new tru();
    RecyclerView.ViewHolder localViewHolder = null;
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    paramView = localViewHolder;
    if (txe.a(this.a) != null)
    {
      paramView = localViewHolder;
      if (txe.a(this.a).a() != null)
      {
        localViewHolder = txe.a(this.a).a();
        if (!(localViewHolder instanceof twt)) {
          break label182;
        }
        paramView = ((twt)localViewHolder).a;
        if (paramView == null) {
          break label217;
        }
        paramView = (FeedCloudMeta.StFeed)paramView.a();
      }
    }
    for (;;)
    {
      localReportExtraTypeInfo.mFeed = paramView;
      localReportExtraTypeInfo.mDataPosition = localViewHolder.getAdapterPosition();
      localReportExtraTypeInfo.mPlayScene = 2;
      localtru.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = localReportExtraTypeInfo;
      localtru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramView;
      localtru.jdField_a_of_type_Int = 0;
      if (!tra.a(localtru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {}
      for (boolean bool = true;; bool = false)
      {
        localtru.c = bool;
        localtru.b = tra.a(localtru.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        if (paramView != null)
        {
          this.a.b("share_action_show_share_sheet", localtru);
          txe.a(this.a, true);
        }
        return;
        label182:
        if (!(localViewHolder instanceof twu)) {
          break label217;
        }
        paramView = ((twu)localViewHolder).a;
        if (paramView == null) {
          break label217;
        }
        paramView = (FeedCloudMeta.StFeed)paramView.a();
        break;
      }
      label217:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txj
 * JD-Core Version:    0.7.0.1
 */