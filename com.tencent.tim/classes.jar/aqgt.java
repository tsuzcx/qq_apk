import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgt
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aehn.a parama)
  {
    str1 = paramQQAppInterface.getCurrentUin();
    if ("confess_config".equals(paramString)) {
      if (paramQQAppInterface.iz(269))
      {
        paramString = ((aegs)paramQQAppInterface.getManager(269)).a();
        parama.bTX = paramString.lx(parama.strContent);
        ((aegq)paramQQAppInterface.getBusinessHandler(125)).a(paramQQAppInterface, paramString);
        parama.bTW = true;
      }
    }
    Object localObject;
    String str2;
    do
    {
      return;
      parama.bTX = aegp.ly(parama.strContent);
      break;
      if ("extend_friend_config_785".equals(paramString))
      {
        parama.bTW = true;
        if (TextUtils.isEmpty(parama.strContent))
        {
          QLog.e("ConfigUtil", 2, "processExtendFriendConfig is emtpy !! configParseResult version:" + parama.version + " localVersion " + parama.localVersion);
          parama.bTX = false;
          return;
        }
        q(paramQQAppInterface.getApp(), str1, paramString, parama.strContent);
        if (paramQQAppInterface.iz(264)) {
          ((afsi)paramQQAppInterface.getManager(264)).Ii(parama.strContent);
        }
        parama.bTX = true;
        return;
      }
      if ("sosointerface_config".equals(paramString))
      {
        parama.bTX = SosoInterface.kM(parama.strContent);
        parama.bTW = true;
        return;
      }
      if ("register_invitation_config".equals(paramString)) {
        try
        {
          localObject = new JSONObject(parama.strContent);
          paramString = ((JSONObject)localObject).optString("entranceTitle");
          str2 = ((JSONObject)localObject).optString("entranceSubtitle");
          localObject = ((JSONObject)localObject).optString("entranceUrl");
          aqmj.r(paramQQAppInterface.getApp(), str1, "register_invitation_sp_firstline", paramString);
          aqmj.r(paramQQAppInterface.getApp(), str1, "register_invitation_sp_secondline", str2);
          aqmj.r(paramQQAppInterface.getApp(), str1, "register_invitation_sp_entry", (String)localObject);
          parama.bTW = false;
          parama.bTX = true;
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ConfigUtil", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
      }
    } while (!"account_logout_config".equals(paramString));
    for (;;)
    {
      try
      {
        localObject = new JSONObject(parama.strContent);
        if (((JSONObject)localObject).optInt("isShowEntrance") != 1) {
          continue;
        }
        bool = true;
        paramString = ((JSONObject)localObject).optString("webUrl");
        str2 = ((JSONObject)localObject).optString("successText");
        localObject = ((JSONObject)localObject).optString("boldText");
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_url", paramString);
        aqmj.d(paramQQAppInterface.getApp(), str1, "account_logout_entrance", bool);
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_success_text", str2);
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigUtil", 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", new Object[] { Boolean.valueOf(bool), paramString, str2, localObject }));
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        QLog.e("ConfigUtil", 1, paramString.getMessage(), paramString);
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_url", "");
        aqmj.d(paramQQAppInterface.getApp(), str1, "account_logout_entrance", false);
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_success_text", "");
        aqmj.r(paramQQAppInterface.getApp(), str1, "account_logout_bold_text", "");
        continue;
      }
      parama.bTW = false;
      parama.bTX = true;
      return;
      bool = false;
    }
  }
  
  public static String k(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = aqhq.o(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }));
    if (paramContext == null) {
      return null;
    }
    return (String)paramContext;
  }
  
  public static void q(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    aqhq.y(String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 }), paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgt
 * JD-Core Version:    0.7.0.1
 */