import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter.MultiPicAdapter;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class wac
  implements View.OnClickListener
{
  public wac(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, QQCircleFeedBase.StImageBusiData paramStImageBusiData) {}
  
  public void onClick(View paramView)
  {
    bgmp localbgmp = bgng.a(QQStoryContext.a(), paramView.getContext(), this.jdField_a_of_type_QqcircleQQCircleFeedBase$StImageBusiData.simulate_date.simulate_schema.get());
    if (localbgmp != null) {
      localbgmp.a();
    }
    vrc.a(86, 2, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.a, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */