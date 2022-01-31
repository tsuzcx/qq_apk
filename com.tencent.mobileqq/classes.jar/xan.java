import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class xan
  implements View.OnClickListener
{
  public xan(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a();
    if (paramView != null) {
      paramView.a(false);
    }
    com.tencent.mobileqq.app.PhoneContactManagerImp.g = false;
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xan
 * JD-Core Version:    0.7.0.1
 */