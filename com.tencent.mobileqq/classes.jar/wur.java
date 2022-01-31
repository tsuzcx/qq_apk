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

public class wur
  extends sgv
{
  public static final String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bcww jdField_a_of_type_Bcww;
  private AbsSubscribeShareCardView jdField_a_of_type_ComTencentBizSubscribeWidgetAbsSubscribeShareCardView;
  private wkm jdField_a_of_type_Wkm;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private final String jdField_b_of_type_JavaLangString = "https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=";
  private final String c = ajsd.aW + "subscribe_card/";
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.aW + "subscribe_shared_card/";
  }
  
  public wur(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Sha == null) {
      this.jdField_a_of_type_Sha = new sha();
    }
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  private AbsSubscribeShareCardView a()
  {
    if ((this.jdField_a_of_type_Wkm != null) && (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      switch (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      }
    }
    do
    {
      return null;
      return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_Wkm.jdField_a_of_type_Int == 1) {
        return new SubScribePersonalSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
      if (this.jdField_a_of_type_Wkm.jdField_a_of_type_Int == 3) {
        return new SubscribeVideoSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
      }
    } while (this.jdField_a_of_type_Wkm.jdField_a_of_type_Int != 4);
    return new SubscribeMultiPicSharedCardView(this.jdField_b_of_type_AndroidAppActivity);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Wkm != null) && (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      switch (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
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
    bbdx.c(paramString + ".nomedia");
    if ((this.jdField_a_of_type_Wkm != null) && (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_Wkm.a() != null))
    {
      switch (this.jdField_a_of_type_Wkm.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      case 7003: 
      case 7004: 
      default: 
        return "";
      case 7000: 
      case 7001: 
        return paramString + ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_Wkm.a().get()).id.get() + ".png";
      }
      return paramString + Md5Utils.getMD5(this.jdField_a_of_type_Wkm.a().poster.id.get()) + ".png";
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
    if (this.jdField_a_of_type_Bbjq == null) {
      e();
    }
    if (this.jdField_a_of_type_Bbjq.a()) {
      return;
    }
    this.jdField_a_of_type_Bbjq.a();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.3(this, paramAbsSubscribeShareCardView));
  }
  
  private String b()
  {
    Object localObject2 = "";
    CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = win.a();
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
      ((StringBuilder)localObject2).append(URLEncoder.encode(wux.a(this.jdField_a_of_type_Wkm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Wkm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_Wkm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()), "UTF-8"));
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
      i = 2131720917;
    }
    for (;;)
    {
      if (i != -1)
      {
        wij.a(0, i);
        return false;
        if (!WXShareHelper.a().b()) {
          i = 2131720918;
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
    if (TextUtils.isEmpty(this.jdField_a_of_type_Wkm.h())) {
      try
      {
        Object localObject = new StringBuilder("https://h5.qzone.qq.com/subscription/jump?_wv=3&_proxy=1&schema=");
        ((StringBuilder)localObject).append(URLEncoder.encode(wux.a(this.jdField_a_of_type_Wkm.a()), "UTF-8"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return "";
      }
    }
    return this.jdField_a_of_type_Wkm.h();
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
          return asjo.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_b_of_type_AndroidAppActivity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(31));
    bbjq localbbjq = this.jdField_a_of_type_Bbjq;
    sha localsha = this.jdField_a_of_type_Sha;
    localbbjq.a(a(new List[] { localArrayList }, localsha));
    this.jdField_a_of_type_Bbjq.a(ajya.a(2131719964));
    this.jdField_a_of_type_Bbjq.a(this);
    a(new wuv(this));
  }
  
  private void f()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = akwf.a(this.jdField_b_of_type_AndroidAppActivity);
    }
    if (!bool)
    {
      bbdj.b(this.jdField_b_of_type_AndroidAppActivity);
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
    if (this.jdField_a_of_type_Bcww != null) {
      return;
    }
    this.jdField_a_of_type_Bcww = new wuw(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bcww);
  }
  
  public void a(wkm paramwkm)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = akwf.a(this.jdField_b_of_type_AndroidAppActivity);; bool = true)
    {
      if (!bool)
      {
        bbdj.b(this.jdField_b_of_type_AndroidAppActivity);
        return;
      }
      if ((paramwkm == null) || (!bbfj.g(this.jdField_b_of_type_AndroidAppActivity)))
      {
        bcql.a(this.jdField_b_of_type_AndroidAppActivity, 1, 2131717456, 1).a();
        QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
        return;
      }
      this.jdField_a_of_type_Wkm = paramwkm;
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.2(this));
      return;
    }
  }
  
  public void d()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bcww);
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.10(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wur
 * JD-Core Version:    0.7.0.1
 */