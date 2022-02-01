import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vrd
  extends uyw<vpj>
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private vrn jdField_a_of_type_Vrn;
  private View b;
  private View c;
  
  public vrd(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    this.jdField_a_of_type_Vrn = paramvrn;
    if (paramvrn != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private stSimpleMetaFeed a()
  {
    vpj localvpj = (vpj)a();
    if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localvpj.a();
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
    vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramstSimpleMetaFeed, false, "fullscreen_videoplay");
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Vrn != null) && (this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb != null) && (this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb.a != null) && (this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb.a.b());
  }
  
  private void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      if (localObject != null)
      {
        localObject = ((vnw)localObject).a();
        if (localObject != null) {
          break label29;
        }
      }
    }
    label29:
    vrx localvrx;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b() instanceof vrx));
      localvrx = (vrx)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    } while (localvrx.a);
    vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), ((vrn)localObject).jdField_a_of_type_Vgb);
    localvrx.a = true;
  }
  
  private void k()
  {
    WSPlayerManager localWSPlayerManager = a();
    if ((localWSPlayerManager != null) && (this.jdField_a_of_type_Vrn != null)) {
      localWSPlayerManager.b(this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb, false);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
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
    vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected int b()
  {
    return 2131560083;
  }
  
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed == null) {
      return;
    }
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131380758));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131380759));
    this.c = a(2131380763);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131380756));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380761));
    this.b = a(2131380760);
    this.b.setOnClickListener(new vre(this));
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
    j();
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
 * Qualified Name:     vrd
 * JD-Core Version:    0.7.0.1
 */