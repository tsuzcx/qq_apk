import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.open.agent.TroopAbilityPreVerificationFragment;

public class arsy
  implements DialogInterface.OnClickListener
{
  public arsy(TroopAbilityPreVerificationFragment paramTroopAbilityPreVerificationFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.x == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label99;
      }
      paramDialogInterface = new Intent(this.this$0.getActivity(), LoginActivity.class);
      paramDialogInterface.putExtra("key_params", this.this$0.mParams);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("fromThirdAppByOpenSDK", true);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.this$0.getActivity().startActivity(paramDialogInterface);
      this.this$0.getActivity().finish();
    }
    label99:
    while (paramInt != 0) {
      return;
    }
    this.this$0.getActivity().setResult(0);
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsy
 * JD-Core Version:    0.7.0.1
 */