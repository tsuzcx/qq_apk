import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vsa
  implements View.OnClickListener
{
  public vsa(QCirclePolyLikeMoreView paramQCirclePolyLikeMoreView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Vrx != null) {
      this.a.jdField_a_of_type_Vrx.b();
    }
    if (this.a.jdField_a_of_type_Vrn == null) {
      this.a.jdField_a_of_type_Vrn = new vrn(this.a.getContext());
    }
    this.a.jdField_a_of_type_Vrn.a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, vry.a().a(), this.a.jdField_a_of_type_Vsj, this.a.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsa
 * JD-Core Version:    0.7.0.1
 */