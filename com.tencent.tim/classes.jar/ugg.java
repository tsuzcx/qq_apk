import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ugg
  implements View.OnClickListener
{
  public ugg(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    anot.a(this.this$0.app, "CliOper", "", "", "0X8007144", "0X8007144", 0, 0, "", "", "", "");
    anxr localanxr = (anxr)this.this$0.app.getManager(61);
    if ((localanxr != null) && (localanxr.Kx() >= 2)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "click top right manage btn underTwo = " + bool);
      }
      AssociatedAccountActivity.a(this.this$0, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */