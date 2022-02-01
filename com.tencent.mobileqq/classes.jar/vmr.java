import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;

class vmr
  implements View.OnClickListener
{
  vmr(vmq paramvmq) {}
  
  public void onClick(View paramView)
  {
    String str = "";
    if (this.a.jdField_a_of_type_Int == 6)
    {
      localObject1 = (FeedCloudMeta.StComment)this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
      if ((localObject1 == null) || (((FeedCloudMeta.StComment)localObject1).likeInfo.get() == null)) {
        break label263;
      }
    }
    label263:
    for (Object localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StComment)localObject1).likeInfo.get()).id.get();; localObject1 = "")
    {
      int i = 6;
      for (;;)
      {
        uxo.a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed, i, (String)localObject1, this.a.a().clone());
        vrf.a("", 17, 12, 1);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.a.jdField_a_of_type_Int == 7)
        {
          Object localObject2 = (FeedCloudMeta.StComment)this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
          localObject1 = str;
          if (localObject2 != null)
          {
            localObject2 = ((FeedCloudMeta.StComment)localObject2).vecReply.get();
            localObject1 = str;
            if (localObject2 != null)
            {
              localObject1 = str;
              if (((List)localObject2).size() > 0)
              {
                localObject1 = str;
                if (((List)localObject2).get(0) != null)
                {
                  localObject1 = str;
                  if (((FeedCloudMeta.StReply)((List)localObject2).get(0)).likeInfo.get() != null) {
                    localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StReply)((List)localObject2).get(0)).likeInfo.get()).id.get();
                  }
                }
              }
            }
          }
          i = 7;
        }
        else
        {
          i = 2;
          localObject1 = str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmr
 * JD-Core Version:    0.7.0.1
 */