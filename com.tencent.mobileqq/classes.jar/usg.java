import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class usg
  extends usp
{
  public static GdtAppReceiver a;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  private ueh<uru> jdField_a_of_type_Ueh;
  private uru jdField_a_of_type_Uru;
  private ueh<uru> b;
  private ueh<uru> c;
  
  public usg(Context paramContext, utw paramutw)
  {
    super(paramContext, paramutw);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380829);
    this.jdField_a_of_type_Ueh = new usb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ueh.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380818);
    this.b = new urx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380831);
    this.c = new usd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.c.a(localViewStub);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new ush(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new usi(this));
  }
  
  private void i()
  {
    if (urv.b((stSimpleMetaFeed)this.jdField_a_of_type_Uru.a()))
    {
      GdtAd localGdtAd = new GdtAd(urv.a((stSimpleMetaFeed)this.jdField_a_of_type_Uru.a()));
      if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
        this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new usk(this);
      }
      AdExposureChecker.onClick(this.jdField_a_of_type_AndroidViewView.getContext(), localGdtAd, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    }
    urv.a(this.jdField_a_of_type_AndroidViewView.getContext(), (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a(), jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, this.jdField_a_of_type_Utw.a);
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Ueh != null) {
      this.jdField_a_of_type_Ueh.d();
    }
    if (this.b != null) {
      this.b.d();
    }
    if (this.c != null) {
      this.c.d();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ueh != null) {
      this.jdField_a_of_type_Ueh.a(paramInt);
    }
    if (this.b != null) {
      this.b.a(paramInt);
    }
    if (this.c != null) {
      this.c.a(paramInt);
    }
  }
  
  public void a(uru paramuru)
  {
    super.a(paramuru);
    this.jdField_a_of_type_Uru = paramuru;
    if (this.jdField_a_of_type_Ueh != null) {
      this.jdField_a_of_type_Ueh.a(paramuru);
    }
    if (this.b != null) {
      this.b.a(paramuru);
    }
    if (this.c != null) {
      this.c.a(paramuru);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a();
      uiw.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
    if ((this.jdField_a_of_type_Uru instanceof uru))
    {
      Object localObject = this.jdField_a_of_type_Uru.a();
      if ((localObject instanceof stSimpleMetaFeed))
      {
        localObject = (stSimpleMetaFeed)localObject;
        if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (urv.b((stSimpleMetaFeed)localObject)))
        {
          localAdExposureChecker = new AdExposureChecker(new GdtAd(urv.a((stSimpleMetaFeed)localObject)), new WeakReference(this.jdField_a_of_type_AndroidViewView));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new usj(this);
          }
          localAdExposureChecker.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
          QZLog.w("AdExposureChecker", "startonExposure");
          this.jdField_a_of_type_JavaUtilArrayList.add(localAdExposureChecker);
        }
      }
    }
    for (;;)
    {
      localAdExposureChecker.startCheck();
      return;
    }
  }
  
  public void c()
  {
    uoc localuoc = new uoc();
    localuoc.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localuoc.jdField_a_of_type_Int = 2;
    localuoc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localuoc.jdField_a_of_type_JavaLangString = uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localuoc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localuoc.c = "more_operations";
    localuoc.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uph.a(this.jdField_a_of_type_AndroidContentContext, localuoc);
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    e();
    g();
    f();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usg
 * JD-Core Version:    0.7.0.1
 */