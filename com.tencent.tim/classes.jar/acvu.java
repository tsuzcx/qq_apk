import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class acvu
  implements View.OnClickListener
{
  acvu(acvt paramacvt) {}
  
  public void onClick(View paramView)
  {
    if ((acvt.a(this.a) != null) && (acvt.a(this.a).isShowing())) {
      acvt.a(this.a).dismiss();
    }
    acvt.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvu
 * JD-Core Version:    0.7.0.1
 */