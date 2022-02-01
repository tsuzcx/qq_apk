import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aufb
  implements View.OnClickListener
{
  aufb(aufa paramaufa, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((aufa.a(this.a) != null) && (aufa.a(this.a).isShowing())) {
      aufa.a(this.a).dismiss();
    }
    ((aufa.b)aufa.a(this.a).get(this.val$position)).gD.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufb
 * JD-Core Version:    0.7.0.1
 */