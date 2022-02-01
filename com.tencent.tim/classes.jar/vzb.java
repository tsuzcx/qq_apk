import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class vzb
  implements DialogInterface.OnClickListener
{
  public vzb(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.this$0.app;
    String str2 = this.this$0.a.troopUin;
    if (this.this$0.a.bOwner) {}
    for (String str1 = "0";; str1 = "1")
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_clk", 0, 0, str2, str1, "0", "");
      paramDialogInterface.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzb
 * JD-Core Version:    0.7.0.1
 */