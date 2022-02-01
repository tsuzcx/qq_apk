import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;

class akwq
  implements DialogInterface.OnClickListener
{
  akwq(akwp paramakwp, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      paramDialogInterface.append("?");
      paramDialogInterface.append("uin=");
      paramDialogInterface.append(this.val$uin);
      paramDialogInterface.append("&plat=1");
      paramDialogInterface.append("&app=1");
      paramDialogInterface.append("&version=3.4.4.3058");
      paramDialogInterface.append("&device=" + URLEncoder.encode(Build.DEVICE));
      paramDialogInterface.append("&system=" + Build.VERSION.RELEASE);
      paramDialogInterface.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      paramDialogInterface = paramDialogInterface.toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("uin", this.val$uin);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(this.u, paramDialogInterface, 32768L, localIntent, false, -1);
      anot.a(this.val$app, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwq
 * JD-Core Version:    0.7.0.1
 */