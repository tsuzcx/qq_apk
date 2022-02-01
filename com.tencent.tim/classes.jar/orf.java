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

public class orf
  extends ogm<oqr>
  implements View.OnClickListener
{
  private WSVerticalPageFragment jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private DiniFlyAnimationView jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private stSimpleMetaFeed jdField_h_of_type_UserGrowthStSimpleMetaFeed;
  private RoundImageView jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  
  public orf(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramosf.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void bgu()
  {
    opw.a("profile", this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_h_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void bgv()
  {
    if (!jqi.isNetworkAvailable(getContext())) {
      arxa.a().showToast(2131721932);
    }
    while ((this.jdField_h_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_h_of_type_UserGrowthStSimpleMetaFeed.poster == null) || (this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      return;
    }
    oig.a().aY(this.jdField_h_of_type_UserGrowthStSimpleMetaFeed.poster.id, 1);
    osv.e(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getFrom(), this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getPlayScene(), this.jdField_h_of_type_UserGrowthStSimpleMetaFeed);
    playAnimation();
  }
  
  private void f(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    if (TextUtils.equals(opn.getPersonId(), paramstSimpleMetaPerson.id))
    {
      this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    }
    if (oor.eu(paramstSimpleMetaPerson.followStatus))
    {
      this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
  }
  
  private void playAnimation()
  {
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new org(this));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if (localoqr == null) {}
    while (!(localoqr.B() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_h_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localoqr.B());
  }
  
  protected int gn()
  {
    return 2131560214;
  }
  
  protected void initView()
  {
    this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)findViewById(2131381536));
    this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131369688));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
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
      bgu();
      continue;
      bgv();
    }
  }
  
  protected void onRecycle() {}
  
  @UiThread
  protected void onUpdateUI()
  {
    if ((this.jdField_h_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_h_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    opn.a(this.mContext, this.jdField_h_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_h_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
    f(this.jdField_h_of_type_UserGrowthStSimpleMetaFeed.poster);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */