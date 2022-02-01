import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.1;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.HashMap;
import java.util.List;

public class agil
{
  private agil.a a;
  private boolean cdt;
  private QQAppInterface mApp;
  private HashMap<Integer, agil.c> mCallbackMap;
  
  public agil(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.a = new agil.a();
    this.mCallbackMap = new HashMap();
  }
  
  private static String aj(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("tmast://appdetails?");
    localStringBuilder.append("pname=").append(paramString);
    if (paramInt == 2) {
      localStringBuilder.append("&via=").append("ANDROIDQQ.NEWYYB.APKBYYBAPK");
    }
    for (;;)
    {
      localStringBuilder.append("&qimei=").append(UserAction.getQIMEI());
      return localStringBuilder.toString();
      localStringBuilder.append("&via=").append("ANDROIDQQ.YYB.APKBYYBAPK");
    }
  }
  
  public static void eC(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. apk package name can not be null.");
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : apkPkgName[" + paramString + "]");
    }
    paramString = aj(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : jumpTmast[" + paramString + "]");
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    TMAssistantCallYYB_V2.getInstance().addDownloadTaskFromTmast((Bundle)localObject);
    localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setPackage("com.tencent.android.qqdownloader");
    ((Intent)localObject).setData(Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_file");
    try
    {
      BaseApplication.getContext().startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "startAppStoreByTmast : error. " + paramString.getMessage());
    }
  }
  
  public void a(String paramString, agil.c paramc)
  {
    dgD();
    ThreadManagerV2.excute(new QFileAppStorePromoteManager.2(this, paramString, paramc), 128, null, true);
  }
  
  public boolean a(Context paramContext, String paramString, agil.b paramb)
  {
    if (((agiq)this.mApp.getManager(317)).a().bVt)
    {
      String str1 = paramContext.getString(2131700350);
      paramString = String.format(paramContext.getString(2131700347), new Object[] { paramString });
      String str2 = paramContext.getString(2131700348);
      String str3 = paramContext.getString(2131700349);
      agim localagim = new agim(this, paramb);
      paramb = new agin(this, paramb);
      aqha.a(paramContext, 0, str1, paramString, str2, str3, paramContext.getString(2131721058), localagim, paramb).show();
      anot.a(null, "dc00898", "", "", "0X800AE3F", "0X800AE3F", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public String aB(Context paramContext)
  {
    String str2 = ((agiq)this.mApp.getManager(317)).a().bAu;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramContext.getString(2131700344);
    }
    return str1;
  }
  
  public boolean alf()
  {
    dgD();
    int i = TMAssistantCallYYB_V2.getInstance().checkQQDownloaderInstalled();
    if ((i == 2) || (i == 0))
    {
      i = 1;
      if (i == 0) {
        break label53;
      }
    }
    label53:
    for (int j = GlobalUtil.getInstance().getQQDownloaderVersionCode();; j = 0)
    {
      if ((i != 0) && (j > 7342130))
      {
        return true;
        i = 0;
        break;
      }
      return false;
    }
  }
  
  public boolean alg()
  {
    return ((agiq)this.mApp.getManager(317)).a().bVs;
  }
  
  public void bw(Context paramContext, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("params_open_with_yyb", paramString);
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_jc_file");
    if (aglz.a().getApp() == null)
    {
      paramString = new Bundle();
      paramString.putString("_filename_from_dlg", paramContext.getString(2131696541));
      paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
      paramString.putBundle("_user_data", (Bundle)localObject);
      localObject = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
      ((Intent)localObject).putExtra("param", paramString);
      ((Intent)localObject).putExtra("url", "https://a.app.qq.com/o/myapp-down?g_f=1116518");
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    paramString = new Bundle();
    paramString.putString("_filename_from_dlg", paramContext.getString(2131696541));
    paramString.putString("big_brother_source_key", "biz_src_jc_file");
    paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    paramString.putBundle("_user_data", (Bundle)localObject);
    aglz.a().y("https://a.app.qq.com/o/myapp-down?g_f=1116518", paramString);
  }
  
  public void bx(Context paramContext, String paramString)
  {
    if (aglz.a().ms("https://a.app.qq.com/o/myapp-down?g_f=1116518"))
    {
      QQToast.a(paramContext, 0, 2131700346, 0).show();
      return;
    }
    String str = paramContext.getString(2131700345);
    aqha.a((Activity)paramContext, str, 2131721058, 2131721079, new agio(this, paramContext, paramString), new agip(this)).show();
  }
  
  public void dgD()
  {
    if (!this.cdt)
    {
      ThreadManagerV2.executeOnSubThread(new QFileAppStorePromoteManager.1(this));
      this.cdt = true;
    }
  }
  
  public class a
    extends GetAppInfoCallback
  {
    a() {}
    
    public void onGetAppInfoResponse(int paramInt1, int paramInt2, List<AppDetail> paramList)
    {
      if ((paramList == null) || (paramList.size() <= 0)) {
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new QFileAppStorePromoteManager.FetchAppInfoCallback.1(this, paramInt1, paramInt2, paramList));
    }
  }
  
  public static abstract interface b
  {
    public abstract void dgE();
    
    public abstract void dgF();
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, AppDetail paramAppDetail);
    
    public abstract void dgp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agil
 * JD-Core Version:    0.7.0.1
 */