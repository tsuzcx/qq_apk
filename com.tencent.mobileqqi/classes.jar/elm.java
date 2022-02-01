import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;

public class elm
  implements View.OnClickListener
{
  public elm(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a();
    if ((paramView != null) && (paramView.u == 11))
    {
      ForwardOperations.a(this.a, false, "shareToQQ", paramView.a);
      com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
    }
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elm
 * JD-Core Version:    0.7.0.1
 */