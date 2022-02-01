import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class osg
  extends orb
{
  private oqr a;
  private ogm<oqr> g;
  private ogm<oqr> h;
  private GestureDetector mGestureDetector;
  private int mPosition;
  
  public osg(Context paramContext, osf paramosf)
  {
    super(paramContext, paramosf);
  }
  
  private void E(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed)) && ((this.h instanceof orp))) {
      ((orp)this.h).E(paramMotionEvent);
    }
  }
  
  private void bgJ()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381848);
    orn localorn = new orn(this.mContext, this.d);
    localorn.initLayout(localViewStub);
    a(localorn);
  }
  
  private void bgK()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381850);
    this.h = new orp(this.mContext, this.d);
    this.h.initLayout(localViewStub);
    a(this.h);
  }
  
  private void bgm()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381859);
    this.g = new oru(this.mContext, this.c);
    this.g.initLayout(localViewStub);
    a(this.g);
  }
  
  private void bgo()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381861);
    osb localosb = new osb(this.mContext, this.d);
    localosb.initLayout(localViewStub);
    a(localosb);
  }
  
  private void bgp()
  {
    if (this.mItemView == null) {
      return;
    }
    this.mGestureDetector = new GestureDetector(this.mItemView.getContext(), new osh(this));
    this.mItemView.setOnTouchListener(new osi(this));
  }
  
  private void bgq()
  {
    if ((b() instanceof orw)) {
      ((orw)b()).bgq();
    }
  }
  
  public stSimpleMetaFeed b()
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.a.B();
    }
    return null;
  }
  
  public void b(oqr paramoqr)
  {
    super.b(paramoqr);
    this.a = paramoqr;
  }
  
  public void bey()
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.a.B();
      okd.a().pH(localstSimpleMetaFeed.id);
    }
  }
  
  public void bez()
  {
    ooe localooe = new ooe();
    localooe.b = b();
    localooe.mPageType = 2;
    localooe.mPosition = this.mPosition;
    localooe.mSopName = osv.fE(this.c.getFrom());
    localooe.aqb = this.c.getPlayScene();
    localooe.aqU = "more_operations";
    localooe.b(this.c);
    opc.a(this.mContext, localooe);
    osv.d(this.c.getFrom(), this.c.getPlayScene(), b());
  }
  
  public void d(oqr paramoqr)
  {
    this.a = paramoqr;
    e(paramoqr);
  }
  
  public void initUI()
  {
    super.initUI();
    bgm();
    bgJ();
    bgK();
    bgo();
    bgp();
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void setPosition(int paramInt)
  {
    super.setPosition(paramInt);
    this.mPosition = paramInt;
  }
  
  public void uE(int paramInt)
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
        } while (!(this.h instanceof orp));
        ((orp)this.h).bgC();
        return;
      } while (!(this.g instanceof oru));
      ((oru)this.g).onUpdateUI();
      return;
    } while (!(this.h instanceof orp));
    ((orp)this.h).Hu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osg
 * JD-Core Version:    0.7.0.1
 */