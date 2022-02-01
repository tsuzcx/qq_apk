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

public class tkx
  extends accg
{
  public tkx(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramGdtBaseAdItem.aJn)))
    {
      AppInstallerReceiver.a().aI(paramContext);
      AppInstallerReceiver.a().a(paramGdtBaseAdItem);
    }
  }
  
  @Deprecated
  public void a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((paramContext == null) || (paramGdtBaseAdItem == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramGdtBaseAdItem.aJo)) {
      paramGdtBaseAdItem.g(paramGdtBaseAdItem.aJm);
    }
    if (aewh.g(paramGdtBaseAdItem.packageName, paramContext))
    {
      tlc.uu(paramGdtBaseAdItem.aJo);
      if (QLog.isColorLevel()) {
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled " + paramGdtBaseAdItem.packageName);
      }
      if (paramGdtBaseAdItem.aOU)
      {
        tll.c(paramContext, paramGdtBaseAdItem);
        return;
      }
      tll.a(paramContext, paramGdtBaseAdItem);
      return;
    }
    if (!TextUtils.isEmpty(paramGdtBaseAdItem.aJm))
    {
      b(paramContext, paramGdtBaseAdItem);
      label133:
      String str;
      if ((tll.isWifiConnected()) && (paramGdtBaseAdItem.aOT))
      {
        localObject = "1";
        if (QLog.isColorLevel()) {
          QLog.d("GdtAdHandler", 2, "doAppJump autoDownload  " + (String)localObject);
        }
        if (!tll.gI(paramGdtBaseAdItem.aJm)) {
          break label576;
        }
        if (("1".equals(localObject)) && (TextUtils.isEmpty((String)tll.n(paramGdtBaseAdItem.aJm).get("acttype")))) {
          paramGdtBaseAdItem.aJm += "&acttype=42";
        }
        if (TextUtils.isEmpty((String)tll.n(paramGdtBaseAdItem.aJm).get("wv"))) {
          paramGdtBaseAdItem.aJm += "&wv=1";
        }
        str = (String)tll.n(paramGdtBaseAdItem.aJm).get("_autodownload");
        if (TextUtils.isEmpty(str)) {
          break label516;
        }
        if (!"1".equals(localObject)) {
          break label480;
        }
        paramGdtBaseAdItem.aJm = paramGdtBaseAdItem.aJm.replace("_autodownload=" + str, "_autodownload=" + (String)localObject);
        label361:
        if (paramGdtBaseAdItem.clz != null) {
          break label568;
        }
      }
      label516:
      label568:
      for (Object localObject = QQBrowserActivity.class;; localObject = paramGdtBaseAdItem.clz)
      {
        localObject = new Intent(paramContext, (Class)localObject);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("url", paramGdtBaseAdItem.aJm);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_ads");
        if (paramGdtBaseAdItem.extra != null) {
          ((Intent)localObject).putExtras(paramGdtBaseAdItem.extra);
        }
        paramContext.startActivity((Intent)localObject);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : custom H5 " + paramGdtBaseAdItem.packageName);
        return;
        localObject = "0";
        break label133;
        label480:
        paramGdtBaseAdItem.aJm = paramGdtBaseAdItem.aJm.replace("&_autodownload=" + str, "");
        break label361;
        if (!"1".equals(localObject)) {
          break label361;
        }
        paramGdtBaseAdItem.aJm = (paramGdtBaseAdItem.aJm + "&" + "_autodownload" + "=" + (String)localObject);
        break label361;
      }
      label576:
      tlc.uu(paramGdtBaseAdItem.aJo);
      paramContext = (String)arug.y(paramGdtBaseAdItem.aJm).get("auto_download");
      if (!TextUtils.isEmpty(paramContext)) {
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.aJm = paramGdtBaseAdItem.aJm.replace("auto_download=" + paramContext, "auto_download=" + (String)localObject);
        }
      }
      for (;;)
      {
        paramContext = new Bundle();
        paramContext.putInt("process_id", 1);
        paramContext.putString("schemaUrl", paramGdtBaseAdItem.aJm);
        paramContext.putBoolean("is_can_open_yyb_native", false);
        paramContext.putString("big_brother_source_key", "biz_src_ads");
        paramContext.putAll(paramGdtBaseAdItem.extra);
        tll.bl(paramContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GdtAdHandler", 2, "doAppJump isApkInstalled not : yingyongbao H5 " + paramGdtBaseAdItem.packageName);
        return;
        paramGdtBaseAdItem.aJm = paramGdtBaseAdItem.aJm.replace("&auto_download=" + paramContext, "");
        continue;
        if ("1".equals(localObject)) {
          paramGdtBaseAdItem.aJm = (paramGdtBaseAdItem.aJm + "&" + "auto_download" + "=" + (String)localObject);
        }
      }
    }
    QLog.e("GdtAdHandler", 1, "doAppJump download_url null " + paramGdtBaseAdItem.packageName);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkx
 * JD-Core Version:    0.7.0.1
 */