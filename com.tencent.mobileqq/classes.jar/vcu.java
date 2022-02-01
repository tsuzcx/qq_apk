import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vcu
  extends vbl
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ukz<vaq> jdField_a_of_type_Ukz;
  private vaq jdField_a_of_type_Vaq;
  private ukz<vaq> b;
  
  public vcu(Context paramContext, vct paramvct)
  {
    super(paramContext, paramvct);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed)) && ((this.b instanceof vcb))) {
      ((vcb)this.b).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380733);
    this.jdField_a_of_type_Ukz = new vch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ukz.a(localViewStub);
    a(this.jdField_a_of_type_Ukz);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380721);
    vbz localvbz = new vbz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    localvbz.a(localViewStub);
    a(localvbz);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380723);
    this.b = new vcb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380735);
    vco localvco = new vco(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    localvco.a(localViewStub);
    a(localvco);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vcv(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vcw(this));
  }
  
  private void j()
  {
    if ((a() instanceof vcj)) {
      ((vcj)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(vaq paramvaq)
  {
    super.a(paramvaq);
    this.jdField_a_of_type_Vaq = paramvaq;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Vaq.a();
      uql.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(vaq paramvaq)
  {
    this.jdField_a_of_type_Vaq = paramvaq;
    c(paramvaq);
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
    vdq.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(this.b instanceof vcb));
        ((vcb)this.b).f();
        return;
      } while (!(this.jdField_a_of_type_Ukz instanceof vch));
      ((vch)this.jdField_a_of_type_Ukz).b();
      return;
    } while (!(this.b instanceof vcb));
    ((vcb)this.b).g();
  }
  
  public void d()
  {
    super.d();
    e();
    f();
    g();
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */