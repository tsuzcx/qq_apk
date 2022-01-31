import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class xdn
  extends WebViewPlugin
{
  public static final String a = xdn.class.getSimpleName();
  private static final String b = xdn.class.getName();
  
  public xdn()
  {
    this.mPluginNameSpace = a;
  }
  
  public static String a(MessageRecord paramMessageRecord)
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
          QLog.i(b, 2, "getReportMessage:" + paramMessageRecord.getMessage());
        }
        return "0";
      }
    }
  }
  
  private boolean a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getIntent() == null)) {
      return false;
    }
    return this.mRuntime.a().getIntent().getBooleanExtra("BSafeReportPost", false);
  }
  
  private byte[] a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getIntent() == null)) {
      return null;
    }
    return this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData");
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
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
    if ((paramLong == 32L) && (a()))
    {
      a(paramString, a());
      paramString = this.mRuntime.a(this.mRuntime.a());
      if ((paramString != null) && ((paramString instanceof bbev))) {
        ((bbev)paramString).b();
      }
      this.mRuntime.a().readyForLoadJs();
      return true;
    }
    return false;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xdn
 * JD-Core Version:    0.7.0.1
 */