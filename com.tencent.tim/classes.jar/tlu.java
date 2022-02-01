import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.open.downloadnew.DownloadInfo;
import java.security.MessageDigest;
import java.util.concurrent.ConcurrentHashMap;

public class tlu
  implements AdRefreshCallback
{
  private static volatile tlu jdField_a_of_type_Tlu;
  private final String TAG = "GdtDownloadReportManager";
  private AdAppBtnData jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasComponentsAppbuttonAdAppBtnData;
  private GdtAd ad;
  private aryx b = new tlv(this);
  private ConcurrentHashMap<String, GdtAd> cI = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GdtAd> cJ = new ConcurrentHashMap();
  
  private tlu()
  {
    registerDownloadListener();
  }
  
  public static tlu a()
  {
    if (jdField_a_of_type_Tlu == null) {}
    try
    {
      if (jdField_a_of_type_Tlu == null) {
        jdField_a_of_type_Tlu = new tlu();
      }
      return jdField_a_of_type_Tlu;
    }
    finally {}
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtAd paramGdtAd)
  {
    if ((paramDownloadInfo == null) || (paramGdtAd == null) || (TextUtils.isEmpty(paramDownloadInfo.packageName)) || (TextUtils.isEmpty(paramGdtAd.getAppPackageName())) || (TextUtils.isEmpty(paramDownloadInfo.appId)) || (TextUtils.isEmpty(paramGdtAd.getAppId()))) {}
    while ((!paramDownloadInfo.packageName.equals(paramGdtAd.getAppPackageName())) || (!paramDownloadInfo.appId.equals(paramGdtAd.getAppId()))) {
      return false;
    }
    return true;
  }
  
  private String gX(String paramString)
  {
    Object localObject1 = null;
    try
    {
      paramString = BaseApplicationImpl.getApplication().getApplicationContext().getPackageManager().getPackageInfo(paramString, 64).signatures;
      Object localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).update(paramString[0].toByteArray());
      localObject2 = AdHexUtil.bytes2HexString(((MessageDigest)localObject2).digest());
      paramString = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString = ((String)localObject2).toUpperCase();
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void registerDownloadListener()
  {
    tkw.d("GdtDownloadReportManager", "registerDownloadListener: ");
    arvv.a().a(this.b);
  }
  
  private void uw(String paramString)
  {
    this.cI.remove(paramString);
    this.cJ.remove(paramString);
  }
  
  public void a(GdtAd paramGdtAd, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (!paramBoolean) {
        break label23;
      }
      tlg.a(paramGdtAd, 269);
    }
    for (;;)
    {
      tlg.a(paramGdtAd, 272);
      return;
      label23:
      tlg.a(paramGdtAd, 268);
    }
  }
  
  public void a(String paramString, GdtAd paramGdtAd, AdAppBtnData paramAdAppBtnData)
  {
    if (TextUtils.isEmpty(paramString))
    {
      tkw.e("GdtDownloadReportManager", "appId isEmpty");
      return;
    }
    if (!this.cI.containsKey(paramString)) {
      this.cI.put(paramString, paramGdtAd);
    }
    this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasComponentsAppbuttonAdAppBtnData = paramAdAppBtnData;
  }
  
  public void onAdRefresh(Ad paramAd)
  {
    if ((paramAd instanceof GdtAd)) {
      this.ad = ((GdtAd)paramAd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlu
 * JD-Core Version:    0.7.0.1
 */