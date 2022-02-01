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

public class uug
  extends uej<usv>
  implements View.OnClickListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private uuh jdField_a_of_type_Uuh;
  private uuy jdField_a_of_type_Uuy;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public uug(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    this.jdField_a_of_type_Uuy = paramuuy;
    if (paramuuy != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramuuy.itemView);
    }
    uqf.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    usv localusv = (usv)a();
    uqf.c("comment", "data hashCode:" + localusv.hashCode());
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localusv.a();
    }
    return null;
  }
  
  private boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void b(usv paramusv)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_Uuh == null)
      {
        this.jdField_a_of_type_Uuh = new uuh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
        this.jdField_a_of_type_Uuh.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Uuh.a(paramusv);
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
      uqf.c("comment", "itemInfo hashCode:" + localstSimpleMetaFeed.hashCode());
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
      rpt.a(this.c, e(), "0");
      return;
    }
    this.c.setText(2131719375);
  }
  
  private void j()
  {
    Object localObject = a();
    uvv.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), 1000001, (stSimpleMetaFeed)localObject);
    uoi.c();
    localObject = new upd();
    ((upd)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
    ((upd)localObject).jdField_a_of_type_Int = 3;
    ((upd)localObject).jdField_b_of_type_Int = a();
    ((upd)localObject).jdField_a_of_type_JavaLangString = uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
    ((upd)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    ((upd)localObject).c = "forward";
    ((upd)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    uqi.a(this.jdField_a_of_type_AndroidContentContext, (upd)localObject);
  }
  
  private void k()
  {
    uvv.h(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), a());
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a == null))
    {
      uqf.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    uqf.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.b();
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    ujq.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    uvv.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), localstSimpleMetaFeed);
  }
  
  public void a(usv paramusv)
  {
    super.a(paramusv);
    b(paramusv);
  }
  
  protected int b()
  {
    return 2131560026;
  }
  
  protected void b()
  {
    f();
    g();
    i();
    if (this.jdField_a_of_type_Uuh != null) {
      this.jdField_a_of_type_Uuh.b();
    }
  }
  
  protected void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      ujq.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131380878));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131380877));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380879));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131380875));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380783));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380761));
    this.c = ((TextView)a(2131380951));
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
      rpt.a(this.jdField_a_of_type_AndroidWidgetTextView, c(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719372);
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
      rpt.a(this.jdField_b_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719356);
  }
  
  public void h()
  {
    Object localObject = (usv)a();
    if ((localObject == null) || (((usv)localObject).a() == null)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((usv)localObject).a();
    ujq.a().a((stSimpleMetaFeed)localObject, a(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      uvv.a(str1, str2, bool, (stSimpleMetaFeed)localObject);
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
 * Qualified Name:     uug
 * JD-Core Version:    0.7.0.1
 */