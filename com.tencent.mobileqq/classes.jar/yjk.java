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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class yjk
  extends syq
{
  public static final String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bevy jdField_a_of_type_Bevy;
  private AbsSubscribeShareCardView jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView;
  private xzf jdField_a_of_type_Xzf;
  private yjh jdField_a_of_type_Yjh;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private final String jdField_b_of_type_JavaLangString = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c = aljq.aX + "subscribe_card/";
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = aljq.aX + "subscribe_shared_card/";
  }
  
  public yjk(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Syv == null) {
      this.jdField_a_of_type_Syv = new syv();
    }
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private AbsSubscribeShareCardView a()
  {
    if ((this.jdField_a_of_type_Xzf != null) && (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      switch (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      }
    }
    do
    {
      return null;
      return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_Xzf.jdField_a_of_type_Int == 1) {
        return new SubScribePersonalSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_Xzf.jdField_a_of_type_Int == 3) {
        return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
    } while (this.jdField_a_of_type_Xzf.jdField_a_of_type_Int != 4);
    return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Xzf != null) && (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      switch (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return c();
      }
      return b();
    }
    return "";
  }
  
  /* Error */
  private String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 136	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 143	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_2
    //   19: areturn
    //   20: aload_1
    //   21: ldc 145
    //   23: aload_3
    //   24: invokestatic 151	com/tencent/smtt/utils/FileProvider:getUriForFile	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   27: astore_3
    //   28: aload_1
    //   29: ldc 153
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 159	android/content/Context:grantUriPermission	(Ljava/lang/String;Landroid/net/Uri;I)V
    //   36: aload_3
    //   37: ifnull -19 -> 18
    //   40: aload_3
    //   41: invokevirtual 162	android/net/Uri:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_3
    //   48: ldc 164
    //   50: aload_1
    //   51: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   54: invokestatic 173	wsv:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   61: goto -25 -> 36
    //   64: astore_1
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	yjk
    //   0	68	1	paramContext	android.content.Context
    //   0	68	2	paramString	String
    //   8	40	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	28	45	java/lang/Exception
    //   28	36	64	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    bdcs.c(paramString + ".nomedia");
    if ((this.jdField_a_of_type_Xzf != null) && (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_Xzf.a() != null))
    {
      switch (this.jdField_a_of_type_Xzf.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return paramString + ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_Xzf.a().get()).id.get() + ".png";
      }
      return paramString + Md5Utils.getMD5(this.jdField_a_of_type_Xzf.a().poster.id.get()) + ".png";
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.8(this, paramInt));
    }
  }
  
  private void a(AbsSubscribeShareCardView paramAbsSubscribeShareCardView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidAppActivity != null)
    {
      if (!paramBoolean) {
        break label64;
      }
      if (this.jdField_a_of_type_Yjh == null) {
        this.jdField_a_of_type_Yjh = new yjh(this.jdField_b_of_type_AndroidAppActivity, "卡片生成中...");
      }
      if ((!this.jdField_a_of_type_Yjh.isShowing()) && (!this.jdField_b_of_type_AndroidAppActivity.isFinishing())) {
        this.jdField_a_of_type_Yjh.show();
      }
    }
    label64:
    while ((this.jdField_a_of_type_Yjh == null) || (!this.jdField_a_of_type_Yjh.isShowing()) || (this.jdField_b_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_Yjh.dismiss();
  }
  
  private String b()
  {
    Object localObject2 = "";
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = xxf.a();
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
      ((StringBuilder)localObject2).append(URLEncoder.encode(yjq.a(this.jdField_a_of_type_Xzf.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Xzf.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_Xzf.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()), "UTF-8"));
      localObject2 = ((StringBuilder)localObject2).toString();
      return localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return localObject1;
  }
  
  private boolean b()
  {
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131721478;
    }
    for (;;)
    {
      if (i != -1)
      {
        xxb.a(0, i);
        return false;
        if (!WXShareHelper.a().b()) {
          i = 2131721479;
        }
      }
      else
      {
        return true;
      }
      i = -1;
    }
  }
  
  private String c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_Xzf.h())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(yjq.a(this.jdField_a_of_type_Xzf.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.jdField_a_of_type_Xzf.h();
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView != null)
    {
      String str = a(this.c);
      if (!TextUtils.isEmpty(str))
      {
        if (new File(str).exists())
        {
          QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
          return true;
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
        if (localBitmap != null) {
          return auao.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private boolean d()
  {
    return (WXShareHelper.a().a() != null) && (WXShareHelper.a().a().getWXAppSupportAPI() >= 654314752);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_b_of_type_AndroidAppActivity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(31));
    ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
    syv localsyv = this.jdField_a_of_type_Syv;
    localShareActionSheetBuilder.setActionSheetItems(a(new List[] { localArrayList }, localsyv));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(alpo.a(2131720499));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    a(new yjo(this));
  }
  
  private boolean e()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  private void f()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = ammv.a(this.jdField_b_of_type_AndroidAppActivity);
    }
    if (!bool)
    {
      bdcd.b(this.jdField_b_of_type_AndroidAppActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.5(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.6(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.7(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bevy != null) {
      return;
    }
    this.jdField_a_of_type_Bevy = new yjp(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
  }
  
  public void a(xzf paramxzf)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = ammv.a(this.jdField_b_of_type_AndroidAppActivity);; bool = true)
    {
      if (!bool)
      {
        bdcd.b(this.jdField_b_of_type_AndroidAppActivity);
        return;
      }
      if ((paramxzf == null) || (!bdee.g(this.jdField_b_of_type_AndroidAppActivity)))
      {
        QQToast.a(this.jdField_b_of_type_AndroidAppActivity, 1, 2131717828, 1).a();
        QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        return;
      }
      this.jdField_a_of_type_Xzf = paramxzf;
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
  }
  
  public void d()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bevy);
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.10(this));
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjk
 * JD-Core Version:    0.7.0.1
 */