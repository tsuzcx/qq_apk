import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class osl
  extends orb
{
  private oqr a;
  private ogm<oqr> j;
  private ogm<oqr> k;
  private ogm<oqr> l;
  private GestureDetector mGestureDetector;
  private int mPosition;
  
  public osl(Context paramContext, osf paramosf)
  {
    super(paramContext, paramosf);
  }
  
  private void E(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed)) && ((this.j instanceof orp))) {
      ((orp)this.j).E(paramMotionEvent);
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
    ork localork = new ork(this.mContext, this.d);
    localork.initLayout(localViewStub);
    a(localork);
  }
  
  private void bgN()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381857);
    this.j = new ort(this.mContext, this.d);
    this.j.initLayout(localViewStub);
    a(this.j);
  }
  
  private void bgO()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381846);
    this.k = new orf(this.mContext, this.d);
    this.k.initLayout(localViewStub);
    a(this.k);
  }
  
  private void bgP()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381849);
    oro localoro = new oro(this.mContext, this.d);
    localoro.initLayout(localViewStub);
    a(localoro);
  }
  
  private void bgQ()
  {
    if ((this.c != null) && (!TextUtils.equals(this.c.getFrom(), "vertical_layer_collection")))
    {
      ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381847);
      this.l = new orh(this.mContext, this.d);
      this.l.initLayout(localViewStub);
      a(this.l);
    }
  }
  
  private void bgR()
  {
    if ((b() != null) && (b().poster != null) && (!oor.eu(b().poster.followStatus))) {
      ((orf)this.k).onUpdateUI();
    }
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
    this.mGestureDetector = new GestureDetector(this.mItemView.getContext(), new osm(this));
    this.mItemView.setOnTouchListener(new osn(this));
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
  
  public ogm<oqr> d()
  {
    return this.l;
  }
  
  public void d(oqr paramoqr)
  {
    this.a = paramoqr;
    e(paramoqr);
  }
  
  public void initUI()
  {
    super.initUI();
    bgJ();
    bgK();
    bgN();
    bgo();
    bgO();
    bgP();
    bgQ();
    bgp();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.c != null) {
      this.c.uT(paramInt + 1);
    }
  }
  
  public void setPosition(int paramInt)
  {
    super.setPosition(paramInt);
    this.mPosition = paramInt;
  }
  
  public void uE(int paramInt)
  {
    if ((paramInt == 0) && ((this.j instanceof orp))) {
      ((orp)this.j).bgC();
    }
    do
    {
      return;
      if ((paramInt == 1) && ((this.k instanceof orf)))
      {
        bgR();
        return;
      }
    } while ((paramInt != 2) || (!(this.j instanceof orp)));
    ((orp)this.j).Hu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osl
 * JD-Core Version:    0.7.0.1
 */