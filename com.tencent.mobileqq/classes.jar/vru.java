import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vru
  extends vqe
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private uyw<vpj> jdField_a_of_type_Uyw;
  private vpj jdField_a_of_type_Vpj;
  private uyw<vpj> b;
  private uyw<vpj> c;
  
  public vru(Context paramContext, vrn paramvrn)
  {
    super(paramContext, paramvrn);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Vpj != null) && ((this.jdField_a_of_type_Vpj.a() instanceof stSimpleMetaFeed)) && ((this.jdField_a_of_type_Uyw instanceof vqv))) {
      ((vqv)this.jdField_a_of_type_Uyw).a(paramMotionEvent);
    }
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
    vqq localvqq = new vqq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    localvqq.a(localViewStub);
    a(localvqq);
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
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381083);
    vra localvra = new vra(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    localvra.a(localViewStub);
    a(localvra);
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381081);
    this.jdField_a_of_type_Uyw = new vqz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.jdField_a_of_type_Uyw.a(localViewStub);
    a(this.jdField_a_of_type_Uyw);
  }
  
  private void k()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381071);
    this.b = new vqj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection")))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381072);
      this.c = new vqn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
      this.c.a(localViewStub);
      a(this.c);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vrv(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vrw(this));
  }
  
  private void n()
  {
    if ((a() != null) && (a().poster != null) && (!vmg.a(a().poster.followStatus))) {
      ((vqj)this.b).b();
    }
  }
  
  private void o()
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.d(paramInt + 1);
    }
  }
  
  public void b(vpj paramvpj)
  {
    this.jdField_a_of_type_Vpj = paramvpj;
    c(paramvpj);
  }
  
  public uyw<vpj> c()
  {
    return this.c;
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
    if ((paramInt == 0) && ((this.jdField_a_of_type_Uyw instanceof vqv))) {
      ((vqv)this.jdField_a_of_type_Uyw).f();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.b instanceof vqj)))
      {
        n();
        return;
      }
    } while ((paramInt != 2) || (!(this.jdField_a_of_type_Uyw instanceof vqv)));
    ((vqv)this.jdField_a_of_type_Uyw).g();
  }
  
  public void d()
  {
    super.d();
    f();
    g();
    j();
    h();
    i();
    k();
    e();
    l();
    m();
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381074);
    vqu localvqu = new vqu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    localvqu.a(localViewStub);
    a(localvqu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vru
 * JD-Core Version:    0.7.0.1
 */