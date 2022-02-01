import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vcz
  extends vbl
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ukz<vaq> jdField_a_of_type_Ukz;
  private vaq jdField_a_of_type_Vaq;
  private ukz<vaq> b;
  private ukz<vaq> c;
  
  public vcz(Context paramContext, vct paramvct)
  {
    super(paramContext, paramvct);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Vaq != null) && ((this.jdField_a_of_type_Vaq.a() instanceof stSimpleMetaFeed)) && ((this.jdField_a_of_type_Ukz instanceof vcb))) {
      ((vcb)this.jdField_a_of_type_Ukz).a(paramMotionEvent);
    }
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
    vbw localvbw = new vbw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    localvbw.a(localViewStub);
    a(localvbw);
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
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380732);
    vcg localvcg = new vcg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    localvcg.a(localViewStub);
    a(localvcg);
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380730);
    this.jdField_a_of_type_Ukz = new vcf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.jdField_a_of_type_Ukz.a(localViewStub);
    a(this.jdField_a_of_type_Ukz);
  }
  
  private void k()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380719);
    this.b = new vbq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection")))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380720);
      this.c = new vbt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
      this.c.a(localViewStub);
      a(this.c);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new vda(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vdb(this));
  }
  
  private void n()
  {
    if ((a() != null) && (a().poster != null) && (!uxr.a(a().poster.followStatus))) {
      ((vbq)this.b).b();
    }
  }
  
  private void o()
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.d(paramInt + 1);
    }
  }
  
  public void b(vaq paramvaq)
  {
    this.jdField_a_of_type_Vaq = paramvaq;
    c(paramvaq);
  }
  
  public ukz<vaq> c()
  {
    return this.c;
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
    if ((paramInt == 0) && ((this.jdField_a_of_type_Ukz instanceof vcb))) {
      ((vcb)this.jdField_a_of_type_Ukz).f();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.b instanceof vbq)))
      {
        n();
        return;
      }
    } while ((paramInt != 2) || (!(this.jdField_a_of_type_Ukz instanceof vcb)));
    ((vcb)this.jdField_a_of_type_Ukz).g();
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
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380722);
    vca localvca = new vca(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    localvca.a(localViewStub);
    a(localvca);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcz
 * JD-Core Version:    0.7.0.1
 */