import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.PhoneFrame;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zqw
  implements View.OnClickListener
{
  public zqw(PhoneFrameActivity paramPhoneFrameActivity) {}
  
  public void onClick(View paramView)
  {
    ahgq localahgq = this.a.a.a();
    if (localahgq != null) {
      localahgq.Kp(false);
    }
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = false;
    this.a.setResult(1);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqw
 * JD-Core Version:    0.7.0.1
 */