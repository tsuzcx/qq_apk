import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uuz
  extends utq
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private uej<usv> jdField_a_of_type_Uej;
  private usv jdField_a_of_type_Usv;
  private uej<usv> b;
  
  public uuz(Context paramContext, uuy paramuuy)
  {
    super(paramContext, paramuuy);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed)) && ((this.b instanceof uug))) {
      ((uug)this.b).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381007);
    this.jdField_a_of_type_Uej = new uum(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Uej.a(localViewStub);
    a(this.jdField_a_of_type_Uej);
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
    this.b = new uug(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.b.a(localViewStub);
    a(this.b);
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new uva(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new uvb(this));
  }
  
  private void j()
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
  
  public void b()
  {
    if ((this.jdField_a_of_type_Usv != null) && ((this.jdField_a_of_type_Usv.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Usv.a();
      ujq.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(usv paramusv)
  {
    this.jdField_a_of_type_Usv = paramusv;
    c(paramusv);
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
        } while (!(this.b instanceof uug));
        ((uug)this.b).f();
        return;
      } while (!(this.jdField_a_of_type_Uej instanceof uum));
      ((uum)this.jdField_a_of_type_Uej).b();
      return;
    } while (!(this.b instanceof uug));
    ((uug)this.b).g();
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
 * Qualified Name:     uuz
 * JD-Core Version:    0.7.0.1
 */