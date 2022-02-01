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

public class vpv
  extends vqe
{
  public static GdtAppReceiver a;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  private uyw<vpj> jdField_a_of_type_Uyw;
  private vpj jdField_a_of_type_Vpj;
  private uyw<vpj> b;
  private uyw<vpj> c;
  
  public vpv(Context paramContext, vrn paramvrn)
  {
    super(paramContext, paramvrn);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381084);
    this.jdField_a_of_type_Uyw = new vpq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uyw.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381073);
    this.b = new vpm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381086);
    this.c = new vps(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vpw(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vpx(this));
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Vpj == null) || (this.jdField_a_of_type_Vpj.a() == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Vrn == null) || (this.jdField_a_of_type_Vrn.a == null) || (this.jdField_a_of_type_Vpj.a() == null)) {
      return;
    }
    GdtAd localGdtAd = new GdtAd(vpk.a((stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a()));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new vpz(this);
    }
    AdExposureChecker.onClick(this.jdField_a_of_type_AndroidViewView.getContext(), localGdtAd, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    vpk.a(this.jdField_a_of_type_AndroidViewView.getContext(), (stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a(), jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, this.jdField_a_of_type_Vrn.a, false);
    this.jdField_a_of_type_Vpj.a().isGdtAdclicked = true;
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Uyw != null) {
      this.jdField_a_of_type_Uyw.d();
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
    if (this.jdField_a_of_type_Uyw != null) {
      this.jdField_a_of_type_Uyw.b(paramInt);
    }
    if (this.b != null) {
      this.b.b(paramInt);
    }
    if (this.c != null) {
      this.c.b(paramInt);
    }
  }
  
  public void a(vpj paramvpj)
  {
    super.a(paramvpj);
    this.jdField_a_of_type_Vpj = paramvpj;
    if (this.jdField_a_of_type_Uyw != null) {
      this.jdField_a_of_type_Uyw.a(paramvpj);
    }
    if (this.b != null) {
      this.b.a(paramvpj);
    }
    if (this.c != null) {
      this.c.a(paramvpj);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a();
      vem.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
    if ((this.jdField_a_of_type_Vpj instanceof vpj))
    {
      Object localObject = this.jdField_a_of_type_Vpj.a();
      if ((localObject instanceof stSimpleMetaFeed))
      {
        localObject = (stSimpleMetaFeed)localObject;
        if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
        {
          localAdExposureChecker = new AdExposureChecker(new GdtAd(vpk.a((stSimpleMetaFeed)localObject)), new WeakReference(this.jdField_a_of_type_AndroidViewView));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new vpy(this);
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
    vln localvln = new vln();
    localvln.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localvln.jdField_a_of_type_Int = 2;
    localvln.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localvln.jdField_a_of_type_JavaLangString = vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localvln.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localvln.c = "more_operations";
    localvln.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    vms.a(this.jdField_a_of_type_AndroidContentContext, localvln);
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
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */