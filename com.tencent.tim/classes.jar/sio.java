import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView;
import com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.10;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.8;
import com.tencent.biz.subscribe.widget.SubscribeVideoSharedCardView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class sio
  extends ode
{
  public static final String aEk = acbn.SDCARD_PATH + "subscribe_shared_card/";
  private String Qt;
  private AbsSubscribeShareCardView jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView;
  private WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  private sil jdField_a_of_type_Sil;
  private final String aEl = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private san c;
  private Handler mThreadHandler;
  private final String rootPath = acbn.SDCARD_PATH + "subscribe_card/";
  private Activity s;
  
  public sio(Activity paramActivity)
  {
    this.s = paramActivity;
    if (this.jdField_a_of_type_Ode$c == null) {
      this.jdField_a_of_type_Ode$c = new ode.c();
    }
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.mThreadHandler = new Handler(paramActivity.getLooper());
    this.mThreadHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private boolean MO()
  {
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1)
      {
        rwt.ez(0, i);
        return false;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        return true;
      }
      i = -1;
    }
  }
  
  private boolean MP()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView != null)
    {
      String str = gD(this.rootPath);
      if (!TextUtils.isEmpty(str))
      {
        if (new File(str).exists())
        {
          QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
          return true;
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.ab();
        if (localBitmap != null) {
          return Utils.saveBitmapToFile(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private boolean MQ()
  {
    return (WXShareHelper.a().a() != null) && (WXShareHelper.a().a().getWXAppSupportAPI() >= 654314752);
  }
  
  private boolean MR()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  private AbsSubscribeShareCardView a()
  {
    if ((this.c != null) && (this.c.mExtraTypeInfo != null)) {
      switch (this.c.mExtraTypeInfo.pageType)
      {
      }
    }
    do
    {
      return null;
      return new SubscribeVideoSharedCardView(this.s);
      return new SubscribeMultiPicSharedCardView(this.s);
      if (this.c.shareFromType == 1) {
        return new SubScribePersonalSharedCardView(this.s);
      }
      if (this.c.shareFromType == 3) {
        return new SubscribeVideoSharedCardView(this.s);
      }
    } while (this.c.shareFromType != 4);
    return new SubscribeMultiPicSharedCardView(this.s);
  }
  
  private void a(AbsSubscribeShareCardView paramAbsSubscribeShareCardView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
      byQ();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
  }
  
  private void bbE()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new sit(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
  }
  
  private void byQ()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.s);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(31));
    ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
    ode.c localc = this.jdField_a_of_type_Ode$c;
    localShareActionSheetBuilder.setActionSheetItems(a(new List[] { localArrayList }, localc));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(acfp.m(2131720658));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    a(new sis(this));
  }
  
  private void byR()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.byO();
    this.mThreadHandler.post(new SubscribeQRCodeShareHelper.6(this));
  }
  
  private void byS()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.byO();
    this.mThreadHandler.post(new SubscribeQRCodeShareHelper.7(this));
  }
  
  private String gD(String paramString)
  {
    boolean bool = acbn.oM.equals(paramString);
    aqhq.UD(paramString + ".nomedia");
    if ((this.c != null) && (this.c.mExtraTypeInfo != null) && (this.c.a() != null))
    {
      switch (this.c.mExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        localStringBuilder = new StringBuilder().append(paramString).append(((CertifiedAccountMeta.StFeed)this.c.a().get()).id.get());
        if (bool) {}
        for (paramString = Long.valueOf(System.currentTimeMillis());; paramString = "") {
          return paramString + ".png";
        }
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(Md5Utils.getMD5(this.c.a().poster.id.get()));
      if (bool) {}
      for (paramString = Long.valueOf(System.currentTimeMillis());; paramString = "") {
        return paramString + ".png";
      }
    }
    return "";
  }
  
  /* Error */
  private String getFileUri(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 131	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 137	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_1
    //   21: ldc_w 415
    //   24: aload_3
    //   25: invokestatic 421	android/support/v4/content/FileProvider:getUriForFile	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   28: astore_3
    //   29: aload_1
    //   30: ldc_w 423
    //   33: aload_3
    //   34: iconst_1
    //   35: invokevirtual 429	android/content/Context:grantUriPermission	(Ljava/lang/String;Landroid/net/Uri;I)V
    //   38: aload_3
    //   39: ifnull -21 -> 18
    //   42: aload_3
    //   43: invokevirtual 432	android/net/Uri:toString	()Ljava/lang/String;
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_3
    //   50: ldc 139
    //   52: aload_1
    //   53: invokevirtual 435	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   56: invokestatic 441	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 444	java/lang/Exception:printStackTrace	()V
    //   63: goto -25 -> 38
    //   66: astore_1
    //   67: goto -17 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	sio
    //   0	70	1	paramContext	android.content.Context
    //   0	70	2	paramString	String
    //   8	42	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	47	java/lang/Exception
    //   29	38	66	java/lang/Exception
  }
  
  private String nA()
  {
    if (TextUtils.isEmpty(this.c.nv())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(siu.a(this.c.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.c.nv();
  }
  
  private String ny()
  {
    if ((this.c != null) && (this.c.mExtraTypeInfo != null))
    {
      switch (this.c.mExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return nA();
      }
      return nz();
    }
    return "";
  }
  
  private String nz()
  {
    Object localObject2 = "";
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = ryz.a();
    Object localObject1 = localObject2;
    if (localStGetMainPageRsp != null)
    {
      localObject1 = localObject2;
      if (localStGetMainPageRsp.share != null) {
        localObject1 = localStGetMainPageRsp.share.shorturl.get();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject2 = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
      ((StringBuilder)localObject2).append(URLEncoder.encode(siu.r(this.c.mFeed.poster.id.get(), this.c.mFeed.poster.nick.get(), this.c.mFeed.poster.icon.get()), "UTF-8"));
      localObject2 = ((StringBuilder)localObject2).toString();
      return localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return localObject1;
  }
  
  private void saveCard()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = aczy.bd(this.s);
    }
    if (!bool)
    {
      aqha.b(this.s);
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.byO();
    this.mThreadHandler.post(new SubscribeQRCodeShareHelper.5(this));
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if (this.s != null)
    {
      if (!paramBoolean) {
        break label64;
      }
      if (this.jdField_a_of_type_Sil == null) {
        this.jdField_a_of_type_Sil = new sil(this.s, "卡片生成中...");
      }
      if ((!this.jdField_a_of_type_Sil.isShowing()) && (!this.s.isFinishing())) {
        this.jdField_a_of_type_Sil.show();
      }
    }
    label64:
    while ((this.jdField_a_of_type_Sil == null) || (!this.jdField_a_of_type_Sil.isShowing()) || (this.s.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_Sil.dismiss();
  }
  
  private void yw(int paramInt)
  {
    if (MO())
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.byO();
      this.mThreadHandler.post(new SubscribeQRCodeShareHelper.8(this, paramInt));
    }
  }
  
  public void b(san paramsan)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = aczy.bd(this.s);; bool = true)
    {
      if (!bool)
      {
        aqha.b(this.s);
        return;
      }
      if ((paramsan == null) || (!aqiw.isNetworkAvailable(this.s)))
      {
        QQToast.a(this.s, 1, 2131717438, 1).show();
        QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        return;
      }
      this.c = paramsan;
      showLoading(true);
      this.mThreadHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
  }
  
  public void release()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
    this.mThreadHandler.post(new SubscribeQRCodeShareHelper.10(this));
    showLoading(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sio
 * JD-Core Version:    0.7.0.1
 */