import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.QbossADBannerManager.2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aaje
  implements View.OnClickListener
{
  protected URLImageView ai;
  private aahb b;
  private boolean bvS;
  private boolean bvT;
  private Map<String, Boolean> iE = new HashMap();
  private boolean isClick;
  protected BaseActivity mActivity;
  protected View mLayout;
  protected View zA;
  protected View zz;
  
  public static aaje a(BaseActivity paramBaseActivity, aahb paramaahb)
  {
    Object localObject = aajd.a().a(getCurrentUin());
    if (localObject != null)
    {
      localObject = ((aajc)localObject).a();
      if (localObject != null) {
        ((aaje)localObject).a(paramBaseActivity, paramaahb);
      }
      return localObject;
    }
    return null;
  }
  
  private void b(aajc paramaajc)
  {
    this.bvS = paramaajc.Ww();
    if (this.bvS)
    {
      this.bvT = this.b.Wn();
      if (this.bvT) {
        cuK();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "startPreloadWebView needed: " + this.bvS + ", done: " + this.bvT);
    }
  }
  
  private void cuK()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", -1);
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  private void cuL()
  {
    this.bvS = false;
    this.bvT = false;
    if (QLog.isColorLevel()) {
      QLog.d("QbossADBannerManager", 2, "stopPreloadWebView");
    }
  }
  
  private static String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QbossADBannerManager", 4, "getCurrentUin = " + localAppRuntime.getAccount());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public void Cp(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerManager", 2, "onScrollChange isScroll = " + paramBoolean);
    }
  }
  
  public boolean Wo()
  {
    boolean bool = true;
    Object localObject = getCurrentUin();
    localObject = aajd.a().a((String)localObject);
    if ((localObject == null) || (((aajc)localObject).bR == null) || (((aajc)localObject).bR.size() == 0))
    {
      QLog.i("QbossADBannerManager", 1, "isNeedShowQBossADBanner configInfo is null, return false.");
      bool = false;
    }
    return bool;
  }
  
  protected void a(aajc paramaajc)
  {
    if (paramaajc == null) {
      return;
    }
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed show");
    String str = paramaajc.jumpUrl;
    this.isClick = false;
    this.iE.clear();
    this.iE.put(str, Boolean.valueOf(true));
    QLog.i("QbossADBannerManager", 1, "onQBossADBannerExposed start expose");
    avyz.a().reportExpose(paramaajc.bdl, null);
  }
  
  public void a(BaseActivity paramBaseActivity, aahb paramaahb)
  {
    this.mActivity = paramBaseActivity;
    this.b = paramaahb;
  }
  
  public View bH()
  {
    QLog.i("QbossADBannerManager", 1, "initQbossADBanner");
    this.mLayout = LayoutInflater.from(this.mActivity).inflate(yE(), null);
    this.zz = this.mLayout.findViewById(2131374494);
    this.zA = this.mLayout.findViewById(2131369099);
    this.ai = ((URLImageView)this.mLayout.findViewById(2131369089));
    ViewGroup.LayoutParams localLayoutParams = this.ai.getLayoutParams();
    localLayoutParams.width = yF();
    localLayoutParams.height = yG();
    this.ai.setLayoutParams(localLayoutParams);
    this.ai.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.ai.setOnClickListener(this);
    this.zA.setOnClickListener(this);
    this.zz.setVisibility(8);
    return this.mLayout;
  }
  
  public void bMT()
  {
    if ((this.bvS) && (!this.bvT))
    {
      this.bvT = true;
      cuK();
    }
  }
  
  protected int bV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString;
    if (!paramString.startsWith("#")) {
      str = "#" + paramString;
    }
    try
    {
      int i = Color.parseColor(str);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QZLog.i("QbossADBannerManager", 1, " getValidTextColor error color = " + str);
    }
    return -1;
  }
  
  public void cuE()
  {
    aajc localaajc = aajd.a().a(getCurrentUin());
    if (localaajc != null) {
      avyz.a().reportClick(localaajc.bdl, null);
    }
  }
  
  public void cuF()
  {
    aajc localaajc = aajd.a().a(getCurrentUin());
    if (localaajc != null) {
      avyz.a().reportClose(localaajc.bdl, null);
    }
  }
  
  public void cuG()
  {
    if ((this.zz == null) || (this.ai == null))
    {
      QLog.e("QbossADBannerManager", 1, "showQbossADBanner xml init error");
      cuI();
      return;
    }
    QLog.i("QbossADBannerManager", 1, "start showQbossADBanner");
    aajc localaajc = aajd.a().a(getCurrentUin());
    if ((localaajc != null) && (localaajc.bR != null))
    {
      aajc.a locala = (aajc.a)localaajc.bR.get(1);
      if (locala == null)
      {
        QLog.e("QbossADBannerManager", 1, "initQbossADBanner resourceInfo = null");
        cuI();
        return;
      }
      if ((!TextUtils.isEmpty(locala.filePath)) && ((localaajc.resType == 1) || (localaajc.resType == 0)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = yF();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = yG();
        if (localaajc.resType == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = bool;
          localObject = URLDrawable.getFileDrawable(locala.filePath, (URLDrawable.URLDrawableOptions)localObject);
          if (localObject != null) {
            break;
          }
          QLog.i("QbossADBannerManager", 1, "initQbossADBanner urlDrawable == null  file path = " + locala.filePath);
          cuI();
          return;
        }
        if (((URLDrawable)localObject).getStatus() == 1)
        {
          this.zz.setVisibility(0);
          this.ai.setImageDrawable((Drawable)localObject);
          QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable status is success");
          a(localaajc);
          return;
        }
        ((URLDrawable)localObject).setURLDrawableListener(new aajf(this, localaajc, locala));
        ThreadManager.executeOnFileThread(new QbossADBannerManager.2(this, (URLDrawable)localObject));
        return;
      }
      QLog.i("QbossADBannerManager", 1, "initQbossADBanner resType is wrong: " + localaajc.resType + " file path = " + locala.filePath);
      cuI();
      return;
    }
    QLog.i("QbossADBannerManager", 1, "initQbossADBanner config info is null, uin: " + getCurrentUin());
    cuI();
  }
  
  public void cuH()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QbossADBannerManager", 4, "checkIfHideBanner isClick: " + this.isClick);
    }
    if (this.isClick)
    {
      cuI();
      this.isClick = false;
    }
  }
  
  public void cuI()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerManager", 2, "hideBanner");
    }
    if (this.zz != null) {
      this.zz.setVisibility(8);
    }
    if (this.b != null)
    {
      this.b.cuo();
      cuL();
    }
    cuJ();
  }
  
  public void cuJ()
  {
    if (this.iE != null) {
      this.iE.clear();
    }
  }
  
  protected String ij(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if ((this.mActivity != null) && (this.mActivity.app != null)) {}
    for (String str = aqgv.n(this.mActivity.app, this.mActivity.app.getCurrentAccountUin());; str = "") {
      return paramString.replace("{nickname}", str);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      anot.c(this.mActivity.app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 11, 0, "", "", "", "");
      aajc localaajc;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        cuF();
        cuI();
        aajd.a().At(getCurrentUin());
        break;
        localaajc = aajd.a().a(getCurrentUin());
        if ((localaajc != null) && (!TextUtils.isEmpty(localaajc.jumpUrl))) {
          break label139;
        }
        QLog.e("QbossADBannerManager", 1, "qboss banner configInfo = null || jumpUrl = null");
      }
      label139:
      cuE();
      if (QLog.isColorLevel()) {
        QLog.i("QbossADBannerManager", 2, "qboss banner jump url = " + localaajc.jumpUrl);
      }
      Object localObject1;
      if (localaajc.jumpType == 1)
      {
        Object localObject2 = localaajc.jumpUrl;
        localObject1 = localObject2;
        if (!((String)localObject2).contains("http://"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).contains("https://")) {
            localObject1 = "https://" + (String)localObject2;
          }
        }
        if (((String)localObject1).contains("?")) {}
        for (localObject1 = (String)localObject1 + "&qboss_trace=" + localaajc.bdl;; localObject1 = (String)localObject1 + "?qboss_trace=" + localaajc.bdl)
        {
          localObject1 = (String)localObject1 + avug.P(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localaajc.bdl, "&");
          if (QLog.isDevelopLevel()) {
            QLog.i("QbossADBannerManager", 4, "TraceInfo qboss banner final traceInfo jump url = " + (String)localObject1);
          }
          this.isClick = true;
          localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
          this.mActivity.startActivity((Intent)localObject2);
          break;
        }
      }
      if (localaajc.jumpType == 2)
      {
        localObject1 = aqik.c(this.mActivity.app, this.mActivity, localaajc.jumpUrl);
        if (localObject1 != null)
        {
          this.isClick = true;
          ((aqhv)localObject1).ace();
        }
        else
        {
          avyz.a().s(2741, localaajc.taskId, 100, "qboss banner jump scheme action = null , url =  " + localaajc.jumpUrl);
        }
      }
    }
  }
  
  public void onRecycle() {}
  
  protected int yE()
  {
    return 2131562127;
  }
  
  protected int yF()
  {
    return aqnm.getScreenWidth();
  }
  
  protected int yG()
  {
    return (int)(yF() * 0.1333333F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaje
 * JD-Core Version:    0.7.0.1
 */