import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class afrk
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((!"emoticon".equals(paramString2)) || (("showEmoticon".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      paramString1 = new SearchEmoticonWebBean();
      paramString1.bEN = paramJsBridgeListener.optString("emt_name", "");
      paramString1.bEO = paramJsBridgeListener.optString("emt_oriUrl", "");
      paramString1.bEP = paramJsBridgeListener.optString("emt_oriMd5", "");
      paramString1.cTy = paramJsBridgeListener.optInt("emt_oriFileSize", 0);
      paramString1.cTz = paramJsBridgeListener.optInt("emt_oriWidth", 0);
      paramString1.cTA = paramJsBridgeListener.optInt("emt_oriHeight", 0);
      paramString1.cTB = paramJsBridgeListener.optInt("emt_type", 0);
      paramString1.bEQ = paramJsBridgeListener.optString("emt_packCoverUrl", "");
      paramString1.bER = paramJsBridgeListener.optString("emt_packId", "");
      paramString1.bES = paramJsBridgeListener.optString("emt_packName", "");
      paramString1.bET = paramJsBridgeListener.optString("emt_miniId", "");
      paramString1.bEU = paramJsBridgeListener.optString("emt_miniName", "");
      SearchEmoticonFragment.a(this.mRuntime.getActivity(), paramString1);
      bool = true;
      return bool;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPlugin", 2, "showEmoticon error : " + aurp.getStackTraceAsString(paramJsBridgeListener));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrk
 * JD-Core Version:    0.7.0.1
 */