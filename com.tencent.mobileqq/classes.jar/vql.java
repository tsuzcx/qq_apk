import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vql
  extends uyw<vpj>
  implements View.OnClickListener
{
  private static final int d = ScreenUtil.dip2px(2.5F);
  private static final int e = ScreenUtil.dip2px(150.0F);
  private static final int f = ScreenUtil.dip2px(1.0F);
  private static final int g = Color.parseColor("#5CFFFFFF");
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TextView b;
  
  public vql(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    if (paramvrn != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(8);
      return;
    }
    if (vmg.a(paramstSimpleMetaPerson))
    {
      b(paramstSimpleMetaPerson);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(8);
      return;
    }
    d(paramstSimpleMetaPerson);
  }
  
  private void d(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(0);
    vnd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
  }
  
  private void e(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int i = this.b.getWidth();
    int j = vnc.c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(j - i - e);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaPerson.nick);
    i = vmg.a(paramstSimpleMetaPerson.medal);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(f);
    if (i != -1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, a().getDrawable(i), null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void f()
  {
    vnr.a("profile", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void g()
  {
    vnr.a("nickname", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void h()
  {
    if (!NetworkUtil.isNetworkAvailable(a())) {
      bjkv.a().a(2131720145);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    this.b.setVisibility(8);
    vbg.a().b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.id, 1);
    vsj.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  protected void a()
  {
    vpj localvpj = (vpj)a();
    if (localvpj == null) {}
    while (!(localvpj.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localvpj.a());
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i = 8;
    if (paramstSimpleMetaPerson == null)
    {
      this.b.setVisibility(8);
      return;
    }
    if (TextUtils.equals(vnd.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    TextView localTextView = this.b;
    if (vmg.a(paramstSimpleMetaPerson.followStatus)) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      return;
      i = 0;
    }
  }
  
  protected int b()
  {
    return 2131560071;
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = (vpj)a();
    if (localObject == null) {}
    while (!(((vpj)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = ((stSimpleMetaFeed)((vpj)localObject).a()).poster;
    a((stSimpleMetaPerson)localObject);
    e((stSimpleMetaPerson)localObject);
    c((stSimpleMetaPerson)localObject);
  }
  
  public void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (vmg.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster))
    {
      veu.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramstSimpleMetaPerson.avatar, new vqm(this, paramstSimpleMetaPerson));
      return;
    }
    veu.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380744));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131380745));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(d);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(g);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380749));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380748));
    this.b.setOnClickListener(this);
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
      f();
      continue;
      g();
      continue;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vql
 * JD-Core Version:    0.7.0.1
 */