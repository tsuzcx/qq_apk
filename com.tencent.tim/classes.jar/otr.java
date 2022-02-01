import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class otr
  implements View.OnClickListener
{
  public otr(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.e.isShowing()) {
      this.this$0.e.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otr
 * JD-Core Version:    0.7.0.1
 */