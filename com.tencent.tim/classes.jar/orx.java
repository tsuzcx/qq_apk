import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class orx
  implements View.OnClickListener
{
  orx(orw paramorw) {}
  
  public void onClick(View paramView)
  {
    this.b.bgG();
    this.b.hideErrorView();
    orw.a(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orx
 * JD-Core Version:    0.7.0.1
 */