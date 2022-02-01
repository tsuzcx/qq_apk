import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class nnu
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private ShareActionSheetBuilder a;
  private String amP;
  private String amQ;
  private String amR = "";
  private String amS = "";
  private String amT = "";
  private boolean atC;
  private int baA;
  private int baB;
  private int baz;
  private Bitmap ce;
  private arhz m;
  private Activity mActivity;
  private skj mClient;
  private AdapterView.OnItemClickListener mItemClickListener;
  private int mScreenWidth;
  private String mUrl;
  private Handler uiHandler = new auru(Looper.getMainLooper(), this);
  private JSONArray w;
  
  public nnu(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    this.baA = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
    this.mUrl = "";
    paramActivity = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
    this.mScreenWidth = paramActivity.widthPixels;
  }
  
  private void pT(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToWechatCircle!");
    }
    int i = qM();
    if (i != -1)
    {
      rwt.ez(0, i);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.amP))
      {
        a(this.mClient, this.atC, paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("", 1, "shareScreenShotToWeChat, isTimeline=" + paramBoolean + "e=" + localException.toString());
      return;
    }
    QLog.e("", 1, "shareScreenShotToWeChat, mScreenshotWithQRPath is Empty");
  }
  
  public arhz a()
  {
    if (this.m == null)
    {
      this.m = new arhz(this.mActivity, this.baA);
      this.m.setMessage(2131695695);
    }
    return this.m;
  }
  
  public ShareActionSheetBuilder a()
  {
    return this.a;
  }
  
  protected void a(skj paramskj, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      paramskj.g(new nnv(this, paramBoolean2));
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 2)
    {
      this.baz = i;
      aZD();
      return;
    }
  }
  
  public void aAL()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "showShareActionSheet->mEditScreenshotPath:" + this.amQ);
    }
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    if (this.a == null) {
      this.a = new ShareActionSheetBuilder(this.mActivity);
    }
    if ((ocp.ey(this.mUrl)) && (!TextUtils.isEmpty(kH()))) {
      this.a.setActionSheetTitle(kH());
    }
    for (;;)
    {
      this.a.setActionSheetItems(c());
      this.a.setItemClickListener(this);
      try
      {
        this.a.show();
        if (QLog.isDevelopLevel()) {
          QLog.d("", 2, "showShareActionSheet->post runnable generate screenshot with QRcode! time:" + System.currentTimeMillis());
        }
        this.atC = true;
        this.amP = null;
        this.baz = 0;
        if (this.ce != null)
        {
          this.ce.recycle();
          this.ce = null;
        }
        ThreadManager.executeOnSubThread(new ScreenShotShareHelper.1(this));
        return;
        this.a.setActionSheetTitle(BaseApplicationImpl.getContext().getString(2131720177));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "actionSheet.show exception=" + localException);
          }
        }
      }
    }
  }
  
  public void aZA()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQZone!");
    }
    if ((!this.atC) && (!TextUtils.isEmpty(this.amP)))
    {
      avpw.d locald = avpw.d.a();
      locald.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      avpw.a(this.mActivity, locald, this.amP, BaseApplicationImpl.getContext().getString(2131721919), "", -1);
      return;
    }
    this.baz = 1;
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697454, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
  }
  
  public void aZB()
  {
    pT(false);
  }
  
  public void aZC()
  {
    pT(true);
  }
  
  @VisibleForTesting
  protected void aZD()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697454, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
  }
  
  public void aZE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "shareMsgToSina start!");
    }
    if (this.m == null)
    {
      this.m = new arhz(this.mActivity, this.baA);
      this.m.setMessage(2131695695);
    }
    this.m.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina installSinaWeibo:true");
        }
        if (!TextUtils.isEmpty(this.amT)) {
          continue;
        }
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131697452);
        this.amS = ((String)localObject);
        if (!TextUtils.isEmpty(this.amR)) {
          continue;
        }
        localObject = this.mUrl;
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", this.amS + (String)localObject);
        if (!TextUtils.isEmpty(this.amQ)) {
          localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.amQ)));
        }
        localIntent.setPackage(localApplicationInfo.packageName);
        this.mActivity.startActivity(localIntent);
        if ((this.m != null) && (this.m.isShowing())) {
          this.m.dismiss();
        }
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "shareMsgToSina start weibo!");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("", 2, "shareMsgToSina installSinaWeibo:false");
        if ((this.m == null) || (!this.m.isShowing())) {
          continue;
        }
        this.m.dismiss();
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697462, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "shareMsgToSina end!");
      }
      return;
      localObject = this.amT;
      continue;
      localObject = this.amR;
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] c()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getContext().getString(2131698647);
    localActionSheetItem.icon = 2130839255;
    localActionSheetItem.action = 12;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  @VisibleForTesting
  protected void dm(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      WxShareHelperFromReadInjoy.a().a(this.amP, this.ce, paramInt2, false);
    }
    for (;;)
    {
      this.ce.recycle();
      this.ce = null;
      return;
      WXShareHelper.a().a(this.amP, this.ce, paramInt2, false);
    }
  }
  
  public String getUrl()
  {
    if (this.mUrl != null) {
      return this.mUrl;
    }
    return "";
  }
  
  public void h(JSONArray paramJSONArray)
  {
    this.w = paramJSONArray;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public String kH()
  {
    String str2 = BaseApplicationImpl.getApplication().getString(2131720136);
    String str1 = str2;
    try
    {
      if (this.w != null)
      {
        int i = this.w.length();
        i = new Random().nextInt(i);
        str1 = this.w.getString(i);
      }
      return str1;
    }
    catch (Exception localException)
    {
      do
      {
        str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.d("", 2, "actionSheet.show exception=" + localException);
    }
    return str2;
  }
  
  public String kI()
  {
    return this.amT;
  }
  
  public void m(String paramString1, String paramString2, int paramInt)
  {
    this.amQ = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.contains("ShotCache_"))) {
      this.baB = 3;
    }
    if ((this.baB == 0) && (paramInt > 0)) {
      this.baB = paramInt;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "doOnPhotoPlusActivityEditResult->mScreenshotFromType:" + this.baB + ", mEditScreenshotPath:" + this.amQ + ", originImagePath:" + paramString2);
    }
    if (this.baB == 3)
    {
      om(this.amQ);
      return;
    }
    aAL();
  }
  
  public void ok(String paramString)
  {
    this.amS = paramString;
  }
  
  public void ol(String paramString)
  {
    this.amT = paramString;
  }
  
  public void om(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "shareScreenShotToQQ->imgPath:" + paramString);
    }
    Intent localIntent = new Intent(this.mActivity, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    String str;
    if (TextUtils.isEmpty(this.amR))
    {
      paramString = this.mUrl;
      if (!TextUtils.isEmpty(this.amT)) {
        break label271;
      }
      str = BaseApplicationImpl.getContext().getResources().getString(2131697452);
      label115:
      paramString = "ScreenShotShare|" + paramString + "|" + str;
      if (this.baB != 3) {
        break label279;
      }
    }
    label271:
    label279:
    for (paramString = paramString.concat("|1");; paramString = paramString.concat("|0"))
    {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("req_type", 5);
      localIntent.putExtra("struct_share_key_source_icon", "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
      localIntent.putExtra("struct_share_key_source_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localIntent.putExtra("stuctmsg_bytes", anre.a(localIntent.getExtras()).getBytes());
      this.mActivity.startActivityForResult(localIntent, 1);
      return;
      paramString = this.amR;
      break;
      str = this.amT;
      break label115;
    }
  }
  
  public void on(String paramString)
  {
    this.amR = paramString;
  }
  
  public void onDestroy()
  {
    if (this.mClient != null) {
      this.mClient.bzk();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject = paramView.getTag();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onScreenShotItemClick->tag null!");
      }
    }
    label189:
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.a.dismiss();
      switch (((ShareActionSheetBuilder.b)localObject).b.action)
      {
      }
      for (;;)
      {
        if (this.mItemClickListener == null) {
          break label189;
        }
        this.mItemClickListener.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        break;
        om(this.amQ);
        continue;
        aZA();
        continue;
        aZB();
        continue;
        aZC();
        continue;
        aZE();
      }
    }
  }
  
  @VisibleForTesting
  protected int qM()
  {
    int i = -1;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    while (WXShareHelper.a().isWXsupportApi()) {
      return i;
    }
    return 2131721936;
  }
  
  public int qN()
  {
    return this.baB;
  }
  
  public Bitmap s(String paramString)
  {
    paramString = nnt.a(paramString, this.mScreenWidth, this.mUrl, "QRCode_");
    this.amP = ((String)paramString.first);
    paramString = (Bitmap)paramString.second;
    if (QLog.isDevelopLevel()) {
      QLog.d("", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
    }
    this.atC = false;
    if ((!TextUtils.isEmpty(this.amP)) && (this.baz > 0)) {}
    switch (this.baz)
    {
    default: 
      return paramString;
    case 1: 
      aZA();
      return paramString;
    case 2: 
      this.uiHandler.post(new ScreenShotShareHelper.2(this));
      return paramString;
    }
    this.uiHandler.post(new ScreenShotShareHelper.3(this));
    return paramString;
  }
  
  public void setItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void tO(int paramInt)
  {
    this.baB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnu
 * JD-Core Version:    0.7.0.1
 */