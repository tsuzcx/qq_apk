import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uvc
  extends utq
{
  private int jdField_a_of_type_Int;
  private uej<usv> jdField_a_of_type_Uej;
  private usv jdField_a_of_type_Usv;
  private uej<usv> b;
  
  public uvc(Context paramContext, uuy paramuuy)
  {
    super(paramContext, paramuuy);
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381007);
    this.jdField_a_of_type_Uej = new uum(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uej.a(localViewStub);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380998);
    this.b = new uui(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.b.a(localViewStub);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new uvd(this));
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
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void c()
  {
    upd localupd = new upd();
    localupd.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localupd.jdField_a_of_type_Int = 3;
    localupd.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localupd.jdField_a_of_type_JavaLangString = uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localupd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localupd.c = "more_operations";
    localupd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uqi.b(this.jdField_a_of_type_AndroidContentContext, localupd);
    uvv.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
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
 * Qualified Name:     uvc
 * JD-Core Version:    0.7.0.1
 */