import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class zxs
{
  private static volatile zxs a;
  private List<zxs.a> kt;
  
  private zxs()
  {
    zQ(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "");
  }
  
  public static zxs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new zxs();
      }
      return a;
    }
    finally {}
  }
  
  public static String aA(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        paramString2 = new X509EncodedKeySpec(Base64.decode(paramString2, 0));
        paramString2 = KeyFactory.getInstance("RSA").generatePublic(paramString2);
        paramString1 = Base64.decode(paramString1, 0);
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramString2);
        paramString1 = new String(localCipher.doFinal(paramString1));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  private void dW(String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qwallet_intercept", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("InterceptAppOpenConfig" + paramString2, paramString1).commit();
      }
    }
  }
  
  private String hW(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getSharedPreferences("qwallet_intercept", 4);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((SharedPreferences)localObject3).getString("InterceptAppOpenConfig" + paramString, null);
      }
    }
    return localObject1;
  }
  
  public boolean a(String paramString, WebViewFragment paramWebViewFragment)
  {
    if ((this.kt == null) || (TextUtils.isEmpty(paramString)) || (paramWebViewFragment == null)) {}
    CustomWebView localCustomWebView;
    zxs.a locala;
    do
    {
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          do
          {
            do
            {
              return false;
              if (QLog.isColorLevel()) {
                QLog.d("PayInterceptHelper", 2, "handleIntercept:" + paramString);
              }
              localCustomWebView = paramWebViewFragment.getWebView();
            } while (localCustomWebView == null);
            localObject1 = localCustomWebView.copyBackForwardList();
          } while ((localObject1 == null) || (((WebBackForwardList)localObject1).getCurrentIndex() != ((WebBackForwardList)localObject1).getSize() - 1));
          localObject1 = this.kt.iterator();
        }
        locala = (zxs.a)((Iterator)localObject1).next();
      } while (TextUtils.isEmpty(locala.bbe));
      if (locala.T == null) {
        locala.T = Pattern.compile(locala.bbe);
      }
    } while (!locala.T.matcher(paramString).matches());
    Object localObject1 = "";
    Object localObject2 = paramWebViewFragment.a;
    paramWebViewFragment = (WebViewFragment)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((arbz)localObject2).Jl;
      paramWebViewFragment = (WebViewFragment)localObject1;
      if (localObject2 != null)
      {
        paramWebViewFragment = (WebViewFragment)localObject1;
        if (((List)localObject2).size() > 0) {
          paramWebViewFragment = (String)((List)localObject2).get(0);
        }
      }
    }
    boolean bool;
    if (TextUtils.isEmpty(locala.bbd)) {
      bool = true;
    }
    while (bool)
    {
      if (locala.buv) {
        VACDReportUtil.a("originURL=" + paramWebViewFragment + "|interceptURL=" + paramString, "qqwallet", "InterceptOpenOtherApp", null, null, 0, null);
      }
      if (!locala.buw) {
        break;
      }
      if (!TextUtils.isEmpty(locala.mJumpUrl))
      {
        if (TextUtils.isEmpty(locala.bbf)) {
          locala.bbf = aA(locala.mJumpUrl, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDsE3WI7sDFUi6QWV/oK8qozDvS\nTlxmu1a3NSFxeOrjlVEVtOx8yIMVFYIixq/Fv1XgUlyvL7bGJbaLLKaqlYruGd2z\nNbaIz90Zm4H0pMFHx4vCYhsRP1HXbVMo2ZDiHEDbnSm/99uzFPPiXqLi8jE9t4if\n0GuYdSZfe5o+SIKT5QIDAQAB");
        }
        paramWebViewFragment = locala.bbf;
        if (QLog.isColorLevel()) {
          QLog.d("PayInterceptHelper", 2, "jumpUrl:" + paramWebViewFragment);
        }
        if (TextUtils.isEmpty(paramWebViewFragment)) {
          break;
        }
        if (!paramWebViewFragment.contains("?")) {
          break label515;
        }
        paramWebViewFragment = paramWebViewFragment + "&j=";
      }
      try
      {
        for (;;)
        {
          paramString = paramWebViewFragment + URLEncoder.encode(paramString, "UTF-8");
          if (QLog.isColorLevel()) {
            QLog.d("PayInterceptHelper", 2, "jumpUrl with params:" + paramString);
          }
          localCustomWebView.loadUrl(paramString);
          return true;
          if (locala.U == null) {
            locala.U = Pattern.compile(locala.bbd);
          }
          bool = locala.U.matcher(paramWebViewFragment).matches();
          break;
          label515:
          paramWebViewFragment = paramWebViewFragment + "?j=";
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = paramWebViewFragment;
        }
      }
    }
  }
  
  public void b(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null) {
      dW(paramJSONArray.toString(), paramString);
    }
    zQ(paramString);
  }
  
  public void zQ(String paramString)
  {
    paramString = hW(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      this.kt = zxs.a.ai(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayInterceptHelper", 2, "loadConfigFromSP|" + this.kt);
    }
  }
  
  public static class a
  {
    public Pattern T;
    public Pattern U;
    public String bbd;
    public String bbe;
    public String bbf;
    public boolean buv;
    public boolean buw;
    public String mJumpUrl;
    
    public static List<a> ai(String paramString)
    {
      localArrayList = new ArrayList();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          a locala;
          if (localJSONObject != null)
          {
            locala = new a();
            locala.bbd = localJSONObject.optString("sourceURLRegular");
            locala.bbe = localJSONObject.optString("interceptURLRegular");
            if (localJSONObject.optInt("shouldReport") != 1) {
              break label138;
            }
            bool = true;
            label85:
            locala.buv = bool;
            if (localJSONObject.optInt("shouldIntercept") != 1) {
              break label143;
            }
          }
          label138:
          label143:
          for (boolean bool = true;; bool = false)
          {
            locala.buw = bool;
            locala.mJumpUrl = localJSONObject.optString("jumpURL");
            localArrayList.add(locala);
            i += 1;
            break;
            bool = false;
            break label85;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public String toString()
    {
      return "InterceptConfig [mSrcUrlRegular=" + this.bbd + ", mInterceptUrlRegular=" + this.bbe + ", mIsReport=" + this.buv + ", mIsIntercept=" + this.buw + ", mJumpUrl=" + this.mJumpUrl + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxs
 * JD-Core Version:    0.7.0.1
 */