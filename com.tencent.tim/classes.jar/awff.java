import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class awff
  extends WebViewPlugin
  implements aqze
{
  private awfr[] a;
  private boolean aNz;
  
  public static int a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, int paramInt)
  {
    parama = parama.a(parama.getActivity());
    int i = paramInt;
    if ((parama instanceof aran)) {
      i = ((aran)parama).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private void eDq()
  {
    int i = 0;
    if ((this.a == null) || (this.a.length == 0))
    {
      this.a = new awfr[] { new awet(), new awht(), new awgv(), new awfk(), new awfv(), new awfs(), new awfm(), new awek(), new awfn(), new awfx(), new awel(), new awer(), new awga(), new awfh(), new awfg(), new awgi(), new aweo(), new awgt(), new awha(), new awej(), new awgn(), new awfj(), new awfq(), new awgo(), new aweh(), new awgr(), new awhr(), new awex(), new awey(), new awfl(), new awfi(), new awev(), new awgw(), new awhb(), new awgj(), new awgs(), new aweg(), new awft(), new awei() };
      awfr[] arrayOfawfr = this.a;
      int j = arrayOfawfr.length;
      while (i < j)
      {
        arrayOfawfr[i].c(this);
        i += 1;
      }
    }
  }
  
  private boolean tS(String paramString)
  {
    try
    {
      Object localObject = this.mRuntime.getActivity().getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("fromQZone", false))) {}
      for (boolean bool = true;; bool = false)
      {
        CustomWebView localCustomWebView = this.mRuntime.getWebView();
        localObject = null;
        if (localCustomWebView != null) {
          localObject = localCustomWebView.getUrl();
        }
        bool = awdh.k((String)localObject, paramString, bool);
        if (!bool) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneWebViewPlugin", 1, "handleBanUrlOrScheme error", paramString);
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "Qzone", "qzDynamicAlbum", "QZImagePicker", "qzlive", "qqexplive", "qzui", "QzoneUpload", "QzoneAudio", "Qzone", "checkin" };
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    eDq();
    awfr[] arrayOfawfr = this.a;
    int j = arrayOfawfr.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfawfr[i].handleEvent(paramString, paramLong);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934601L) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html")) || (paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html"))))
    {
      paramString = new Intent();
      this.mRuntime.getActivity().setResult(0, paramString);
      this.mRuntime.getActivity().finish();
    }
    label114:
    do
    {
      return true;
      eDq();
      awfr[] arrayOfawfr = this.a;
      int j = arrayOfawfr.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label114;
        }
        if (arrayOfawfr[i].handleEvent(paramString, paramLong, paramMap)) {
          break;
        }
        i += 1;
      }
      if ((paramLong == 8589934594L) && (this.aNz))
      {
        paramMap = null;
        if (this.mRuntime != null) {
          paramMap = this.mRuntime.getWebView();
        }
        if (paramMap != null) {
          paramMap.clearHistory();
        }
        this.aNz = false;
      }
    } while ((1024L == paramLong) && (tS(paramString)));
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) && (!paramString2.equals("qzDynamicAlbum")) && (!paramString2.equals("QZImagePicker")) && (!paramString2.equals("qzlive")) && (!paramString2.equals("qzui")) && (!paramString2.equals("QzoneUpload")) && (!paramString2.equals("QzoneAudio")) && (!paramString2.equals("qqexplive")) && (!paramString2.equals("checkin"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneWebViewPlugin", 2, "handleJsRequest pkgName: " + paramString2 + ",method: " + paramString3);
    }
    eDq();
    awfr[] arrayOfawfr = this.a;
    int j = arrayOfawfr.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfawfr[i].handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs)) {
        return true;
      }
      i += 1;
    }
    return awfb.a(this, this.mRuntime, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    eDq();
    Object localObject = this.a;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].onActivityResult(paramIntent, paramByte, paramInt);
      i += 1;
    }
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      this.mRuntime.getActivity().finish();
      return;
    } while (paramInt != -1);
    try
    {
      localObject = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("cellid");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramIntent);
      localJSONObject.put("uin", localObject);
      dispatchJsEvent("deleteMessageSuccess", localJSONObject, new JSONObject());
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    eDq();
    awfr[] arrayOfawfr = this.a;
    int j = arrayOfawfr.length;
    int i = 0;
    while (i < j)
    {
      arrayOfawfr[i].onDestroy();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awff
 * JD-Core Version:    0.7.0.1
 */