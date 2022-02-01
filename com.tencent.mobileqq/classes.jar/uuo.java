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

public class uuo
  extends uej<usv>
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private uuy jdField_a_of_type_Uuy;
  private View b;
  private View c;
  
  public uuo(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    this.jdField_a_of_type_Uuy = paramuuy;
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
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
        return (int)(uqs.c() * f);
      }
      paramstMetaUgcVideoSeg = a();
    } while ((j == 1280) && (i == 720) && (paramstMetaUgcVideoSeg != null) && (paramstMetaUgcVideoSeg.gdt_ad_type == 1) && (paramstMetaUgcVideoSeg.gdt_ad_info != null));
    return 0;
  }
  
  private stSimpleMetaFeed a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localusv.a();
    }
    return null;
  }
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a();
    }
    return null;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramstSimpleMetaFeed, false, "fullscreen_videoplay");
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Uuy != null) && (this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz != null) && (this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz.a != null) && (this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz.a.b());
  }
  
  private void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.video == null)) {
      return;
    }
    int i = a(paramstSimpleMetaFeed.video);
    paramstSimpleMetaFeed = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    if (i > 0) {}
    for (paramstSimpleMetaFeed.height = i;; paramstSimpleMetaFeed.height = uqs.d())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramstSimpleMetaFeed);
      return;
    }
  }
  
  private void j()
  {
    WSPlayerManager localWSPlayerManager = a();
    if ((localWSPlayerManager != null) && (this.jdField_a_of_type_Uuy != null)) {
      localWSPlayerManager.b(this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz, false);
    }
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView == null) {}
    while (paramInt1 == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility()) {
      return;
    }
    uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected int b()
  {
    return 2131560033;
  }
  
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    b(localstSimpleMetaFeed);
    a(localstSimpleMetaFeed);
    this.c.setVisibility(8);
    i();
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setVisibility(paramInt);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131380693));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131380694));
    this.c = a(2131380698);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131380691));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380696));
    this.b = a(2131380695);
    this.b.setOnClickListener(new uup(this));
  }
  
  public void f()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null)
    {
      if (localWSPlayerManager.c()) {
        localWSPlayerManager.b();
      }
    }
    else {
      return;
    }
    localWSPlayerManager.c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void i()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuo
 * JD-Core Version:    0.7.0.1
 */