import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleLikeBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class vot
  implements View.OnClickListener
{
  vot(voq paramvoq) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = "";
    if (this.a.jdField_a_of_type_Int == 6)
    {
      localObject1 = (FeedCloudMeta.StComment)this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
      if ((localObject1 == null) || (((FeedCloudMeta.StComment)localObject1).likeInfo.get() == null)) {
        break label435;
      }
    }
    label410:
    label435:
    for (Object localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StComment)localObject1).likeInfo.get()).id.get();; localObject1 = "")
    {
      int i = 6;
      long l1 = 0L;
      if ((this.a.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData != null) && (this.a.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get() != null)) {}
      for (;;)
      {
        try
        {
          j = Integer.parseInt(uzg.a(this.a.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get(), "unread_like_count", "0"));
        }
        catch (Exception localException1)
        {
          long l2;
          Object localObject3;
          j = 0;
        }
        try
        {
          l2 = Long.parseLong(uzg.a(this.a.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.busiInfo.get(), "last_like_time", "0"));
          l1 = l2;
          localObject2 = new QCircleLikeBean();
          ((QCircleLikeBean)localObject2).setFeed(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed);
          ((QCircleLikeBean)localObject2).setRequestType(i);
          ((QCircleLikeBean)localObject2).setLikeId((String)localObject1);
          ((QCircleLikeBean)localObject2).setCount(j);
          ((QCircleLikeBean)localObject2).setTime(l1);
          ((QCircleLikeBean)localObject2).setFromReportBean(this.a.a().clone());
          uyx.a(paramView.getContext(), (QCircleLikeBean)localObject2);
          vtq.a("", 17, 12, 1);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        catch (Exception localException2)
        {
          break label410;
        }
        if (this.a.jdField_a_of_type_Int == 7)
        {
          localObject3 = (FeedCloudMeta.StComment)this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((FeedCloudMeta.StComment)localObject3).vecReply.get();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((List)localObject3).size() > 0)
              {
                localObject1 = localObject2;
                if (((List)localObject3).get(0) != null)
                {
                  localObject1 = localObject2;
                  if (((FeedCloudMeta.StReply)((List)localObject3).get(0)).likeInfo.get() != null) {
                    localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StReply)((List)localObject3).get(0)).likeInfo.get()).id.get();
                  }
                }
              }
            }
          }
          i = 7;
          break;
        }
        i = 2;
        localObject1 = localObject2;
        break;
        QLog.e("QCircleDefaultMessagePresenter", 1, localException1, new Object[0]);
        continue;
        int j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vot
 * JD-Core Version:    0.7.0.1
 */