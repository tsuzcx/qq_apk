import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class vys
  implements DialogInterface.OnClickListener
{
  public vys(TroopDisbandActivity paramTroopDisbandActivity, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.a == null) {
      this.this$0.a = new arib(this.this$0);
    }
    if (aqiw.isNetSupport(this.this$0))
    {
      paramDialogInterface = (acms)this.this$0.app.getBusinessHandler(20);
      if (paramDialogInterface != null)
      {
        if ((this.this$0.bFO & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.this$0;
          localTroopDisbandActivity.bFO |= 0x1;
          paramDialogInterface.Fc(this.this$0.mTroopUin);
        }
        this.this$0.a.aq(0, 2131693298, 1000);
      }
    }
    for (;;)
    {
      if ((this.M != null) && (this.M.isShowing())) {
        this.M.cancel();
      }
      anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.this$0.a.aq(2, 2131693293, 1500);
      continue;
      this.this$0.a.aq(2, 2131696348, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vys
 * JD-Core Version:    0.7.0.1
 */