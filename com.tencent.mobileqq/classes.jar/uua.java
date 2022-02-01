import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uua
  extends usp
{
  private int jdField_a_of_type_Int;
  private ueh<uru> jdField_a_of_type_Ueh;
  private uru jdField_a_of_type_Uru;
  private ueh<uru> b;
  
  public uua(Context paramContext, utw paramutw)
  {
    super(paramContext, paramutw);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380829);
    this.jdField_a_of_type_Ueh = new utk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ueh.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380821);
    this.b = new uth(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new uub(this));
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
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c()
  {
    uoc localuoc = new uoc();
    localuoc.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localuoc.jdField_a_of_type_Int = 3;
    localuoc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localuoc.jdField_a_of_type_JavaLangString = uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localuoc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localuoc.c = "more_operations";
    localuoc.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uph.b(this.jdField_a_of_type_AndroidContentContext, localuoc);
    uut.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt) {}
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "aio_home_page"))) {
      e();
    }
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uua
 * JD-Core Version:    0.7.0.1
 */