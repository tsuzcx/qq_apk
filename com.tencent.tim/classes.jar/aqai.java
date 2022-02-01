import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.5;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.6;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.7;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.8;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.1;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.2;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.3;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.4;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog.YYBDownloadListener.5;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class aqai
  extends aqju
{
  private static boolean cTl;
  private static int dYj = 3;
  private static long lastTimeStamp;
  ImageView EW;
  TextView abt;
  TextView abu;
  TextView abv;
  TextView abw;
  TextView abx;
  TextView aby;
  private volatile boolean cBH;
  private boolean cTj;
  private boolean cTk = true;
  private aryx d;
  protected View.OnClickListener gb = new aqam(this);
  private boolean isInited;
  public final WeakReference<Activity> mActivity;
  private int mCurrentState = 1;
  ProgressBar progressBar;
  
  public aqai(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559707);
    this.d = new aqai.a();
    this.cTk = aryq.aHm();
    aryy.a();
    setOnKeyListener(new aqaj(this));
    ecO();
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 1, 100));
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 2, 100));
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 3, 100));
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 4, 100));
    arub.a().postReport(16, arud.b(10010, dYj, 1, 100));
    arub.a().postReport(16, arud.b(10010, dYj, 2, 100));
    arub.a().postReport(16, arud.b(10010, dYj, 3, 100));
    arub.a().postReport(16, arud.b(10010, dYj, 4, 100));
    if (dYj == 2)
    {
      anot.a(null, "dc00898", "", "", "0X8008F7F", "0X8008F7F", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "dc00898", "", "", "0X8008F82", "0X8008F82", 0, 0, "", "", "", "");
  }
  
  private void Xl(int paramInt)
  {
    this.mCurrentState = paramInt;
    this.aby.getPaint().setFakeBoldText(false);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.aby.setText(acfp.m(2131709123));
      return;
    case 1: 
    case 20: 
      this.aby.setText(acfp.m(2131709135));
      return;
    case 3: 
      this.aby.setText(acfp.m(2131709133));
      return;
    case 4: 
      this.aby.setText(acfp.m(2131709137));
      return;
    }
    this.aby.setText(acfp.m(2131709130));
  }
  
  public static String a(double paramDouble, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt <= 0)
    {
      localStringBuilder.append((int)Math.round(paramDouble));
      return localStringBuilder.toString();
    }
    if ((paramInt == 1) && (paramDouble >= (int)paramDouble + 0.95D)) {
      localStringBuilder.append((int)paramDouble + 1);
    }
    double d1;
    for (;;)
    {
      localStringBuilder.append(".");
      d1 = 1.0D;
      i = 0;
      while (i < paramInt)
      {
        d1 *= 10.0D;
        i += 1;
      }
      localStringBuilder.append((int)paramDouble);
    }
    paramDouble = Math.abs(Math.round((paramDouble - (int)paramDouble) * d1) / d1);
    int i = j;
    while (i < paramInt)
    {
      paramDouble *= 10.0D;
      localStringBuilder.append((int)paramDouble % 10);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(float paramFloat, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(a(paramFloat / 1024.0F / 1024.0F, paramInt));
    if (paramBoolean) {
      return "MB";
    }
    return localStringBuilder.toString();
  }
  
  public static void ecO()
  {
    cTl = aqma.aEV();
    if (cTl)
    {
      dYj = 2;
      return;
    }
    dYj = 3;
  }
  
  public static void ecP()
  {
    cTl = true;
    dYj = 2;
  }
  
  private void ecQ()
  {
    ThreadManager.getUIHandler().post(new NewUpgradeDialog.5(this));
    ecV();
    installYYB();
  }
  
  private void ecR()
  {
    this.cTk = aryq.aHm();
    if (this.cTk)
    {
      if (!arwo.isNetworkAvailable((Context)this.mActivity.get())) {
        arxa.a().showToast(acfp.m(2131709122));
      }
    }
    else {
      return;
    }
    Xl(2);
    aryy.a().b(aryy.a().c("1101070898"));
  }
  
  private void ecU()
  {
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 3, 200));
    arub.a().postReport(17, arud.b(10010, dYj, 3, 200));
    if (dYj == 2) {
      anot.a(null, "dc00898", "", "", "0X8008F81", "0X8008F81", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      arzk.a();
      if (!arzk.aHx()) {
        break;
      }
      v((Activity)this.mActivity.get());
      dismiss();
      ((Activity)this.mActivity.get()).finish();
      return;
      anot.a(null, "dc00898", "", "", "0X8008F84", "0X8008F84", 0, 0, "", "", "", "");
    }
    this.cTj = true;
    this.isInited = true;
    DownloadInfo localDownloadInfo = aryy.a().c("1101070898");
    this.cTk = aryq.aHm();
    if (this.cTk)
    {
      if (!arwo.isNetworkAvailable((Context)this.mActivity.get()))
      {
        arxa.a().showToast(acfp.m(2131709124));
        this.cTj = false;
        this.isInited = false;
        return;
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.getState() != 4)) {
        iq(localDownloadInfo.progress, localDownloadInfo.getState());
      }
      if ((localDownloadInfo == null) || (localDownloadInfo.getState() == 1) || (localDownloadInfo.getState() == 10) || (localDownloadInfo.getState() == 3) || (localDownloadInfo.getState() == 4))
      {
        arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 3, 500));
        arub.a().postReport(18, arud.b(10010, dYj, 3, 500));
        arzk.a().g((Activity)this.mActivity.get(), "ANDROIDQQ.NEWYYB.QQUPDATE", true);
      }
    }
    for (;;)
    {
      aryy.a().a(this.d);
      return;
      ThreadManager.post(new NewUpgradeDialog.6(this), 5, null, false);
    }
  }
  
  private void ecV()
  {
    int j = 0;
    Object localObject = aqap.a().b();
    if ((localObject == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a == null))
    {
      arxa.a().showToast(acfp.m(2131709132));
      return;
    }
    int k = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn;
    int i = k;
    if (k == 999) {
      i = 718;
    }
    try
    {
      k = BaseActivity.sTopActivity.getPackageManager().getPackageInfo(BaseActivity.sTopActivity.getPackageName(), 0).versionCode;
      j = k;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Bundle localBundle;
        localNameNotFoundException.printStackTrace();
      }
    }
    localObject = "tmast://appdetails?r=0.9138136501079244&pname=com.tencent.mobileqq&oplist=1%3B2&via=ANDROIDQQ.NEWYYB.QQUPDATE&appid=" + ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid + "&versioncode=" + i + "&hostpname=" + BaseApplicationImpl.getApplication().getPackageName() + "&hostversioncode=" + j + "\"\n";
    localBundle = new Bundle();
    localBundle.putString("url", (String)localObject);
    aryr.dJ(localBundle);
    aryr.dK(localBundle);
    arzk.a().emi();
    ecW();
  }
  
  private void ecW()
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = aqap.a().b();
    if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a == null))
    {
      arxa.a().showToast(acfp.m(2131709125));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csi);
    localBundle.putString("url", localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    localBundle.putString("appId", String.valueOf(localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid));
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", "com.tencent.mobileqq");
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.8(this, localBundle));
  }
  
  private void installYYB()
  {
    arwt.i("NewUpgradeDialog", arud.b(10010, dYj, 3, 300));
    arub.a().postReport(21, arud.b(10010, dYj, 3, 300));
    DownloadInfo localDownloadInfo = aryy.a().c("1101070898");
    aryy.a().y(localDownloadInfo);
  }
  
  private void resetState()
  {
    this.aby.getPaint().setFakeBoldText(true);
    this.aby.setText(acfp.m(2131709126));
    this.progressBar.setProgress(0);
    this.cTj = true;
    this.mCurrentState = 1;
  }
  
  public static boolean v(Activity paramActivity)
  {
    if (System.currentTimeMillis() - lastTimeStamp <= 1000L) {
      return false;
    }
    lastTimeStamp = System.currentTimeMillis();
    Object localObject1 = aqap.a().b();
    if ((localObject1 == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) || (((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a == null))
    {
      arxa.a().showToast(acfp.m(2131709127));
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("sdkShowNotification", 0);
    localBundle.putBoolean("showNetworkDialog", false);
    localBundle.putString("appName", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.csi);
    localBundle.putString("url", ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
    localBundle.putString("via", "ANDROIDQQ.YYB.QQUPDATE");
    Object localObject2 = String.valueOf(((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iAppid);
    localBundle.putString("appId", (String)localObject2);
    localBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    localBundle.putBoolean("autoInstall", true);
    int j = ((UpgradeDetailWrapper)localObject1).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$a.dYn;
    int i = j;
    if (j == 999) {
      i = 718;
    }
    localBundle.putInt("versionCode", i);
    localBundle.putString("packageName", BaseApplicationImpl.getApplication().getPackageName());
    localBundle.putInt("downloadType", 1);
    localBundle.putBoolean("autoDownload", true);
    localObject2 = aryy.a().c((String)localObject2);
    localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((DownloadInfo)localObject2).filePath;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localBundle.putInt(aryv.PARAM_ACTIONCODE, 5);
        aryr.b(localBundle, "biz_src_jc_update", aqap.a().b().jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail);
        return true;
      }
    }
    if ((aryq.aHs()) || (arzk.a().aHB())) {
      ThreadManager.getSubThreadHandler().post(new NewUpgradeDialog.7(paramActivity, localBundle));
    }
    for (;;)
    {
      return true;
      UpgradeDetailActivity.a(paramActivity, aqap.a().b(), false, true, true);
    }
  }
  
  public aqai a(long paramLong)
  {
    String str = a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      this.abu.setText(acfp.m(2131709129) + str);
    }
    return this;
  }
  
  public aqai a(DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.abx.setVisibility(0);
    this.abx.setOnClickListener(new aqal(this, paramOnClickListener, paramBoolean));
    return this;
  }
  
  public aqai a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.abt.setText(paramCharSequence);
      this.abt.setVisibility(0);
    }
    return this;
  }
  
  public aqai b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.abw.setText(paramCharSequence);
    }
    return this;
  }
  
  public aqai c(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.abv.setText(paramCharSequence);
    }
    paramCharSequence = new SpannableString("推荐使用\"省流升级\",通过QQ官方下载器\"应用宝\"升级,节省流量速度更快");
    paramCharSequence.setSpan(new ForegroundColorSpan(Color.parseColor("#0099EE")), 21, 24, 17);
    this.abv.setText(paramCharSequence);
    this.abv.setVisibility(0);
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      if (this.mCurrentState != 2)
      {
        this.isInited = false;
        aryy.a().b(this.d);
        this.d = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void ecS()
  {
    this.cTk = aryq.aHm();
    if (this.cTk)
    {
      if (!arwo.isNetworkAvailable((Context)this.mActivity.get())) {
        arxa.a().showToast(acfp.m(2131709134));
      }
    }
    else {
      return;
    }
    Xl(3);
    aryy.a().fw("1101070898");
  }
  
  public void ecT()
  {
    DownloadInfo localDownloadInfo = aryy.a().c("1101070898");
    if ((localDownloadInfo != null) && (localDownloadInfo.getState() == 2)) {
      aryy.a().fw("1101070898");
    }
  }
  
  public void iq(int paramInt1, int paramInt2)
  {
    int i = 100;
    arwt.d("NewUpgradeDialog", "updateView--progress--" + paramInt1 + " state = " + paramInt2);
    this.mCurrentState = paramInt2;
    Xl(paramInt2);
    if (paramInt2 == 4) {
      paramInt1 = 100;
    }
    for (;;)
    {
      if (paramInt1 < 0)
      {
        this.cTj = this.isInited;
        paramInt1 = 0;
      }
      for (;;)
      {
        this.progressBar.setProgress(paramInt1);
        if (this.cTj)
        {
          this.progressBar.setVisibility(0);
          return;
          if (paramInt1 >= 100)
          {
            this.cTj = false;
            paramInt1 = i;
          }
        }
        else
        {
          this.progressBar.setVisibility(4);
          return;
        }
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.abt = ((TextView)findViewById(2131365867));
    this.abu = ((TextView)findViewById(2131381153));
    this.abw = ((TextView)findViewById(2131365863));
    this.abv = ((TextView)findViewById(2131381149));
    this.abx = ((TextView)findViewById(2131365852));
    this.aby = ((TextView)findViewById(2131365858));
    this.aby.setVisibility(0);
    this.aby.getPaint().setFakeBoldText(true);
    this.aby.setOnClickListener(this.gb);
    this.progressBar = ((ProgressBar)findViewById(2131373659));
    this.progressBar.setProgress(0);
    this.EW = ((ImageView)findViewById(2131369005));
    this.EW.setOnClickListener(new aqak(this));
  }
  
  public class a
    implements aryx
  {
    private long asv;
    private long asw;
    
    protected a() {}
    
    public void installSucceed(String paramString1, String paramString2)
    {
      long l;
      if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
      {
        l = System.currentTimeMillis();
        if (l - this.asw >= 1000L) {}
      }
      else
      {
        return;
      }
      this.asw = l;
      arwt.i("NewUpgradeDialog", arud.b(10010, aqai.dYj, 3, 400));
      arub.a().postReport(22, arud.b(10010, aqai.dYj, 3, 400));
    }
    
    public void onDownloadCancel(DownloadInfo paramDownloadInfo)
    {
      arwt.d("NewUpgradeDialog", "onDownloadCancel");
    }
    
    public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("NewUpgradeDialog", "onDownloadError state = " + paramInt2);
        if ((paramDownloadInfo.progress == 100) || (paramDownloadInfo.getState() == 4)) {
          onDownloadFinish(paramDownloadInfo);
        }
      }
      else
      {
        return;
      }
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.4(this, paramDownloadInfo));
    }
    
    public void onDownloadFinish(DownloadInfo paramDownloadInfo)
    {
      arwt.d("NewUpgradeDialog", "onDownloadFinish");
      long l;
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        l = System.currentTimeMillis();
        if (l - this.asv >= 1000L) {}
      }
      else
      {
        return;
      }
      this.asv = l;
      arwt.i("NewUpgradeDialog", arud.b(10010, aqai.dYj, 3, 700));
      arub.a().postReport(20, arud.b(10010, aqai.dYj, 3, 700));
      ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.2(this, paramDownloadInfo));
      if (aqai.b(aqai.this))
      {
        aqai.b(aqai.this);
        arwt.d("NewUpgradeDialog", acfp.m(2131709120));
        return;
      }
      arwt.d("NewUpgradeDialog", acfp.m(2131709128));
    }
    
    public void onDownloadPause(DownloadInfo paramDownloadInfo)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("NewUpgradeDialog", "onDownloadPause");
        arwt.i("NewUpgradeDialog", arud.b(10010, aqai.dYj, 3, 600));
        arub.a().postReport(19, arud.b(10010, aqai.dYj, 3, 600));
        ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.1(this, paramDownloadInfo));
      }
    }
    
    public void onDownloadUpdate(List<DownloadInfo> paramList)
    {
      arwt.d("NewUpgradeDialog", "onDownloadUpdate");
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
          if (localDownloadInfo.appId.equals("1101070898"))
          {
            arwt.d("NewUpgradeDialog", "onDownloadUpdate STATE = " + localDownloadInfo.getState());
            ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.3(this, localDownloadInfo));
          }
        }
      }
    }
    
    public void onDownloadWait(DownloadInfo paramDownloadInfo)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898"))) {
        arwt.d("NewUpgradeDialog", "onDownloadWait");
      }
    }
    
    public void packageReplaced(String paramString1, String paramString2) {}
    
    public void uninstallSucceed(String paramString1, String paramString2)
    {
      if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
      {
        aqai.a(aqai.this, new a(aqai.this));
        ThreadManager.getUIHandler().post(new NewUpgradeDialog.YYBDownloadListener.5(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqai
 * JD-Core Version:    0.7.0.1
 */