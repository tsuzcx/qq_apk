import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;

public class tnk
  implements tcl<tmv>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  private tck<tmv> jdField_a_of_type_Tck;
  private tmv jdField_a_of_type_Tmv;
  private tnj jdField_a_of_type_Tnj;
  private tck<tmv> b;
  private tck<tmv> c;
  private tck<tmv> d;
  private tck<tmv> e;
  private tck<tmv> f;
  
  public tnk(Context paramContext, tnj paramtnj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Tnj = paramtnj;
    if (paramtnj != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramtnj.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramtnj.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Tmv != null) && ((this.jdField_a_of_type_Tmv.a() instanceof stSimpleMetaFeed)) && ((this.e instanceof tmy))) {
      ((tmy)this.e).a(paramMotionEvent);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379805));
  }
  
  private void f()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379812);
    this.jdField_a_of_type_Tck = new tna(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_Tck.a(localViewStub);
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379803);
    this.d = new tmx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tnj);
    this.d.a(localViewStub);
  }
  
  private void h()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379804);
    this.e = new tmy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tnj);
    tlo.a("comment", "WSVerticalVideoItemView initVerticalItemBottomOperationController--------------------------！");
    this.e.a(localViewStub);
  }
  
  private void i()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379813);
    this.b = new tnc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.b.a(localViewStub);
  }
  
  private void j()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379808);
    this.c = new tne(this.jdField_a_of_type_AndroidContentContext, this);
    this.c.a(localViewStub);
  }
  
  private void k()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131379814);
    this.f = new tnh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tnj);
    this.f.a(localViewStub);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewView.getContext(), new tnl(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new tnm(this));
  }
  
  private void m()
  {
    if ((this.b instanceof tnc)) {
      ((tnc)this.b).f();
    }
  }
  
  public stSimpleMetaFeed a()
  {
    if ((this.jdField_a_of_type_Tmv != null) && ((this.jdField_a_of_type_Tmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.jdField_a_of_type_Tmv.a();
    }
    return null;
  }
  
  public WSVerticalPageFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  }
  
  public WSVerticalVideoRelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  }
  
  public tmv a()
  {
    return this.jdField_a_of_type_Tmv;
  }
  
  public tnc a()
  {
    if ((this.b instanceof tnc)) {
      return (tnc)this.b;
    }
    return null;
  }
  
  public tne a()
  {
    if ((this.c instanceof tne)) {
      return (tne)this.c;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tck.d();
    this.b.d();
    this.c.d();
    this.d.d();
    this.e.d();
    this.f.d();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tck.a(paramInt);
    this.b.a(paramInt);
    this.c.a(paramInt);
    this.d.a(paramInt);
    this.e.a(paramInt);
    this.f.a(paramInt);
  }
  
  public void a(tmv paramtmv)
  {
    this.jdField_a_of_type_Tmv = paramtmv;
    this.jdField_a_of_type_Tck.a(paramtmv);
    this.b.a(paramtmv);
    this.c.a(paramtmv);
    this.d.a(paramtmv);
    this.e.a(paramtmv);
    this.f.a(paramtmv);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Tmv != null) && ((this.jdField_a_of_type_Tmv.a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Tmv.a();
      tgg.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!(this.e instanceof tmy));
      ((tmy)this.e).f();
      return;
    } while (!(this.jdField_a_of_type_Tck instanceof tna));
    ((tna)this.jdField_a_of_type_Tck).b();
  }
  
  public void b(tmv paramtmv)
  {
    this.jdField_a_of_type_Tmv = paramtmv;
    this.jdField_a_of_type_Tck.a(paramtmv);
    this.d.a(paramtmv);
    this.e.a(paramtmv);
    this.f.a(paramtmv);
  }
  
  public void c()
  {
    tlr.a(this.jdField_a_of_type_AndroidContentContext, a(), 2, this.jdField_a_of_type_Int, "fullscreen_videoPlay");
    tnt.c(a());
  }
  
  public void d()
  {
    e();
    f();
    i();
    j();
    g();
    h();
    k();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnk
 * JD-Core Version:    0.7.0.1
 */