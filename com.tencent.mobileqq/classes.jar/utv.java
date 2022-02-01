import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class utv
  extends uej<usv>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  
  public utv(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    if (TextUtils.equals(uqt.f(), paramstSimpleMetaPerson.id))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    }
    if (upw.a(paramstSimpleMetaPerson.followStatus))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
  }
  
  private void f()
  {
    ure.a("profile", this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void g()
  {
    if (!nny.a(a())) {
      bjuh.a().a(2131719373);
    }
    while ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      return;
    }
    ugp.a().b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.id, 1);
    uvv.f(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    uoi.d();
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new utw(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
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
  
  protected int b()
  {
    return 2131560020;
  }
  
  @UiThread
  protected void b()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    uqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131380680));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131369152));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */