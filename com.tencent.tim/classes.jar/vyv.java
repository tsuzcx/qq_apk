import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity;

class vyv
  implements DialogInterface.OnClickListener
{
  vyv(vyu paramvyu, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.a(this.a.this$0.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_more", 0, 0, this.a.this$0.mTroopUin, "", "", "");
    paramDialogInterface = new Intent(this.a.this$0, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.a.this$0.startActivity(paramDialogInterface);
    this.M.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyv
 * JD-Core Version:    0.7.0.1
 */