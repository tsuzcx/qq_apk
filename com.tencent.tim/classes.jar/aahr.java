import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aahr
  implements View.OnClickListener
{
  aahr(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.LU == 77313L) {
      this.this$0.bvD = true;
    }
    this.this$0.cuj();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahr
 * JD-Core Version:    0.7.0.1
 */