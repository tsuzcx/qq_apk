package com.tencent.mobileqq.studyroom.pluginimpl;

import aigi;
import android.content.Context;
import android.os.Bundle;
import anwk;
import anwl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;
import java.util.concurrent.Future;
import org.json.JSONObject;
import skj;

public class QQBaseAbilityInterfaceImpl
  implements QQBaseAbilityInterface, QQConfigAbilityInterface
{
  private static final String TAG = "studyroom.QQBaseAbilityInterface";
  private final aigi impl = aigi.a();
  private final skj mClient;
  
  public QQBaseAbilityInterfaceImpl()
  {
    QLog.d("studyroom.QQBaseAbilityInterface", 4, "init");
    this.mClient = skj.a();
    this.mClient.bzj();
  }
  
  public void beaconReportData(Bundle paramBundle, int paramInt) {}
  
  public void doCgiReq(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void download(Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    String str = paramBundle.getString("path", "");
    this.impl.a(paramBundle, new QQBaseAbilityInterfaceImpl.1(this, str, paramDownloadCallback));
  }
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return null;
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return this.impl.getAccessToken(paramString1, paramString2);
  }
  
  public JSONObject getConfigFromQQ()
  {
    anwk localanwk = anwl.a();
    if (localanwk != null) {
      return localanwk.data;
    }
    return new JSONObject();
  }
  
  public String getSelfUin()
  {
    return null;
  }
  
  public Bundle getTickets()
  {
    return null;
  }
  
  public void hasPluginLoaded()
  {
    QLog.d("studyroom.QQBaseAbilityInterface", 4, "hasPluginLoaded");
  }
  
  public boolean isMobileNet()
  {
    return false;
  }
  
  public void jumpAction(String paramString) {}
  
  public void openWebView(Bundle paramBundle) {}
  
  public void printQLog(Bundle paramBundle)
  {
    this.impl.cQ(paramBundle);
  }
  
  public void reportData(Bundle paramBundle)
  {
    this.mClient.aZ(paramBundle);
  }
  
  public String reqDns(String paramString)
  {
    return null;
  }
  
  public void requestConfigFromQQ(QQConfigAbilityInterface.Callback<JSONObject> paramCallback)
  {
    if (paramCallback != null) {
      paramCallback.onResult(getConfigFromQQ());
    }
    anwl.dTH();
  }
  
  public void sendSSOTask(Bundle paramBundle, CommonCallback<Bundle> paramCommonCallback) {}
  
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt) {}
  
  public boolean useIpDirectConnect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */