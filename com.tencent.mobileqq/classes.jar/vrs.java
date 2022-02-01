import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vrs
  extends vqe
{
  private int jdField_a_of_type_Int;
  private uyw<vpj> jdField_a_of_type_Uyw;
  private vpj jdField_a_of_type_Vpj;
  private uyw<vpj> b;
  
  public vrs(Context paramContext, vrn paramvrn)
  {
    super(paramContext, paramvrn);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381084);
    this.jdField_a_of_type_Uyw = new vrb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uyw.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381076);
    this.b = new vqx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vrt(this));
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
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c()
  {
    vln localvln = new vln();
    localvln.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localvln.jdField_a_of_type_Int = 3;
    localvln.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localvln.jdField_a_of_type_JavaLangString = vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localvln.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localvln.c = "more_operations";
    localvln.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    vms.b(this.jdField_a_of_type_AndroidContentContext, localvln);
    vsj.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
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
 * Qualified Name:     vrs
 * JD-Core Version:    0.7.0.1
 */