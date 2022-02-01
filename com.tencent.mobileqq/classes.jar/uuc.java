import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uuc
  extends usp
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ueh<uru> jdField_a_of_type_Ueh;
  private uru jdField_a_of_type_Uru;
  private ueh<uru> b;
  private ueh<uru> c;
  
  public uuc(Context paramContext, utw paramutw)
  {
    super(paramContext, paramutw);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed)) && ((this.jdField_a_of_type_Ueh instanceof utf))) {
      ((utf)this.jdField_a_of_type_Ueh).a(paramMotionEvent);
    }
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380818);
    utd localutd = new utd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    localutd.a(localViewStub);
    a(localutd);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380820);
    uta localuta = new uta(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    localuta.a(localViewStub);
    a(localuta);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380831);
    utr localutr = new utr(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    localutr.a(localViewStub);
    a(localutr);
  }
  
  private void i()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380827);
    this.jdField_a_of_type_Ueh = new utj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.jdField_a_of_type_Ueh.a(localViewStub);
    a(this.jdField_a_of_type_Ueh);
  }
  
  private void j()
  {
    if (!a()) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380816);
    this.b = new usu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.b.a(localViewStub);
    a(this.b);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "vertical_layer_collection")))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380817);
      this.c = new usx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
      this.c.a(localViewStub);
      a(this.c);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new uud(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new uue(this));
  }
  
  private void m()
  {
    if ((a() != null) && (a().poster != null) && (!uov.a(a().poster.followStatus))) {
      ((usu)this.b).b();
    }
  }
  
  private void n()
  {
    if ((a() instanceof utm)) {
      ((utm)a()).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(uru paramuru)
  {
    super.a(paramuru);
    this.jdField_a_of_type_Uru = paramuru;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a();
      uiw.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.e(paramInt + 1);
    }
  }
  
  public void b(uru paramuru)
  {
    this.jdField_a_of_type_Uru = paramuru;
    c(paramuru);
  }
  
  public ueh<uru> c()
  {
    return this.c;
  }
  
  public void c()
  {
    uoc localuoc = new uoc();
    localuoc.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    localuoc.jdField_a_of_type_Int = 2;
    localuoc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localuoc.jdField_a_of_type_JavaLangString = uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    localuoc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    localuoc.c = "more_operations";
    localuoc.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uph.a(this.jdField_a_of_type_AndroidContentContext, localuoc);
    uut.d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 0) && ((this.jdField_a_of_type_Ueh instanceof utf))) {
      ((utf)this.jdField_a_of_type_Ueh).f();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.b instanceof usu)))
      {
        m();
        return;
      }
    } while ((paramInt != 2) || (!(this.jdField_a_of_type_Ueh instanceof utf)));
    ((utf)this.jdField_a_of_type_Ueh).g();
  }
  
  public void d()
  {
    super.d();
    f();
    g();
    i();
    h();
    j();
    e();
    k();
    l();
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380819);
    ute localute = new ute(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    localute.a(localViewStub);
    a(localute);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuc
 * JD-Core Version:    0.7.0.1
 */