import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

class pbk
  implements View.OnClickListener
{
  pbk(pbc parampbc) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    ovz localovz = new ovz();
    Object localObject2 = null;
    ReportExtraTypeInfo localReportExtraTypeInfo = new ReportExtraTypeInfo();
    Object localObject1 = localObject2;
    if (pbc.a(this.this$0) != null)
    {
      localObject1 = localObject2;
      if (pbc.a(this.this$0).a() != null)
      {
        localObject2 = pbc.a(this.this$0).a();
        if (!(localObject2 instanceof pao.a)) {
          break label283;
        }
        localObject1 = ((pao.a)localObject2).a;
        if (localObject1 == null) {
          break label324;
        }
        localObject1 = (FeedCloudMeta.StFeed)((QCircleContentImage)localObject1).getData();
      }
    }
    for (;;)
    {
      localReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)localObject1);
      localReportExtraTypeInfo.mDataPosition = ((RecyclerView.ViewHolder)localObject2).getAdapterPosition();
      localReportExtraTypeInfo.mPlayScene = 2;
      localovz.a = localReportExtraTypeInfo;
      localovz.feed = ((FeedCloudMeta.StFeed)localObject1);
      localovz.type = 0;
      if (!ovd.a(localovz.feed)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localovz.ayK = bool1;
        localovz.ayJ = ovd.a(localovz.feed);
        localovz.ayL = false;
        if (localovz.feed != null)
        {
          localObject2 = localovz.feed.opMask2.get();
          if ((localObject2 != null) && (((List)localObject2).contains(Integer.valueOf(3))))
          {
            bool1 = bool2;
            if (!ovd.a((FeedCloudMeta.StUser)localovz.feed.poster.get())) {
              bool1 = true;
            }
            localovz.ayL = bool1;
          }
        }
        if (localObject1 != null)
        {
          this.this$0.r("share_action_show_share_sheet", localovz);
          pbc.a(this.this$0, true);
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label283:
        if (!(localObject2 instanceof pao.b)) {
          break label324;
        }
        localObject1 = ((pao.b)localObject2).a;
        if (localObject1 == null) {
          break label324;
        }
        localObject1 = (FeedCloudMeta.StFeed)((QCircleContentVideo)localObject1).getData();
        break;
      }
      label324:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbk
 * JD-Core Version:    0.7.0.1
 */