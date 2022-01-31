import android.view.View;
import android.view.View.OnClickListener;
import com.pay.googlewalletsdk.GoogleWalletPayHelper;
import com.tencent.mobileqq.activity.voip.VoipPayActivity;

public class fbl
  implements View.OnClickListener
{
  public fbl(VoipPayActivity paramVoipPayActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = VoipPayActivity.a(this.a);
    GoogleWalletPayHelper.getInstance().pay(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fbl
 * JD-Core Version:    0.7.0.1
 */