import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

class tyh
  implements View.OnClickListener
{
  tyh(txz paramtxz) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    trz localtrz = new trz();
    Object localObject = null;
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    paramView = (View)localObject;
    if (txz.a(this.a) != null)
    {
      paramView = (View)localObject;
      if (txz.a(this.a).a() != null)
      {
        localObject = txz.a(this.a).a();
        if (!(localObject instanceof txm)) {
          break label267;
        }
        paramView = ((txm)localObject).a;
        if (paramView == null) {
          break label304;
        }
        paramView = (FeedCloudMeta.StFeed)paramView.a();
      }
    }
    for (;;)
    {
      localReportExtraTypeInfo.mFeed = paramView;
      localReportExtraTypeInfo.mDataPosition = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
      localReportExtraTypeInfo.mPlayScene = 2;
      localtrz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = localReportExtraTypeInfo;
      localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramView;
      localtrz.jdField_a_of_type_Int = 0;
      if (!tra.a(localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localtrz.c = bool1;
        localtrz.b = tra.a(localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        localtrz.d = false;
        if (localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
        {
          localObject = localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.opMask2.get();
          if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(3))))
          {
            bool1 = bool2;
            if (!tra.a((FeedCloudMeta.StUser)localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
              bool1 = true;
            }
            localtrz.d = bool1;
          }
        }
        if (paramView != null)
        {
          this.a.b("share_action_show_share_sheet", localtrz);
          txz.a(this.a, true);
        }
        return;
        label267:
        if (!(localObject instanceof txn)) {
          break label304;
        }
        paramView = ((txn)localObject).a;
        if (paramView == null) {
          break label304;
        }
        paramView = (FeedCloudMeta.StFeed)paramView.a();
        break;
      }
      label304:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyh
 * JD-Core Version:    0.7.0.1
 */