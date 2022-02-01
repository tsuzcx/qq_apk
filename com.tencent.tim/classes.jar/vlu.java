import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;

public class vlu
  implements ausj.a
{
  public vlu(PhoneUnityChangeActivity paramPhoneUnityChangeActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.X.cancel();
    if (this.a.mDialog == null) {
      this.a.mDialog = aqha.a(this.a, 230, acfp.m(2131709545), acfp.m(2131709535), acfp.m(2131709523), acfp.m(2131709526), new vlv(this), new vlw(this));
    }
    if ((this.a.mDialog != null) && (!this.a.mDialog.isShowing()) && (!this.a.isFinishing())) {
      this.a.mDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlu
 * JD-Core Version:    0.7.0.1
 */