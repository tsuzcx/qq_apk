import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.net.URLEncoder;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

final class ahxt
  implements DialogInterface.OnClickListener
{
  ahxt(int paramInt1, String paramString, Context paramContext, hiboom_auth.TTipsInfo paramTTipsInfo, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.dbS)
    {
    default: 
    case 1: 
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (!TextUtils.isEmpty(this.val$url)) {
          VasWebviewUtil.openQQBrowserActivity(this.val$context, this.val$url, -1L, null, false, -1);
        }
      }
    }
    boolean bool1 = false;
    boolean bool2 = false;
    String str3 = this.a.str_vip_type.get();
    String str2 = this.a.str_month.get();
    String str4 = this.a.str_aid.get();
    String str1 = str3;
    if (str3.startsWith("!"))
    {
      bool1 = true;
      str1 = str3.substring(1, str3.length());
    }
    if (str2.startsWith("!"))
    {
      str2 = str2.substring(1, str2.length());
      bool2 = true;
    }
    for (;;)
    {
      str3 = URLEncoder.encode("jsbridge://font/paySuccess?p={\"id\":" + this.dbT + "}");
      aqrf.a(this.val$context, str4, str1, Integer.parseInt(str2), bool2, bool1, null, str3, false, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxt
 * JD-Core Version:    0.7.0.1
 */