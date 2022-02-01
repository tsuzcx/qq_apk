import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aibf
  extends VasWebviewJsPlugin
{
  public aibf()
  {
    this.mPluginNameSpace = "qq_imax_ad";
  }
  
  private void KU(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        String str = paramString.optString("callback");
        paramString = jxc.b(paramString);
        JSONObject localJSONObject = new JSONObject();
        if (paramString != null)
        {
          if ((QLog.isColorLevel()) && (paramString.a != null)) {
            QLog.d("ImaxAdvertisement", 2, "ad id  = " + paramString.a.hT);
          }
          PublicAccountAdvertisementActivity.a(BaseApplicationImpl.getContext(), paramString);
        }
        for (paramString = localJSONObject.put("retCode", "0"); !TextUtils.isEmpty(str); paramString = localJSONObject.put("retCode", "-1"))
        {
          callJs(str, new String[] { paramString.toString() });
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "item == null");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ImaxAdvertisement", 2, "rootObject == null");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "openImaxAd", paramString);
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "handleJsRequest pkgName=" + paramString2 + " method=" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    while ((paramVarArgs == null) || (paramVarArgs.length == 0) || (!"qq_imax_ad".equals(paramString2)) || (!"showSharedAD".equals(paramString3))) {
      return false;
    }
    KU(paramVarArgs[0]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibf
 * JD-Core Version:    0.7.0.1
 */