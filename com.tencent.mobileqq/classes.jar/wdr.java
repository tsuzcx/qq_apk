import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter.MultiPicAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StImage;

public class wdr
  implements View.OnClickListener
{
  public wdr(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, int paramInt, View paramView, FeedCloudMeta.StImage paramStImage) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.c()) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.jdField_a_of_type_Var != null))
    {
      QCircleLayerBean localQCircleLayerBean = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.a(this.jdField_a_of_type_Int);
      vvh.a((URLImageView)this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StImage.width.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StImage.height.get(), localQCircleLayerBean);
      uyx.a(this.jdField_a_of_type_AndroidViewView.getContext(), localQCircleLayerBean);
      vtn.a(7, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.b());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdr
 * JD-Core Version:    0.7.0.1
 */