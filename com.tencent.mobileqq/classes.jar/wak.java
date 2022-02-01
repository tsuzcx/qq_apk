import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

class wak
  implements View.OnClickListener
{
  wak(waj paramwaj, QQCircleFeedBase.StVideoBusiData paramStVideoBusiData) {}
  
  public void onClick(View paramView)
  {
    bgmp localbgmp = bgng.a(QQStoryContext.a(), paramView.getContext(), this.jdField_a_of_type_QqcircleQQCircleFeedBase$StVideoBusiData.simulate_date.simulate_schema.get());
    if (localbgmp != null) {
      localbgmp.a();
    }
    vrc.a(86, 2, this.jdField_a_of_type_Waj.a, this.jdField_a_of_type_Waj.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wak
 * JD-Core Version:    0.7.0.1
 */