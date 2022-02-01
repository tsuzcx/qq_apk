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

public class vbc
  extends vbl
{
  public static GdtAppReceiver a;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  private ukz<vaq> jdField_a_of_type_Ukz;
  private vaq jdField_a_of_type_Vaq;
  private ukz<vaq> b;
  private ukz<vaq> c;
  
  public vbc(Context paramContext, vct paramvct)
  {
    super(paramContext, paramvct);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380733);
    this.jdField_a_of_type_Ukz = new vax(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ukz.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380721);
    this.b = new vat(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380735);
    this.c = new vaz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vbd(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vbe(this));
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Vaq == null) || (this.jdField_a_of_type_Vaq.a() == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Vct == null) || (this.jdField_a_of_type_Vct.a == null) || (this.jdField_a_of_type_Vaq.a() == null)) {
      return;
    }
    GdtAd localGdtAd = new GdtAd(var.a((stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a()));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new vbg(this);
    }
    AdExposureChecker.onClick(this.jdField_a_of_type_AndroidViewView.getContext(), localGdtAd, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    var.a(this.jdField_a_of_type_AndroidViewView.getContext(), (stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a(), jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, this.jdField_a_of_type_Vct.a);
    this.jdField_a_of_type_Vaq.a().isGdtAdclicked = true;
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.d();
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
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.b(paramInt);
    }
    if (this.b != null) {
      this.b.b(paramInt);
    }
    if (this.c != null) {
      this.c.b(paramInt);
    }
  }
  
  public void a(vaq paramvaq)
  {
    super.a(paramvaq);
    this.jdField_a_of_type_Vaq = paramvaq;
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.a(paramvaq);
    }
    if (this.b != null) {
      this.b.a(paramvaq);
    }
    if (this.c != null) {
      this.c.a(paramvaq);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a();
      uql.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
    if ((this.jdField_a_of_type_Vaq instanceof vaq))
    {
      Object localObject = this.jdField_a_of_type_Vaq.a();
      if ((localObject instanceof stSimpleMetaFeed))
      {
        localObject = (stSimpleMetaFeed)localObject;
        if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null))
        {
          localAdExposureChecker = new AdExposureChecker(new GdtAd(var.a((stSimpleMetaFeed)localObject)), new WeakReference(this.jdField_a_of_type_AndroidViewView));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new vbf(this);
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
    uwy localuwy = new uwy();
    localuwy.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localuwy.jdField_a_of_type_Int = 2;
    localuwy.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localuwy.jdField_a_of_type_JavaLangString = vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localuwy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localuwy.c = "more_operations";
    localuwy.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uyd.a(this.jdField_a_of_type_AndroidContentContext, localuwy);
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
 * Qualified Name:     vbc
 * JD-Core Version:    0.7.0.1
 */