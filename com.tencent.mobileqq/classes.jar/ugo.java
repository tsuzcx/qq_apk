import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent.MultiPicAdapter;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class ugo
  implements View.OnClickListener
{
  public ugo(QCircleFeedItemPicPresent.MultiPicAdapter paramMultiPicAdapter, int paramInt, View paramView, FeedCloudMeta.StImage paramStImage) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.c()) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_Trw != null))
    {
      paramView = new QQCircleFeedBase.StFeedListBusiReqData();
      paramView.tabAttachInfo.set(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_Trw.a());
      Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_Trw.a();
      if (localObject != null)
      {
        paramView.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        paramView.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
      }
      localObject = new tqo();
      ((tqo)localObject).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_JavaLangObject);
      ((tqo)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
      ((tqo)localObject).a(paramView);
      ((tqo)localObject).b(this.jdField_a_of_type_Int);
      tqs.a(this.jdField_a_of_type_AndroidViewView.getContext(), ((tqo)localObject).a(), uaj.a((URLImageView)this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StImage.width.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StImage.height.get()));
      tzs.a(7, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    }
    yiw.a().a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent$MultiPicAdapter.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugo
 * JD-Core Version:    0.7.0.1
 */