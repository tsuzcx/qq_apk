import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.b;

public final class aovu
  implements DialogInterface.OnClickListener
{
  public aovu(Bundle paramBundle, int paramInt1, int paramInt2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopBarPublishUtils.a().dXl();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      String str2 = this.bn.getString("bid", "0");
      String str1;
      if ("interestcircle".endsWith(this.bn.getString("from")))
      {
        paramDialogInterface = "pub_page_new";
        if (this.dRV != 3) {
          break label144;
        }
        str1 = "Clk_cancel";
        label79:
        if (this.dRV != 3) {
          break label155;
        }
        if (!"0".endsWith(str2)) {
          break label150;
        }
        paramInt = 2;
      }
      for (;;)
      {
        anot.a(null, "dc00899", "Grp_tribe", "", paramDialogInterface, str1, paramInt, 0, str2, "", "", "");
        return;
        if ("0".endsWith(str2)) {}
        for (paramDialogInterface = "pub_page_new";; paramDialogInterface = "reply_page_new") {
          break;
        }
        label144:
        str1 = "Clk_cancelup";
        break label79;
        label150:
        paramInt = 1;
        continue;
        label155:
        paramInt = 0;
      }
    }
    paramDialogInterface.dismiss();
    TroopBarPublishUtils.a(this.dRW, this.val$context, this.bn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovu
 * JD-Core Version:    0.7.0.1
 */