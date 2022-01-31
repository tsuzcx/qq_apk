import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.4;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.9;
import com.tencent.biz.subscribe.widget.SubscribeSharedCardView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class wfw
  extends rug
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bbsh jdField_a_of_type_Bbsh;
  private SubscribeSharedCardView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeSharedCardView;
  private final String jdField_a_of_type_JavaLangString = "SubscribeQRCodeShareHelper";
  private vxn jdField_a_of_type_Vxn;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private final String jdField_b_of_type_JavaLangString = ajed.aU + "subscribe_card/";
  private String c;
  
  public wfw(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
    if (this.jdField_a_of_type_Rul == null) {
      this.jdField_a_of_type_Rul = new rul();
    }
    paramActivity = ThreadManager.newFreeHandlerThread("subscribe_create_card", 0);
    paramActivity.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramActivity.getLooper());
    bace.c(this.jdField_b_of_type_JavaLangString + ".nomedia");
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Vxn != null) {
      return this.jdField_a_of_type_Vxn.h();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.7(this, paramInt));
    }
  }
  
  private void a(SubscribeSharedCardView paramSubscribeSharedCardView)
  {
    if (this.jdField_a_of_type_Bahv == null) {
      e();
    }
    this.jdField_a_of_type_Bahv.a();
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.2(this, paramSubscribeSharedCardView));
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_Vxn != null) && (this.jdField_a_of_type_Vxn.a() != null))
    {
      String str = this.jdField_b_of_type_JavaLangString + ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_Vxn.a().get()).id.get() + ".png";
      QLog.d("SubscribeQRCodeShareHelper", 4, "save path :" + str);
      return str;
    }
    return null;
  }
  
  private boolean b()
  {
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131655008;
    }
    for (;;)
    {
      if (i != -1)
      {
        vvp.a(0, i);
        return false;
        if (!WXShareHelper.a().b()) {
          i = 2131655009;
        }
      }
      else
      {
        return true;
      }
      i = -1;
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeSharedCardView != null)
    {
      String str = b();
      if (!TextUtils.isEmpty(str))
      {
        if (new File(str).exists())
        {
          QLog.d("SubscribeQRCodeShareHelper", 4, "save file  is exit");
          return true;
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeSharedCardView.a();
        if (localBitmap != null) {
          return arnj.a(localBitmap, str, Bitmap.CompressFormat.JPEG, 80, true);
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bahv = new bahv(this.jdField_b_of_type_AndroidAppActivity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(31));
    bahv localbahv = this.jdField_a_of_type_Bahv;
    rul localrul = this.jdField_a_of_type_Rul;
    localbahv.a(a(new List[] { localArrayList }, localrul));
    this.jdField_a_of_type_Bahv.a(this);
    a(new wfx(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.4(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.5(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.6(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bbsh != null) {
      return;
    }
    this.jdField_a_of_type_Bbsh = new wfy(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
  }
  
  public void a(vxn paramvxn)
  {
    if ((paramvxn == null) || (!badq.g(this.jdField_b_of_type_AndroidAppActivity)))
    {
      bbmy.a(this.jdField_b_of_type_AndroidAppActivity, 1, 2131651653, 1).a();
      QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code because shareInfoBean is empty");
      return;
    }
    this.jdField_a_of_type_Vxn = paramvxn;
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.1(this));
  }
  
  public void d()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscribeQRCodeShareHelper.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfw
 * JD-Core Version:    0.7.0.1
 */