import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abzo
  implements View.OnClickListener
{
  abzo(abzn paramabzn) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzo
 * JD-Core Version:    0.7.0.1
 */