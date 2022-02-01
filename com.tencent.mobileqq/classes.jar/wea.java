import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

class wea
  implements View.OnClickListener
{
  wea(wdz paramwdz, QQCircleFeedBase.StVideoBusiData paramStVideoBusiData) {}
  
  public void onClick(View paramView)
  {
    QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
    localStSimulateData.material_id.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StVideoBusiData.simulate_date.material_id.get());
    localStSimulateData.simulate_name.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StVideoBusiData.simulate_date.simulate_name.get());
    localStSimulateData.simulate_schema.set(brdx.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StVideoBusiData.simulate_date.material_id.get(), ""));
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    localQCirclePolymerizationBean.setSimulateData(localStSimulateData);
    localQCirclePolymerizationBean.setPolymerizationType(20);
    localQCirclePolymerizationBean.setExt1From(1);
    uyx.a(paramView.getContext(), localQCirclePolymerizationBean);
    vtn.a(86, 2, this.jdField_a_of_type_Wdz.a, this.jdField_a_of_type_Wdz.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wea
 * JD-Core Version:    0.7.0.1
 */