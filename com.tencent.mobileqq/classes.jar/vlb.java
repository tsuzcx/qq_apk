import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

class vlb
  implements View.OnClickListener
{
  vlb(vks paramvks) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    Object localObject2;
    Object localObject3;
    if (vks.a(this.a).getVisibility() != 0)
    {
      localObject1 = new uzn();
      localObject2 = vks.a(this.a);
      localObject3 = new ReportExtraTypeInfo();
      if ((vks.a(this.a) != null) && (vks.a(this.a).a() != null))
      {
        RecyclerView.ViewHolder localViewHolder = vks.a(this.a).a();
        ((ReportExtraTypeInfo)localObject3).mFeed = ((FeedCloudMeta.StFeed)localObject2);
        ((ReportExtraTypeInfo)localObject3).mDataPosition = localViewHolder.getAdapterPosition();
        ((ReportExtraTypeInfo)localObject3).mPlayScene = 2;
      }
      ((uzn)localObject1).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)localObject3);
      ((uzn)localObject1).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)localObject2);
      ((uzn)localObject1).jdField_a_of_type_Int = 0;
      if (uxx.a(((uzn)localObject1).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {
        break label442;
      }
      bool1 = true;
      ((uzn)localObject1).jdField_b_of_type_Boolean = bool1;
      ((uzn)localObject1).c = true;
      ((uzn)localObject1).jdField_a_of_type_Boolean = uxx.a(((uzn)localObject1).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      ((uzn)localObject1).d = false;
      ((uzn)localObject1).f = false;
      ((uzn)localObject1).e = false;
      if (localObject2 != null) {
        localObject3 = new QQCircleFeedBase.StFeedBusiReqData();
      }
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject3).mergeFrom(((FeedCloudMeta.StFeed)localObject2).busiData.get().toByteArray());
        localObject3 = ((QQCircleFeedBase.StFeedBusiReqData)localObject3).uninterest_buttons.get();
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          continue;
        }
        bool1 = true;
        ((uzn)localObject1).d = bool1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label442:
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        localObject1 = "2";
        continue;
      }
      localObject3 = ((FeedCloudMeta.StFeed)localObject2).opMask2.get();
      if (localObject3 != null)
      {
        if ((uxx.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject2).poster.get())) || (!((List)localObject3).contains(Integer.valueOf(1)))) {
          continue;
        }
        bool1 = true;
        ((uzn)localObject1).f = bool1;
        if ((uxx.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject2).poster.get())) || (!((List)localObject3).contains(Integer.valueOf(2)))) {
          continue;
        }
        bool1 = bool2;
        ((uzn)localObject1).e = bool1;
        ((uzn)localObject1).h = ((List)localObject3).contains(Integer.valueOf(10));
        ((uzn)localObject1).jdField_b_of_type_Int = vks.a(this.a).a();
      }
      this.a.b("share_action_show_share_sheet", localObject1);
      localObject2 = new ArrayList();
      if (!vks.a(this.a)) {
        continue;
      }
      localObject1 = "1";
      ((ArrayList)localObject2).add(vri.a("ext1", (String)localObject1));
      vrg.a(21, 2, this.a.a(), (List)localObject2, vks.c(this.a));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlb
 * JD-Core Version:    0.7.0.1
 */