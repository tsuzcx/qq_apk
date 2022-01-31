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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class wuu
  extends sgy
{
  public static final String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bcwh jdField_a_of_type_Bcwh;
  private AbsSubscribeShareCardView jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView;
  private wkp jdField_a_of_type_Wkp;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private final String jdField_b_of_type_JavaLangString = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c = ajsf.aW + "subscribe_card/";
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsf.aW + "subscribe_shared_card/";
  }
  
  public wuu(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Shd == null) {
      this.jdField_a_of_type_Shd = new shd();
    }
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private AbsSubscribeShareCardView a()
  {
    if ((this.jdField_a_of_type_Wkp != null) && (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      switch (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      }
    }
    do
    {
      return null;
      return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_Wkp.jdField_a_of_type_Int == 1) {
        return new SubScribePersonalSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_Wkp.jdField_a_of_type_Int == 3) {
        return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
    } while (this.jdField_a_of_type_Wkp.jdField_a_of_type_Int != 4);
    return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Wkp != null) && (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      switch (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
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
  
  private String a(String paramString)
  {
    bbdj.c(paramString + ".nomedia");
    if ((this.jdField_a_of_type_Wkp != null) && (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_Wkp.a() != null))
    {
      switch (this.jdField_a_of_type_Wkp.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return paramString + ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_Wkp.a().get()).id.get() + ".png";
      }
      return paramString + Md5Utils.getMD5(this.jdField_a_of_type_Wkp.a().poster.id.get()) + ".png";
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
    if (this.jdField_a_of_type_Bbjc == null) {
      e();
    }
    if (this.jdField_a_of_type_Bbjc.a()) {
      return;
    }
    this.jdField_a_of_type_Bbjc.a();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
  }
  
  private String b()
  {
    Object localObject2 = "";
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = wiq.a();
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
      ((StringBuilder)localObject2).append(URLEncoder.encode(wva.a(this.jdField_a_of_type_Wkp.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Wkp.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_Wkp.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()), "UTF-8"));
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
      i = 2131720906;
    }
    for (;;)
    {
      if (i != -1)
      {
        wim.a(0, i);
        return false;
        if (!WXShareHelper.a().b()) {
          i = 2131720907;
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
    if (TextUtils.isEmpty(this.jdField_a_of_type_Wkp.h())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(wva.a(this.jdField_a_of_type_Wkp.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.jdField_a_of_type_Wkp.h();
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
          return asjm.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bbjc = new bbjc(this.jdField_b_of_type_AndroidAppActivity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(31));
    bbjc localbbjc = this.jdField_a_of_type_Bbjc;
    shd localshd = this.jdField_a_of_type_Shd;
    localbbjc.a(a(new List[] { localArrayList }, localshd));
    this.jdField_a_of_type_Bbjc.a(ajyc.a(2131719953));
    this.jdField_a_of_type_Bbjc.a(this);
    a(new wuy(this));
  }
  
  private void f()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = akwg.a(this.jdField_b_of_type_AndroidAppActivity);
    }
    if (!bool)
    {
      bbcv.b(this.jdField_b_of_type_AndroidAppActivity);
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
    if (this.jdField_a_of_type_Bcwh != null) {
      return;
    }
    this.jdField_a_of_type_Bcwh = new wuz(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bcwh);
  }
  
  public void a(wkp paramwkp)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = akwg.a(this.jdField_b_of_type_AndroidAppActivity);; bool = true)
    {
      if (!bool)
      {
        bbcv.b(this.jdField_b_of_type_AndroidAppActivity);
        return;
      }
      if ((paramwkp == null) || (!bbev.g(this.jdField_b_of_type_AndroidAppActivity)))
      {
        bcpw.a(this.jdField_b_of_type_AndroidAppActivity, 1, 2131717445, 1).a();
        QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        return;
      }
      this.jdField_a_of_type_Wkp = paramwkp;
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
  }
  
  public void d()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bcwh);
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.10(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wuu
 * JD-Core Version:    0.7.0.1
 */