import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class utx
  extends usp
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ueh<uru> jdField_a_of_type_Ueh;
  private uru jdField_a_of_type_Uru;
  private ueh<uru> b;
  
  public utx(Context paramContext, utw paramutw)
  {
    super(paramContext, paramutw);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed)) && ((this.b instanceof utf))) {
      ((utf)this.b).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380829);
    this.jdField_a_of_type_Ueh = new utk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Ueh.a(localViewStub);
    a(this.jdField_a_of_type_Ueh);
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
    this.b = new utf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.b.a(localViewStub);
    a(this.b);
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new uty(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new utz(this));
  }
  
  private void j()
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
  
  public void b()
  {
    if ((this.jdField_a_of_type_Uru != null) && ((this.jdField_a_of_type_Uru.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Uru.a();
      uiw.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(uru paramuru)
  {
    this.jdField_a_of_type_Uru = paramuru;
    c(paramuru);
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
        } while (!(this.b instanceof utf));
        ((utf)this.b).f();
        return;
      } while (!(this.jdField_a_of_type_Ueh instanceof utk));
      ((utk)this.jdField_a_of_type_Ueh).b();
      return;
    } while (!(this.b instanceof utf));
    ((utf)this.b).g();
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
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */