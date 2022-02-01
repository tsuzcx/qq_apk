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

public class vcb
  extends ukz<vaq>
  implements View.OnClickListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private vcc jdField_a_of_type_Vcc;
  private vct jdField_a_of_type_Vct;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public vcb(Context paramContext, vct paramvct)
  {
    super(paramContext);
    this.jdField_a_of_type_Vct = paramvct;
    if (paramvct != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvct.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramvct.itemView);
    }
    uya.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    vaq localvaq = (vaq)a();
    if ((localvaq != null) && ((localvaq.a() instanceof stSimpleMetaFeed)))
    {
      uya.c("comment", "data hashCode:" + localvaq.hashCode());
      return (stSimpleMetaFeed)localvaq.a();
    }
    uya.c("comment", "data is null");
    return null;
  }
  
  private boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void b(vaq paramvaq)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_Vcc == null)
      {
        this.jdField_a_of_type_Vcc = new vcc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
        this.jdField_a_of_type_Vcc.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vcc.a(paramvaq);
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
      uya.c("comment", "itemInfo hashCode:" + localstSimpleMetaFeed.hashCode());
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
      rwv.a(this.c, e(), "0");
      return;
    }
    this.c.setText(2131719694);
  }
  
  private void j()
  {
    Object localObject = a();
    vdq.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), 1000001, (stSimpleMetaFeed)localObject);
    uwc.c();
    localObject = new uwy();
    ((uwy)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    ((uwy)localObject).jdField_a_of_type_Int = 3;
    ((uwy)localObject).jdField_b_of_type_Int = a();
    ((uwy)localObject).jdField_a_of_type_JavaLangString = vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    ((uwy)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    ((uwy)localObject).c = "forward";
    ((uwy)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uyd.a(this.jdField_a_of_type_AndroidContentContext, (uwy)localObject);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    vdq.h(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
    umj localumj = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a;
    if (localumj == null)
    {
      uya.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    uya.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    localumj.a(a());
    localumj.a(vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    localumj.a(a());
    localumj.b();
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    uql.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    vdq.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), localstSimpleMetaFeed);
  }
  
  public void a(vaq paramvaq)
  {
    super.a(paramvaq);
    b(paramvaq);
  }
  
  protected int b()
  {
    return 2131560032;
  }
  
  protected void b()
  {
    f();
    g();
    i();
    if (this.jdField_a_of_type_Vcc != null) {
      this.jdField_a_of_type_Vcc.b();
    }
  }
  
  protected void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      uql.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131380604));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131380603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380605));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131380601));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380509));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380487));
    this.c = ((TextView)a(2131380677));
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
      rwv.a(this.jdField_a_of_type_AndroidWidgetTextView, c(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719691);
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
      rwv.a(this.jdField_b_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719674);
  }
  
  public void h()
  {
    Object localObject = (vaq)a();
    if ((localObject == null) || (((vaq)localObject).a() == null)) {}
    while (uyo.b()) {
      return;
    }
    localObject = (stSimpleMetaFeed)((vaq)localObject).a();
    uql.a().a((stSimpleMetaFeed)localObject, a(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vdq.a(str1, str2, bool, (stSimpleMetaFeed)localObject);
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
 * Qualified Name:     vcb
 * JD-Core Version:    0.7.0.1
 */