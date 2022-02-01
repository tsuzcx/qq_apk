import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.widget.IndexView;

public class zqo
  implements DialogInterface.OnDismissListener
{
  public zqo(CountryActivity paramCountryActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.rootView.offsetTopAndBottom(-this.dS);
    this.a.yg.setVisibility(0);
    this.a.c.setVisibility(0);
    this.a.rootView.startAnimation(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqo
 * JD-Core Version:    0.7.0.1
 */