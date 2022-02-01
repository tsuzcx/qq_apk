import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auka
  implements View.OnClickListener
{
  auka(aujz paramaujz) {}
  
  public void onClick(View paramView)
  {
    if (aujz.a(this.this$0).isShowing()) {
      aujz.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auka
 * JD-Core Version:    0.7.0.1
 */