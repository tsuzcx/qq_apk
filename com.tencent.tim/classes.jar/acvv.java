import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class acvv
  implements View.OnClickListener
{
  acvv(acvt paramacvt) {}
  
  public void onClick(View paramView)
  {
    if ((acvt.a(this.a) != null) && (acvt.a(this.a).isShowing())) {
      acvt.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.context).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvv
 * JD-Core Version:    0.7.0.1
 */