import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.widget.TimePickerView.TimePickerListener;

public class dfy
  implements TimePickerView.TimePickerListener
{
  public dfy(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ProfileUtil.a(paramInt1, paramInt2, paramInt3);
    if (RegisterPhoneNumActivity.a(this.a) != null) {
      RegisterPhoneNumActivity.a(this.a).setText(ProfileUtil.a(paramInt1));
    }
    this.a.g = paramInt1;
    RegisterPhoneNumActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dfy
 * JD-Core Version:    0.7.0.1
 */