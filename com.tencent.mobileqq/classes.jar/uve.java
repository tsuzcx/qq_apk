import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uve
  extends utq
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private uej<usv> jdField_a_of_type_Uej;
  private usv jdField_a_of_type_Usv;
  private uej<usv> b;
  private uej<usv> c;
  
  public uve(Context paramContext, uuy paramuuy)
  {
    super(paramContext, paramuuy);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed)) && ((this.jdField_a_of_type_Uej instanceof uug))) {
      ((uug)this.jdField_a_of_type_Uej).a(paramMotionEvent);
    }
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380995);
    uue localuue = new uue(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    localuue.a(localViewStub);
    a(localuue);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380997);
    uub localuub = new uub(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    localuub.a(localViewStub);
    a(localuub);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381009);
    uut localuut = new uut(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    localuut.a(localViewStub);
    a(localuut);
  }
  
  private void i()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381006);
    uul localuul = new uul(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    localuul.a(localViewStub);
    a(localuul);
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381004);
    this.jdField_a_of_type_Uej = new uuk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.jdField_a_of_type_Uej.a(localViewStub);
    a(this.jdField_a_of_type_Uej);
  }
  
  private void k()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380993);
    this.b = new utv(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection")))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380994);
      this.c = new uty(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
      this.c.a(localViewStub);
      a(this.c);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new uvf(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new uvg(this));
  }
  
  private void n()
  {
    if ((a() != null) && (a().poster != null) && (!upw.a(a().poster.followStatus))) {
      ((utv)this.b).b();
    }
  }
  
  private void o()
  {
    if ((a() instanceof uuo)) {
      ((uuo)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Usv.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(usv paramusv)
  {
    super.a(paramusv);
    this.jdField_a_of_type_Usv = paramusv;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.d(paramInt + 1);
    }
  }
  
  public void b(usv paramusv)
  {
    this.jdField_a_of_type_Usv = paramusv;
    c(paramusv);
  }
  
  public uej<usv> c()
  {
    return this.c;
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
    uvv.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 0) && ((this.jdField_a_of_type_Uej instanceof uug))) {
      ((uug)this.jdField_a_of_type_Uej).f();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.b instanceof utv)))
      {
        n();
        return;
      }
    } while ((paramInt != 2) || (!(this.jdField_a_of_type_Uej instanceof uug)));
    ((uug)this.jdField_a_of_type_Uej).g();
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
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380996);
    uuf localuuf = new uuf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    localuuf.a(localViewStub);
    a(localuuf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uve
 * JD-Core Version:    0.7.0.1
 */