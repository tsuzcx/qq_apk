import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class utx
  extends uej<usv>
  implements View.OnClickListener
{
  private static final int d = bdep.a(2.5F);
  private static final int e = bdep.a(150.0F);
  private static final int f = Color.parseColor("#5CFFFFFF");
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private TextView b;
  
  public utx(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(0);
    uqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
  }
  
  private void c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int i = this.b.getWidth();
    int j = uqs.c();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(j - i - e);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaPerson.nick);
  }
  
  private void f()
  {
    ure.a("profile", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void g()
  {
    ure.a("nickname", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void h()
  {
    if (!nny.a(a())) {
      bjuh.a().a(2131719373);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    this.b.setVisibility(8);
    ugp.a().b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.id, 1);
    uvv.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if (localusv == null) {}
    while (!(localusv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i = 8;
    if (paramstSimpleMetaPerson == null)
    {
      this.b.setVisibility(8);
      return;
    }
    if (TextUtils.equals(uqt.f(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    TextView localTextView = this.b;
    if (upw.a(paramstSimpleMetaPerson.followStatus)) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      return;
      i = 0;
    }
  }
  
  protected int b()
  {
    return 2131560021;
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = (usv)a();
    if (localObject == null) {}
    while (!(((usv)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = ((stSimpleMetaFeed)((usv)localObject).a()).poster;
    a((stSimpleMetaPerson)localObject);
    c((stSimpleMetaPerson)localObject);
    b((stSimpleMetaPerson)localObject);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380680));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(d);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(f);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380684));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380683));
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
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */