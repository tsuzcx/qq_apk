import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class orw
  extends ogm<oqr>
{
  private ProgressBar D;
  private KandianUrlImageView af;
  private FrameLayout ax;
  private WSVerticalPageFragment c;
  private View nE;
  private View nF;
  private TextView vv;
  
  public orw(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  private int a(stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    int j = paramstMetaUgcVideoSeg.width;
    int i = paramstMetaUgcVideoSeg.height;
    if ((j <= 0) || (i <= 0)) {
      i = 0;
    }
    do
    {
      return i;
      float f = i / j;
      if (f < 1.33F) {
        return (int)(opm.getScreenWidth() * f);
      }
      paramstMetaUgcVideoSeg = b();
    } while ((j == 1280) && (i == 720) && (paramstMetaUgcVideoSeg != null) && (paramstMetaUgcVideoSeg.gdt_ad_type == 1) && (paramstMetaUgcVideoSeg.gdt_ad_info != null));
    return 0;
  }
  
  private WSPlayerManager a()
  {
    if ((this.c != null) && (this.c.a() != null)) {
      return this.c.a().a();
    }
    return null;
  }
  
  private stSimpleMetaFeed b()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localoqr.B();
    }
    return null;
  }
  
  private void bgF()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null) {
      localWSPlayerManager.c(localWSPlayerManager.b(), false);
    }
  }
  
  private void g(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((this.af == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.video == null)) {
      return;
    }
    int i = a(paramstSimpleMetaFeed.video);
    paramstSimpleMetaFeed = (RelativeLayout.LayoutParams)this.af.getLayoutParams();
    if (i > 0) {}
    for (paramstSimpleMetaFeed.height = i;; paramstSimpleMetaFeed.height = opm.getScreenHeight())
    {
      this.af.setLayoutParams(paramstSimpleMetaFeed);
      return;
    }
  }
  
  protected void Hp() {}
  
  public void bgG()
  {
    this.D.setVisibility(0);
  }
  
  public void bgH()
  {
    this.D.setVisibility(8);
  }
  
  public void bgq()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null)
    {
      if (localWSPlayerManager.isPlaying()) {
        localWSPlayerManager.pause();
      }
    }
    else {
      return;
    }
    localWSPlayerManager.restart();
  }
  
  public FrameLayout d()
  {
    return this.ax;
  }
  
  public void dB(int paramInt1, int paramInt2)
  {
    if (this.af == null) {}
    while (paramInt1 == this.af.getVisibility()) {
      return;
    }
    opn.m(this.af, paramInt1, paramInt2);
  }
  
  protected int gn()
  {
    return 2131560225;
  }
  
  public void hideErrorView()
  {
    this.nE.setVisibility(8);
    this.vv.setVisibility(8);
  }
  
  protected void initView()
  {
    this.ax = ((FrameLayout)findViewById(2131381549));
    this.af = ((KandianUrlImageView)findViewById(2131381550));
    this.nF = findViewById(2131381554);
    this.D = ((ProgressBar)findViewById(2131381547));
    this.vv = ((TextView)findViewById(2131381552));
    this.nE = findViewById(2131381551);
    this.nE.setOnClickListener(new orx(this));
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = b();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    g(localstSimpleMetaFeed);
    this.af.setVisibility(0);
    opn.a(this.af, localstSimpleMetaFeed, false, "fullscreen_videoPlay");
    this.nF.setVisibility(8);
    hideErrorView();
  }
  
  public void uW(int paramInt)
  {
    if (this.nF != null) {
      this.nF.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orw
 * JD-Core Version:    0.7.0.1
 */