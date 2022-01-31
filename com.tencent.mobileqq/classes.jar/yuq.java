import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.GdtInterstitialView.2;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class yuq
  implements yta
{
  private ArkView jdField_a_of_type_ComTencentArkOpenArkView;
  private yuj jdField_a_of_type_Yuj = new yuj();
  
  public yuq(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    ArkAppNotifyCenter.setNotify(yui.a().a().a, new WeakReference(this.jdField_a_of_type_Yuj));
    this.jdField_a_of_type_ComTencentArkOpenArkView = a(paramContext, paramGdtInterstitialParams);
  }
  
  private static ArkView a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    WeakReference localWeakReference = new WeakReference(paramContext);
    if (paramGdtInterstitialParams != null) {}
    for (String str1 = paramGdtInterstitialParams.a();; str1 = null)
    {
      yuc localyuc = yui.a().a();
      String str2 = a(paramGdtInterstitialParams);
      yxp.b("GdtInterstitialView", String.format("load appName:%s view:%s minver:%s", new Object[] { localyuc.a, localyuc.b, localyuc.c }));
      long l = System.currentTimeMillis();
      ArkView localArkView = new ArkView(paramContext, null);
      localArkView.setBorderType(0);
      localArkView.load(localyuc.a, localyuc.b, localyuc.c, str2, null, new yur(l, str1, localWeakReference, paramGdtInterstitialParams));
      yyc.a(paramContext, paramGdtInterstitialParams);
      return localArkView;
    }
  }
  
  private static String a(GdtInterstitialParams paramGdtInterstitialParams)
  {
    if ((paramGdtInterstitialParams == null) || (!paramGdtInterstitialParams.b()))
    {
      yxp.d("GdtInterstitialView", "getMetaData error");
      return null;
    }
    String str;
    if (paramGdtInterstitialParams.jdField_a_of_type_Int == 1) {
      str = "vertical";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str))
      {
        yxp.d("GdtInterstitialView", "getMetaData error");
        return null;
        if ((paramGdtInterstitialParams.jdField_a_of_type_Int == 0) || (paramGdtInterstitialParams.jdField_a_of_type_Int == 8)) {
          str = "horizontal";
        }
      }
      else
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("screenType", str);
          paramGdtInterstitialParams = yxo.a(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a.info);
          if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams != JSONObject.NULL)) {
            localJSONObject.put("adInfo", paramGdtInterstitialParams);
          }
          paramGdtInterstitialParams = new JSONObject();
          paramGdtInterstitialParams.put("gdt", localJSONObject);
          paramGdtInterstitialParams = paramGdtInterstitialParams.toString();
          return paramGdtInterstitialParams;
        }
        catch (Throwable paramGdtInterstitialParams)
        {
          yxp.d("GdtInterstitialView", "getMetaData", paramGdtInterstitialParams);
          return null;
        }
      }
      str = null;
    }
  }
  
  private static void b(int paramInt1, int paramInt2, String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtInterstitialView.2(paramString, paramInt1, paramInt2), 0);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentArkOpenArkView;
  }
  
  public void a(Context paramContext)
  {
    yxp.b("GdtInterstitialView", "pause");
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.onPause();
    }
  }
  
  public void b(Context paramContext)
  {
    yxp.b("GdtInterstitialView", "resume");
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.onResume();
    }
  }
  
  public void c(Context paramContext)
  {
    yxp.b("GdtInterstitialView", "destroy");
    if (this.jdField_a_of_type_ComTencentArkOpenArkView != null) {
      this.jdField_a_of_type_ComTencentArkOpenArkView.onDestroy();
    }
    ArkAppNotifyCenter.setNotify(yui.a().a().a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuq
 * JD-Core Version:    0.7.0.1
 */