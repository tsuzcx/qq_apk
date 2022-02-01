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

public class vqv
  extends uyw<vpj>
  implements View.OnClickListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private vqw jdField_a_of_type_Vqw;
  private vrn jdField_a_of_type_Vrn;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public vqv(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    this.jdField_a_of_type_Vrn = paramvrn;
    if (paramvrn != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramvrn.itemView);
    }
    vmp.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    vpj localvpj = (vpj)a();
    if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed)))
    {
      vmp.c("comment", "data hashCode:" + localvpj.hashCode());
      return (stSimpleMetaFeed)localvpj.a();
    }
    vmp.c("comment", "data is null");
    return null;
  }
  
  private boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void b(vpj paramvpj)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_Vqw == null)
      {
        this.jdField_a_of_type_Vqw = new vqw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
        this.jdField_a_of_type_Vqw.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vqw.a(paramvpj);
    }
  }
  
  private int c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.ding_count;
    }
    return 0;
  }
  
  private int d()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null)
    {
      vmp.c("comment", "itemInfo hashCode:" + localstSimpleMetaFeed.hashCode());
      return localstSimpleMetaFeed.total_comment_num;
    }
    return 0;
  }
  
  private int e()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.share_info != null)) {
      return localstSimpleMetaFeed.share_info.share_num;
    }
    return 0;
  }
  
  private void i()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.shareHidden))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    if (e() > 0)
    {
      six.a(this.c, e(), "0");
      return;
    }
    this.c.setText(2131720147);
  }
  
  private void j()
  {
    Object localObject = a();
    vsj.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), 1000001, (stSimpleMetaFeed)localObject);
    vkq.c();
    localObject = new vln();
    ((vln)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    ((vln)localObject).jdField_a_of_type_Int = 3;
    ((vln)localObject).jdField_b_of_type_Int = a();
    ((vln)localObject).jdField_a_of_type_JavaLangString = vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    ((vln)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    ((vln)localObject).c = "forward";
    ((vln)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    vms.a(this.jdField_a_of_type_AndroidContentContext, (vln)localObject);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    vsj.h(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
    vaj localvaj = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a;
    if (localvaj == null)
    {
      vmp.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    vmp.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    localvaj.a(a());
    localvaj.a(vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    localvaj.a(a());
    localvaj.b();
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    vem.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    vsj.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), localstSimpleMetaFeed);
  }
  
  public void a(vpj paramvpj)
  {
    super.a(paramvpj);
    b(paramvpj);
  }
  
  protected int b()
  {
    return 2131560076;
  }
  
  protected void b()
  {
    f();
    g();
    i();
    if (this.jdField_a_of_type_Vqw != null) {
      this.jdField_a_of_type_Vqw.b();
    }
  }
  
  protected void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      vem.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131380950));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131380949));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380951));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131380947));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380849));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380827));
    this.c = ((TextView)a(2131381027));
    this.c.setOnClickListener(this);
  }
  
  public void f()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.dingHidden))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(a());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (c() > 0)
    {
      six.a(this.jdField_a_of_type_AndroidWidgetTextView, c(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720144);
  }
  
  public void g()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.floatingLayerCardStyle != null) && (localstSimpleMetaFeed.floatingLayerCardStyle.commentHidden))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (d() > 0)
    {
      six.a(this.jdField_b_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131720127);
  }
  
  public void h()
  {
    Object localObject = (vpj)a();
    if ((localObject == null) || (((vpj)localObject).a() == null)) {}
    while (vnd.b()) {
      return;
    }
    localObject = (stSimpleMetaFeed)((vpj)localObject).a();
    vem.a().a((stSimpleMetaFeed)localObject, a(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vsj.a(str1, str2, bool, (stSimpleMetaFeed)localObject);
      return;
    }
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
      h();
      continue;
      k();
      continue;
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */