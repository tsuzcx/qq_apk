import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vpr
  implements View.OnClickListener
{
  public vpr(QCirclePolyLikeMoreView paramQCirclePolyLikeMoreView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Vpo != null) {
      this.a.jdField_a_of_type_Vpo.b();
    }
    if (this.a.jdField_a_of_type_Vpe == null) {
      this.a.jdField_a_of_type_Vpe = new vpe(this.a.getContext());
    }
    this.a.jdField_a_of_type_Vpe.a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, vpp.a().a(), this.a.jdField_a_of_type_Vqa, this.a.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpr
 * JD-Core Version:    0.7.0.1
 */