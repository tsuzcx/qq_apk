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

public class uth
  extends utq
{
  public static GdtAppReceiver a;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public AdExposureChecker.ExposureCallback a;
  public ArrayList<AdExposureChecker> a;
  private uej<usv> jdField_a_of_type_Uej;
  private usv jdField_a_of_type_Usv;
  private uej<usv> b;
  private uej<usv> c;
  
  public uth(Context paramContext, uuy paramuuy)
  {
    super(paramContext, paramuuy);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381007);
    this.jdField_a_of_type_Uej = new utc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uej.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380995);
    this.b = new usy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381009);
    this.c = new ute(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new uti(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new utj(this));
  }
  
  private void i()
  {
    if (usw.b((stSimpleMetaFeed)this.jdField_a_of_type_Usv.a()))
    {
      GdtAd localGdtAd = new GdtAd(usw.a((stSimpleMetaFeed)this.jdField_a_of_type_Usv.a()));
      if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
        this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new utl(this);
      }
      AdExposureChecker.onClick(this.jdField_a_of_type_AndroidViewView.getContext(), localGdtAd, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    }
    usw.a(this.jdField_a_of_type_AndroidViewView.getContext(), (stSimpleMetaFeed)this.jdField_a_of_type_Usv.a(), jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, this.jdField_a_of_type_Uuy.a);
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Usv.a();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Uej != null) {
      this.jdField_a_of_type_Uej.d();
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
    if (this.jdField_a_of_type_Uej != null) {
      this.jdField_a_of_type_Uej.b(paramInt);
    }
    if (this.b != null) {
      this.b.b(paramInt);
    }
    if (this.c != null) {
      this.c.b(paramInt);
    }
  }
  
  public void a(usv paramusv)
  {
    super.a(paramusv);
    this.jdField_a_of_type_Usv = paramusv;
    if (this.jdField_a_of_type_Uej != null) {
      this.jdField_a_of_type_Uej.a(paramusv);
    }
    if (this.b != null) {
      this.b.a(paramusv);
    }
    if (this.c != null) {
      this.c.a(paramusv);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Usv.a();
      ujq.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
    if ((this.jdField_a_of_type_Usv instanceof usv))
    {
      Object localObject = this.jdField_a_of_type_Usv.a();
      if ((localObject instanceof stSimpleMetaFeed))
      {
        localObject = (stSimpleMetaFeed)localObject;
        if ((localObject != null) && (((stSimpleMetaFeed)localObject).gdt_ad_type == 1) && (((stSimpleMetaFeed)localObject).gdt_ad_info != null) && (usw.b((stSimpleMetaFeed)localObject)))
        {
          localAdExposureChecker = new AdExposureChecker(new GdtAd(usw.a((stSimpleMetaFeed)localObject)), new WeakReference(this.jdField_a_of_type_AndroidViewView));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new utk(this);
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
    upd localupd = new upd();
    localupd.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localupd.jdField_a_of_type_Int = 2;
    localupd.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localupd.jdField_a_of_type_JavaLangString = uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localupd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localupd.c = "more_operations";
    localupd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uqi.a(this.jdField_a_of_type_AndroidContentContext, localupd);
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
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */