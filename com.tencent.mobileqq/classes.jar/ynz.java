import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.ipc.AppInstallerReceiver;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ynz
  extends ajfb
{
  public ynz(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramGdtBaseAdItem.c)))
    {
      AppInstallerReceiver.a().a(paramContext);
      AppInstallerReceiver.a().a(paramGdtBaseAdItem);
    }
  }
  
  @Deprecated
  public void a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext == null) || (paramGdtBaseAdItem == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramGdtBaseAdItem.f)) {
      paramGdtBaseAdItem.g(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString);
    }
    if (amom.a(paramGdtBaseAdItem.jdField_a_of_type_JavaLangString, paramContext))
    {
      yoh.a(paramGdtBaseAdItem.f);
      if (QLog.isColorLevel()) {
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled " + paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
      }
      if (paramGdtBaseAdItem.jdField_b_of_type_Boolean)
      {
        yox.b(paramContext, paramGdtBaseAdItem);
        return;
      }
      yox.a(paramContext, paramGdtBaseAdItem);
      return;
    }
    if (!TextUtils.isEmpty(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString))
    {
      b(paramContext, paramGdtBaseAdItem);
      label133:
      String str;
      if ((yox.a()) && (paramGdtBaseAdItem.jdField_a_of_type_Boolean))
      {
        localObject = "1";
        if (QLog.isColorLevel()) {
          QLog.d("GdtAdHandler", 2, "doAppJump autoDownload  " + (String)localObject);
        }
        if (!yox.a(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString)) {
          break label576;
        }
        if (("1".equals(localObject)) && (TextUtils.isEmpty((String)yox.a(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString).get("acttype")))) {
          paramGdtBaseAdItem.jdField_b_of_type_JavaLangString += "&acttype=42";
        }
        if (TextUtils.isEmpty((String)yox.a(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString).get("wv"))) {
          paramGdtBaseAdItem.jdField_b_of_type_JavaLangString += "&wv=1";
        }
        str = (String)yox.a(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString).get("_autodownload");
        if (TextUtils.isEmpty(str)) {
          break label516;
        }
        if (!"1".equals(localObject)) {
          break label480;
        }
        paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = paramGdtBaseAdItem.jdField_b_of_type_JavaLangString.replace("_autodownload=" + str, "_autodownload=" + (String)localObject);
        label361:
        if (paramGdtBaseAdItem.jdField_a_of_type_JavaLangClass != null) {
          break label568;
        }
      }
      label516:
      label568:
      for (Object localObject = QQBrowserActivity.class;; localObject = paramGdtBaseAdItem.jdField_a_of_type_JavaLangClass)
      {
        localObject = new Intent(paramContext, (Class)localObject);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", paramGdtBaseAdItem.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ads");
        if (paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle != null) {
          ((Intent)localObject).putExtras(paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle);
        }
        paramContext.startActivity((Intent)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : custom H5 " + paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
        return;
        localObject = "0";
        break label133;
        label480:
        paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = paramGdtBaseAdItem.jdField_b_of_type_JavaLangString.replace("&_autodownload=" + str, "");
        break label361;
        if (!"1".equals(localObject)) {
          break label361;
        }
        paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = (paramGdtBaseAdItem.jdField_b_of_type_JavaLangString + "&" + "_autodownload" + "=" + (String)localObject);
        break label361;
      }
      label576:
      yoh.a(paramGdtBaseAdItem.f);
      paramContext = (String)bcax.a(paramGdtBaseAdItem.jdField_b_of_type_JavaLangString).get("auto_download");
      if (!TextUtils.isEmpty(paramContext)) {
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = paramGdtBaseAdItem.jdField_b_of_type_JavaLangString.replace("auto_download=" + paramContext, "auto_download=" + (String)localObject);
        }
      }
      for (;;)
      {
        paramContext = new Bundle();
        paramContext.putInt("process_id", 1);
        paramContext.putString("schemaUrl", paramGdtBaseAdItem.jdField_b_of_type_JavaLangString);
        paramContext.putBoolean("is_can_open_yyb_native", false);
        paramContext.putString("big_brother_source_key", "biz_src_ads");
        paramContext.putAll(paramGdtBaseAdItem.jdField_a_of_type_AndroidOsBundle);
        yox.a(paramContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : yingyongbao H5 " + paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
        return;
        paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = paramGdtBaseAdItem.jdField_b_of_type_JavaLangString.replace("&auto_download=" + paramContext, "");
        continue;
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.jdField_b_of_type_JavaLangString = (paramGdtBaseAdItem.jdField_b_of_type_JavaLangString + "&" + "auto_download" + "=" + (String)localObject);
        }
      }
    }
    QLog.e("GdtAdHandler", 1, "doAppJump download_url null " + paramGdtBaseAdItem.jdField_a_of_type_JavaLangString);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynz
 * JD-Core Version:    0.7.0.1
 */