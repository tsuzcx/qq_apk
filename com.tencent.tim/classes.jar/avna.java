import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qqreader.js.JsCallParams;
import cooperation.qqreader.proxy.ReaderJsCallback;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import cooperation.qqreader.ui.ReaderContentPageActivity;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class avna
  extends VasWebviewJsPlugin
  implements aqze
{
  private static final String[] iU = { "JSRoot", "JSToast", "JSBookDir", "JSPublicAccount", "JSTopRightButton", "JSTittlebarAction", "JSPay", "JSPublicAccountUtil", "JSRedTouch", "JSBookDetailForQQ", "JSbookshelf", "JSContent", "readonline", "JSPopupList", "JSTypeface" };
  private avnd jdField_a_of_type_Avnd = new avnd(this);
  private ReaderJsPluginProxy jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy;
  private ReaderJsCallback b = new avnb(this);
  private JsBridgeListener d;
  private boolean iH;
  private String lY;
  private String lZ;
  private Handler mJSHandler;
  private TextView mRightBtn;
  
  private void a(JsBridgeListener paramJsBridgeListener, String paramString)
    throws JSONException
  {
    paramJsBridgeListener = new JSONObject(paramString).optString("callback");
    if (!TextUtils.isEmpty(paramJsBridgeListener))
    {
      paramString = new JSONObject();
      paramString.put("graylevel", avmr.cj());
      paramString.put("is_update_newstyle", avmr.da());
      paramString.put("result", 0);
      paramString.put("message", "success");
      callJs(paramJsBridgeListener, new String[] { paramString.toString() });
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (avmc.a().aKJ())
    {
      avoc.d("ReaderJsPlugin", "pluginHandleJS ->  handleJsCall");
      c(paramString1, paramString2, paramString3, paramVarArgs);
      return;
    }
    avoc.d("ReaderJsPlugin", "js plugin is not ready...");
    if ((("JSbookshelf".equals(paramString2)) && ("openLocalBook".equals(paramString3))) || (("readonline".equals(paramString2)) && ("readbook".equals(paramString3))))
    {
      d(paramString1, paramString2, paramString3, paramVarArgs);
      return;
    }
    this.jdField_a_of_type_Avnd.e(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  private static boolean c(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }
  
  private void ch(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = this.mJSHandler.obtainMessage(114, paramJSONObject);
      this.mJSHandler.sendMessage(paramJSONObject);
    }
  }
  
  private void d(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Intent localIntent = new Intent(this.mRuntime.getActivity(), ReaderContentPageActivity.class);
    localIntent.putExtra("is_to_splash_activity", true);
    localIntent.putExtra("splash_pending_js_param", new JsCallParams(paramString1, paramString2, paramString3, paramVarArgs));
    this.mRuntime.getActivity().startActivity(localIntent);
  }
  
  private void gS(String paramString, int paramInt)
    throws JSONException
  {
    Object localObject1 = new JSONObject(paramString);
    paramString = ((JSONObject)localObject1).getString("book_name");
    String str1 = ((JSONObject)localObject1).getString("chapter_name");
    String str2 = ((JSONObject)localObject1).getString("nbid");
    localObject1 = ((JSONObject)localObject1).optString("callback");
    Object localObject2 = this.mRuntime.getActivity();
    if ((localObject2 instanceof ReaderHomePageActivity)) {
      localObject2 = (ReaderHomePageActivity)localObject2;
    }
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      return;
    case 4: 
      ((ReaderHomePageActivity)localObject2).bw(paramString, str1, str2);
      return;
    case 6: 
      ((ReaderHomePageActivity)localObject2).bx(paramString, str1, str2);
      return;
    }
    boolean bool = ((ReaderHomePageActivity)localObject2).F(paramString, str1, str2);
    paramString = new JSONObject();
    if (bool) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramString.put("result", paramInt);
      callJs((String)localObject1, new String[] { paramString.toString() });
      return;
    }
  }
  
  private void onJsComplete(Object paramObject)
  {
    if (this.d != null) {
      this.d.onComplete(paramObject);
    }
  }
  
  private void openDetailMore(String paramString)
  {
    Intent localIntent = new Intent(this.mRuntime.getActivity(), ReaderContentPageActivity.class);
    localIntent.putExtras(avlw.a(localIntent, 2));
    localIntent.putExtra("url", paramString);
    this.mRuntime.getActivity().startActivity(localIntent);
  }
  
  private void registerWebSearch(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Log.i("ReaderJsPlugin", "registerWebSearch");
    this.lY = paramJSONObject.optString("callback");
  }
  
  private void setLoadingVisible(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("visible");
      paramString = Message.obtain();
      paramString.what = 109;
      paramString.obj = Boolean.valueOf(bool);
      this.mJSHandler.sendMessage(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public avna a(Handler paramHandler)
  {
    this.mJSHandler = paramHandler;
    return this;
  }
  
  boolean aKL()
  {
    if ((this.mRuntime != null) && ((this.mRuntime.getActivity() instanceof ReaderHomePageActivity))) {
      return ((ReaderHomePageActivity)this.mRuntime.getActivity()).aKL();
    }
    return false;
  }
  
  void c(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy == null)
    {
      avoc.i("ReaderJsPlugin", "create a new js plugin");
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy = avmc.a().a(this.b);
    }
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null)
    {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.setHandler(this.mJSHandler);
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.call(paramString1, paramString2, paramString3, paramVarArgs);
      avoc.i("ReaderJsPlugin", "create a new js ,method=" + paramString3);
    }
    do
    {
      return;
      avoc.e("ReaderJsPlugin", "handleJsCall mJsPlugin is null!");
    } while (!QRDebugEnvUrlUtils.isDebugEnv());
    Toast.makeText(BaseApplicationImpl.getApplication(), "ReaderRunTime 未创建！", 0).show();
  }
  
  public boolean callWebSearch()
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(this.lY)) {
      callJs(this.lY, new String[] { "{\"result\":\"0\"}" });
    }
    for (;;)
    {
      Log.i("ReaderJsPlugin", "registerWebSearch callWebSearch=" + bool);
      return bool;
      bool = false;
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return iU;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    avoc.d("ReaderJsPlugin", "handleJsRequest, url=" + paramString1 + " ,pakName=" + paramString2 + " ,method=" + paramString3);
    this.d = paramJsBridgeListener;
    if (!c(iU, paramString2)) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if ("JSTittlebarAction".equals(paramString2))
    {
      if ("setLoadingVisible".equals(paramString3))
      {
        if (paramVarArgs.length > 0)
        {
          setLoadingVisible(paramVarArgs[0]);
          onJsComplete(null);
        }
        return true;
      }
      if ("addDeskShortcutEvent".equals(paramString3))
      {
        this.iH = true;
        return true;
      }
      if ("setChannelTabAlpha".equals(paramString3))
      {
        if (paramVarArgs.length > 0) {
          onJsComplete(null);
        }
        return true;
      }
    }
    else if ("JSContent".equals(paramString2))
    {
      if ("registerWebSearch".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          registerWebSearch(new JSONObject(paramVarArgs[0]));
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            avoc.e("ReaderJsPlugin", "Failed to parse json str,json=" + paramVarArgs[0]);
          }
        }
      }
      if ("showRedPoint".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          ch(new JSONObject(paramVarArgs[0]));
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            avoc.e("ReaderJsPlugin", "Failed to parse json str,json=" + paramVarArgs[0]);
          }
        }
      }
      if ("openDetailMore".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          openDetailMore(paramVarArgs[0]);
        }
        return true;
      }
    }
    else
    {
      if ("JSbookshelf".equals(paramString2))
      {
        if ("getGrayUpdateData".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(paramJsBridgeListener, paramVarArgs[0]);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              avoc.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if ("addColorfulTab".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            gS(paramVarArgs[0], 4);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              avoc.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if ("removeColorfulTab".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            gS(paramVarArgs[0], 6);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              avoc.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if (!"isExitsInColorfulTab".equals(paramString3)) {
          break label585;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          gS(paramVarArgs[0], 8);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            avoc.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
          }
        }
      }
      if (("JSTopRightButton".equals(paramString2)) && ("showRightButton".equals(paramString3)))
      {
        if (paramVarArgs.length > 1)
        {
          showRightButton(paramVarArgs[0], paramVarArgs[1]);
          onJsComplete(null);
        }
        return true;
      }
    }
    label585:
    b(paramString1, paramString2, paramString3, paramVarArgs);
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.onCreate();
    }
    this.jdField_a_of_type_Avnd.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.onDestroy();
    }
    this.jdField_a_of_type_Avnd.onDestroy();
  }
  
  public void setRightButton(TextView paramTextView)
  {
    this.mRightBtn = paramTextView;
  }
  
  public void showRightButton(String paramString1, String paramString2)
  {
    if (this.mRightBtn == null) {
      return;
    }
    if (paramString1.trim().length() == 0)
    {
      this.mRightBtn.setVisibility(8);
      return;
    }
    this.mRightBtn.setText(paramString1);
    if (this.mRightBtn.getVisibility() == 8) {
      this.mRightBtn.setVisibility(0);
    }
    this.lZ = paramString2;
    this.mRightBtn.setOnClickListener(new avnc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avna
 * JD-Core Version:    0.7.0.1
 */