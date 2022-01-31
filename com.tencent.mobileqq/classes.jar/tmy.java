import NS_KING_SOCIALIZE_META.stShareBody;
import NS_KING_SOCIALIZE_META.stShareInfo;
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
import java.util.Map;

public class tmy
  extends tck<tmv>
  implements View.OnClickListener
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private tmz jdField_a_of_type_Tmz;
  private tnj jdField_a_of_type_Tnj;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public tmy(Context paramContext, tnj paramtnj)
  {
    super(paramContext);
    this.jdField_a_of_type_Tnj = paramtnj;
    if (paramtnj != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramtnj.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramtnj.itemView);
    }
    tlo.a("comment", "WSVerticalItemBottomOperationController constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
  
  private stSimpleMetaFeed a()
  {
    tmv localtmv = (tmv)a();
    if ((localtmv != null) && ((localtmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localtmv.a();
    }
    return null;
  }
  
  private boolean a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    return (localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.is_ding == 1);
  }
  
  private void b(tmv paramtmv)
  {
    if ((a() != null) && (a().new_icon != null) && ((a().new_icon.tag_type == 1) || (a().new_icon.tag_type == 2)))
    {
      if (this.jdField_a_of_type_Tmz == null)
      {
        this.jdField_a_of_type_Tmz = new tmz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tnj);
        this.jdField_a_of_type_Tmz.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Tmz.a(paramtmv);
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
    if (localstSimpleMetaFeed != null) {
      return localstSimpleMetaFeed.total_comment_num;
    }
    return 0;
  }
  
  private void h()
  {
    if (d() > 0)
    {
      rdm.a(this.jdField_b_of_type_AndroidWidgetTextView, d(), "0");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("评论");
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      tlr.a(this.jdField_a_of_type_AndroidContentContext, a(), 2, a(), "fullscreen_videoPlay");
      return;
    }
    k();
  }
  
  private void j()
  {
    tnt.f(a());
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a == null))
    {
      tlo.c("comment", "need create presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.jdField_a_of_type_Boolean = false;
    tlo.c("comment", "复用 presenter >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a("fullscreen_videoplay");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a();
  }
  
  private void k()
  {
    Object localObject1 = a();
    tnt.b(1003003, (stSimpleMetaFeed)localObject1);
    if ((localObject1 == null) || (((stSimpleMetaFeed)localObject1).share_info == null)) {}
    for (;;)
    {
      return;
      String str = ((stSimpleMetaFeed)localObject1).share_info.jump_url;
      if (((stSimpleMetaFeed)localObject1).share_info.body_map != null) {}
      Object localObject2;
      for (localObject1 = (stShareBody)((stSimpleMetaFeed)localObject1).share_info.body_map.get(Integer.valueOf(0)); localObject1 != null; localObject2 = null) {
        try
        {
          tlr.a(this.jdField_a_of_type_AndroidContentContext, ((stShareBody)localObject1).title, ((stShareBody)localObject1).desc, ((stShareBody)localObject1).image_url, str, tlv.a(), 0);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          tlo.d("AbsWsUIGroup", "shareToQzone error:" + localException);
          return;
        }
      }
    }
  }
  
  protected void a() {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    tgg.a().a(localstSimpleMetaFeed, a(), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    tnt.b(localstSimpleMetaFeed);
  }
  
  public void a(tmv paramtmv)
  {
    super.a(paramtmv);
    b(paramtmv);
  }
  
  protected int b()
  {
    return 2131559871;
  }
  
  protected void b()
  {
    f();
    h();
    if (this.jdField_a_of_type_Tmz != null) {
      this.jdField_a_of_type_Tmz.b();
    }
  }
  
  protected void c()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    if (localstSimpleMetaFeed != null) {
      tgg.a().a(localstSimpleMetaFeed.id);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131379686));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379685));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379687));
    ((ViewGroup)a(2131379683)).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379592));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131379575));
    TextView localTextView = (TextView)a(2131379758);
    localTextView.setOnClickListener(this);
    if (tee.a().a())
    {
      this.jdField_a_of_type_Boolean = false;
      localTextView.setText(2131721477);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localTextView.setText(2131697678);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(a());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (c() > 0)
    {
      rdm.a(this.jdField_a_of_type_AndroidWidgetTextView, c(), "0");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("赞");
  }
  
  public void g()
  {
    Object localObject = (tmv)a();
    if ((localObject == null) || (((tmv)localObject).a() == null)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((tmv)localObject).a();
    tgg.a().a((stSimpleMetaFeed)localObject, a(), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (((stSimpleMetaFeed)localObject).is_ding == 1) {}
    for (boolean bool = true;; bool = false)
    {
      tnt.a(bool, (stSimpleMetaFeed)localObject);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379683: 
      g();
      return;
    case 2131379592: 
      j();
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmy
 * JD-Core Version:    0.7.0.1
 */