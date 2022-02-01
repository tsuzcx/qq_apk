import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.QQMapActivity.10.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class voo
  implements View.OnClickListener
{
  public voo(QQMapActivity paramQQMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.runOnUiThread(new QQMapActivity.10.1(this));
    if ((this.Y != null) && (this.Y.isShowing())) {
      this.Y.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voo
 * JD-Core Version:    0.7.0.1
 */