import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class osj
  extends orb
{
  private oqr a;
  private ogm<oqr> g;
  private ogm<oqr> i;
  private int mPosition;
  
  public osj(Context paramContext, osf paramosf)
  {
    super(paramContext, paramosf);
  }
  
  private void bgL()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381851);
    this.i = new orr(this.mContext, this.d);
    this.i.initLayout(localViewStub);
  }
  
  private void bgM()
  {
    if (this.mItemView == null) {
      return;
    }
    this.mItemView.setOnClickListener(new osk(this));
  }
  
  private void bgm()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381859);
    this.g = new oru(this.mContext, this.c);
    this.g.initLayout(localViewStub);
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
    if (this.g != null) {
      this.g.setData(paramoqr);
    }
    if (this.i != null) {
      this.i.setData(paramoqr);
    }
  }
  
  public void bey() {}
  
  public void bez()
  {
    ooe localooe = new ooe();
    localooe.b = b();
    localooe.mPageType = 3;
    localooe.mPosition = this.mPosition;
    localooe.mSopName = osv.fE(this.c.getFrom());
    localooe.aqb = this.c.getPlayScene();
    localooe.aqU = "more_operations";
    localooe.b(this.c);
    opc.b(this.mContext, localooe);
    osv.d(this.c.getFrom(), this.c.getPlayScene(), b());
  }
  
  public void initUI()
  {
    super.initUI();
    bgm();
    bgL();
    bgM();
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void recycle()
  {
    super.recycle();
    if (this.g != null) {
      this.g.recycle();
    }
    if (this.i != null) {
      this.i.recycle();
    }
  }
  
  public void setPosition(int paramInt)
  {
    super.setPosition(paramInt);
    this.mPosition = paramInt;
    if (this.g != null) {
      this.g.setPosition(paramInt);
    }
    if (this.i != null) {
      this.i.setPosition(paramInt);
    }
  }
  
  public void uE(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osj
 * JD-Core Version:    0.7.0.1
 */