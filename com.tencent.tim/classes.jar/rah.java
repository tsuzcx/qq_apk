import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rah
  implements View.OnClickListener
{
  rah(rae paramrae) {}
  
  public void onClick(View paramView)
  {
    if (rae.a(this.b) != null) {
      rae.a(this.b).bmt();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rah
 * JD-Core Version:    0.7.0.1
 */