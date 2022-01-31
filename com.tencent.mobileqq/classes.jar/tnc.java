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

public class tnc
  extends tck<tmv>
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View b;
  private View c;
  
  public tnc(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private int a(stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    int i = paramstMetaUgcVideoSeg.width;
    int j = paramstMetaUgcVideoSeg.height;
    if ((i <= 0) || (j <= 0)) {}
    float f;
    do
    {
      return 0;
      f = j / i;
    } while (f >= 1.33F);
    return (int)(tlu.e() * f);
  }
  
  private stSimpleMetaFeed a()
  {
    tmv localtmv = (tmv)a();
    if ((localtmv != null) && ((localtmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localtmv.a();
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView == null) || (paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.video == null)) {
      return;
    }
    int i = a(paramstSimpleMetaFeed.video);
    paramstSimpleMetaFeed = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    if (i > 0) {}
    for (paramstSimpleMetaFeed.height = i;; paramstSimpleMetaFeed.height = tlu.f())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramstSimpleMetaFeed);
      return;
    }
  }
  
  private void j()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager != null) {
      localWSPlayerManager.b(localWSPlayerManager.a(), false);
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
    tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected int b()
  {
    return 2131559874;
  }
  
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    a(localstSimpleMetaFeed);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localstSimpleMetaFeed, false);
    this.c.setVisibility(8);
    i();
  }
  
  public void b(int paramInt)
  {
    if (this.c != null) {
      this.c.setVisibility(paramInt);
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131379566));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131379567));
    this.c = a(2131379571);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131379565));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379569));
    this.b = a(2131379568);
    this.b.setOnClickListener(new tnd(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnc
 * JD-Core Version:    0.7.0.1
 */