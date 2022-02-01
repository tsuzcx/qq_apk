import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxm
  implements View.OnClickListener
{
  public uxm(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */