import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vrp
  extends vqe
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private uyw<vpj> jdField_a_of_type_Uyw;
  private vpj jdField_a_of_type_Vpj;
  private uyw<vpj> b;
  
  public vrp(Context paramContext, vrn paramvrn)
  {
    super(paramContext, paramvrn);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed)) && ((this.b instanceof vqv))) {
      ((vqv)this.b).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381084);
    this.jdField_a_of_type_Uyw = new vrb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uyw.a(localViewStub);
    a(this.jdField_a_of_type_Uyw);
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381073);
    vqt localvqt = new vqt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    localvqt.a(localViewStub);
    a(localvqt);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381075);
    this.b = new vqv(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381086);
    vri localvri = new vri(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    localvri.a(localViewStub);
    a(localvri);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vrq(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vrr(this));
  }
  
  private void j()
  {
    if ((a() instanceof vrd)) {
      ((vrd)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(vpj paramvpj)
  {
    super.a(paramvpj);
    this.jdField_a_of_type_Vpj = paramvpj;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Vpj.a();
      vem.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(vpj paramvpj)
  {
    this.jdField_a_of_type_Vpj = paramvpj;
    c(paramvpj);
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
    vsj.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
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
        } while (!(this.b instanceof vqv));
        ((vqv)this.b).f();
        return;
      } while (!(this.jdField_a_of_type_Uyw instanceof vrb));
      ((vrb)this.jdField_a_of_type_Uyw).b();
      return;
    } while (!(this.b instanceof vqv));
    ((vqv)this.b).g();
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
 * Qualified Name:     vrp
 * JD-Core Version:    0.7.0.1
 */