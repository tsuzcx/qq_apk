import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajcw
{
  public static ajcw.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("_appinfo");
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramString = Base64.decode(paramString, 10);
            if (paramString == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("miniAppJump", 2, "appinfo decode error 2");
              return null;
            }
          }
          catch (Exception paramString)
          {
            QLog.e("miniAppJump", 1, "parse miniapp jump url error", paramString);
            return null;
          }
        }
      }
    }
    paramString = new JSONObject(new String(paramString, "UTF-8"));
    ajcw.a locala = new ajcw.a();
    locala.type = paramString.getInt("type");
    locala.appid = paramString.getString("appid");
    locala.pageName = paramString.optString("pageName");
    locala.from = paramString.optInt("from");
    locala.param = paramString.optJSONObject("param");
    return locala;
  }
  
  public static boolean a(Activity paramActivity, ajcw.a parama, Bundle paramBundle)
  {
    if (parama == null) {}
    while ((parama.type == 4) || (parama.type != 3)) {
      return false;
    }
    ajcr.a(paramActivity, parama.appid, parama.type, null);
    return true;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, String paramString, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    QQAppInterface localQQAppInterface = paramBaseActivity.app;
    localBundle.putString("uin", localQQAppInterface.getCurrentAccountUin());
    boolean bool;
    if (paramMessageRecord.istroop == 1)
    {
      localBundle.putString("gc", paramMessageRecord.frienduin);
      if ((apuh.f(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.getCurrentUin())) || (apuh.g(localQQAppInterface, paramMessageRecord.frienduin, localQQAppInterface.getCurrentUin())))
      {
        bool = true;
        localBundle.putBoolean("isAdmin", bool);
      }
    }
    else
    {
      paramString = a(paramString);
      bool = a(paramBaseActivity, paramString, localBundle);
      if ((paramString != null) && (bool) && ((paramMessageRecord instanceof MessageForGrayTips)) && (paramString.type == 4) && (paramString.appid.equals("101474665")))
      {
        if (paramString.from != 1) {
          break label186;
        }
        anot.a(localQQAppInterface, "dc00899", "Grp_idol", "", "idol_follow", "follow_suc_clk", 0, 0, paramMessageRecord.frienduin, "", "", "");
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      break;
      label186:
      if (paramString.from == 2) {
        aqfr.b("Grp_idol", "Grp_AIO", "clk_renwu", 0, 0, new String[] { paramMessageRecord.frienduin });
      }
    }
  }
  
  public static boolean b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    return a(paramActivity, a(paramString), paramBundle);
  }
  
  public static class a
  {
    String appid;
    int from;
    String pageName;
    JSONObject param;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcw
 * JD-Core Version:    0.7.0.1
 */