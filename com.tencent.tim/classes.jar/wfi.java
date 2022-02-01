import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wfi
  implements View.OnClickListener
{
  public wfi(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.a.getText().toString();
    if ((str == null) || (str.length() == 0)) {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131693138), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (str != null)
      {
        this.a.cG(str);
        this.a.dU.setEnabled(false);
        VerifyCodeActivity.b(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */