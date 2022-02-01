import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vcx
  extends vbl
{
  private int jdField_a_of_type_Int;
  private ukz<vaq> jdField_a_of_type_Ukz;
  private vaq jdField_a_of_type_Vaq;
  private ukz<vaq> b;
  
  public vcx(Context paramContext, vct paramvct)
  {
    super(paramContext, paramvct);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380733);
    this.jdField_a_of_type_Ukz = new vch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ukz.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380724);
    this.b = new vcd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vcy(this));
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
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c()
  {
    uwy localuwy = new uwy();
    localuwy.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localuwy.jdField_a_of_type_Int = 3;
    localuwy.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localuwy.jdField_a_of_type_JavaLangString = vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localuwy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localuwy.c = "more_operations";
    localuwy.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uyd.b(this.jdField_a_of_type_AndroidContentContext, localuwy);
    vdq.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
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
 * Qualified Name:     vcx
 * JD-Core Version:    0.7.0.1
 */