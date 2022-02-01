import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aana
  implements View.OnClickListener
{
  public aana(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X800AA2E", "0X800AA2E", 0, 0, "", "", "", "");
    LoginView.a(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aana
 * JD-Core Version:    0.7.0.1
 */