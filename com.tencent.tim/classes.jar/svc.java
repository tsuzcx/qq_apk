import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class svc
  extends WebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = svc.class.getSimpleName();
  private static final String TAG = svc.class.getName();
  
  public svc()
  {
    this.mPluginNameSpace = PLUGIN_NAMESPACE;
  }
  
  private byte[] L()
  {
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null) || (this.mRuntime.getActivity().getIntent() == null)) {
      return null;
    }
    return this.mRuntime.getActivity().getIntent().getByteArrayExtra("SafeReportData");
  }
  
  private boolean Nn()
  {
    if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null) || (this.mRuntime.getActivity().getIntent() == null)) {
      return false;
    }
    return this.mRuntime.getActivity().getIntent().getBooleanExtra("BSafeReportPost", false);
  }
  
  public static String d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject;
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          localObject = (MessageForPtt)paramMessageRecord;
          ((MessageForPtt)localObject).parse();
          localJSONObject2.put("content", paramMessageRecord.msg + ",urlAtServer:" + ((MessageForPtt)localObject).urlAtServer);
          localJSONObject2.put("contentType", "" + paramMessageRecord.msgtype);
          localJSONObject2.put("time", "" + paramMessageRecord.time);
          localJSONArray.put(0, localJSONObject2);
          localJSONObject1.put("msgnum", "1");
          localJSONObject1.put("contentlist", localJSONArray);
          return localJSONObject1.toString();
        }
        if ((paramMessageRecord instanceof MessageForPic))
        {
          localObject = (MessageForPic)paramMessageRecord;
          ((MessageForPic)localObject).parse();
          localJSONObject2.put("content", ((MessageForPic)localObject).msg + ",uuid:" + ((MessageForPic)localObject).uuid);
        }
        else
        {
          localJSONObject2.put("content", paramMessageRecord.msg);
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getReportMessage:" + paramMessageRecord.getMessage());
        }
        return "0";
      }
    }
  }
  
  public void g(String paramString, byte[] paramArrayOfByte)
  {
    CustomWebView localCustomWebView = this.mRuntime.getWebView();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      localCustomWebView.postUrl(paramString, paramArrayOfByte);
      localCustomWebView.requestFocus();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 32L) && (Nn()))
    {
      g(paramString, L());
      paramString = this.mRuntime.a(this.mRuntime.getActivity());
      if ((paramString != null) && ((paramString instanceof ardm.o))) {
        ((ardm.o)paramString).QK();
      }
      this.mRuntime.getWebView().readyForLoadJs();
      return true;
    }
    return false;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svc
 * JD-Core Version:    0.7.0.1
 */