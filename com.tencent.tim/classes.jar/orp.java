import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class orp
  extends ogm<oqr>
  implements View.OnClickListener
{
  private orq a;
  private WSVerticalPageFragment c;
  private ViewGroup ck;
  private osf d;
  private RelativeLayout fI;
  private ImageView lx;
  private ImageView ly;
  private TextView uV;
  private ViewStub v;
  private TextView vn;
  private TextView vo;
  
  public orp(Context paramContext, osf paramosf)
  {
    super(paramContext);
    this.d = paramosf;
    if (paramosf != null)
    {
      this.c = paramosf.c;
      this.fI = ((RelativeLayout)paramosf.itemView);
    }
    ooz.i("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private boolean GV()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private stSimpleMetaFeed b()
  {
    oqr localoqr = (oqr)getData();
    ooz.w("comment", "data hashCode:" + localoqr.hashCode());
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localoqr.B();
    }
    return null;
  }
  
  private void bgB()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.shareHidden))
    {
      this.vo.setVisibility(8);
      return;
    }
    this.vo.setVisibility(0);
    if (rQ() > 0)
    {
      muj.a(this.vo, rQ(), "0");
      return;
    }
    this.vo.setText(2131721933);
  }
  
  private void bgD()
  {
    osv.g(this.c.getFrom(), this.c.getPlayScene(), b());
    if ((this.c == null) || (this.c.c == null))
    {
      ooz.w("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    ooz.w("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    this.c.c.setPosition(getPosition());
    this.c.c.bX(osv.fE(this.c.getFrom()), this.c.getPlayScene());
    this.c.c.b(b());
    this.c.c.beM();
  }
  
  private void f(oqr paramoqr)
  {
    if ((b() != null) && (b().new_icon != null) && ((b().new_icon.tag_type == 1) || (b().new_icon.tag_type == 2)))
    {
      if (this.a == null)
      {
        this.a = new orq(this.mContext, this.d);
        this.a.initLayout(this.v);
      }
      this.a.setData(paramoqr);
    }
  }
  
  private int gv()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if (localstSimpleMetaFeed != null)
    {
      ooz.w("comment", "itemInfo hashCode:" + localstSimpleMetaFeed.hashCode());
      return localstSimpleMetaFeed.total_comment_num;
    }
    return 0;
  }
  
  private void onShareClick()
  {
    Object localObject = b();
    osv.b(this.c.getFrom(), this.c.getPlayScene(), 1003003, (stSimpleMetaFeed)localObject);
    localObject = new ooe();
    ((ooe)localObject).b = b();
    ((ooe)localObject).mPageType = 3;
    ((ooe)localObject).mPosition = getPosition();
    ((ooe)localObject).mSopName = osv.fE(this.c.getFrom());
    ((ooe)localObject).aqb = this.c.getPlayScene();
    ((ooe)localObject).aqU = "forward";
    ((ooe)localObject).b(this.c);
    opc.a(this.mContext, (ooe)localObject);
  }
  
  private int rP()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.ding_count;
    }
    return 0;
  }
  
  private int rQ()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.share_info != null)) {
      return localstSimpleMetaFeed.share_info.share_num;
    }
    return 0;
  }
  
  public void E(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    okd.a().a(localstSimpleMetaFeed, getPosition(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.uV, this.lx, this.ly, this.fI);
    osv.c(this.c.getFrom(), this.c.getPlayScene(), localstSimpleMetaFeed);
  }
  
  protected void Hp() {}
  
  public void Hu()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.commentHidden))
    {
      this.vn.setVisibility(8);
      return;
    }
    this.vn.setVisibility(0);
    if (gv() > 0)
    {
      muj.a(this.vn, gv(), "0");
      return;
    }
    this.vn.setText(2131721922);
  }
  
  public void b(oqr paramoqr)
  {
    super.setData(paramoqr);
    f(paramoqr);
  }
  
  public void bfg()
  {
    Object localObject = (oqr)getData();
    if ((localObject == null) || (((oqr)localObject).B() == null)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((oqr)localObject).B();
    okd.a().a((stSimpleMetaFeed)localObject, getPosition(), this.uV, this.lx, this.ly, this.fI);
    String str1 = this.c.getFrom();
    String str2 = this.c.getPlayScene();
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      osv.a(str1, str2, bool, (stSimpleMetaFeed)localObject);
      return;
    }
  }
  
  public void bgC()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.dingHidden))
    {
      this.ck.setVisibility(8);
      return;
    }
    this.ck.setVisibility(0);
    this.lx.setSelected(GV());
    this.ly.setVisibility(8);
    if (rP() > 0)
    {
      muj.a(this.uV, rP(), "0");
      return;
    }
    this.uV.setText(2131721931);
  }
  
  protected int gn()
  {
    return 2131560219;
  }
  
  protected void initView()
  {
    this.lx = ((ImageView)findViewById(2131381730));
    this.ly = ((ImageView)findViewById(2131381729));
    this.uV = ((TextView)findViewById(2131381731));
    this.ck = ((ViewGroup)findViewById(2131381727));
    this.ck.setOnClickListener(this);
    this.vn = ((TextView)findViewById(2131381635));
    this.vn.setOnClickListener(this);
    this.v = ((ViewStub)findViewById(2131381618));
    this.vo = ((TextView)findViewById(2131381804));
    this.vo.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bfg();
      continue;
      bgD();
      continue;
      onShareClick();
    }
  }
  
  protected void onRecycle()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if (localstSimpleMetaFeed != null) {
      okd.a().pH(localstSimpleMetaFeed.id);
    }
  }
  
  protected void onUpdateUI()
  {
    bgC();
    Hu();
    bgB();
    if (this.a != null) {
      this.a.onUpdateUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orp
 * JD-Core Version:    0.7.0.1
 */