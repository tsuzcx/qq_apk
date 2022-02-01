import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import java.util.ArrayList;

public class vjo
  extends blij<vcf>
{
  private static final int jdField_a_of_type_Int = vmg.a(5.0F);
  private static final int jdField_b_of_type_Int = vmg.a(2.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private RoundTextView jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView;
  private vcf jdField_a_of_type_Vcf;
  private vjn jdField_a_of_type_Vjn;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private int c;
  
  private vjo(ViewGroup paramViewGroup, vjn paramvjn)
  {
    super(paramViewGroup, 2131560449);
    this.jdField_a_of_type_Vjn = paramvjn;
    d();
  }
  
  public static vjo a(ViewGroup paramViewGroup, vjn paramvjn)
  {
    return new vjo(paramViewGroup, paramvjn);
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(String.valueOf(paramInt));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131381559));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131381561));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381584));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)a(2131381565));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131381542));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131381549));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131381548));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new vjp(this));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new vjq(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderInnerPadding(5);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(a().getResources().getColor(2131167363));
  }
  
  private void e()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if ((this.jdField_a_of_type_Vjn == null) || (localstSimpleMetaPerson == null) || (this.jdField_a_of_type_Vcf == null)) {
      return;
    }
    vmg.a(this.jdField_a_of_type_Vjn.a(), localstSimpleMetaPerson.avatarSchema, 0, localstSimpleMetaPerson.id);
    vka.b(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Vcf.a(), this.jdField_a_of_type_Vcf.a());
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      vmp.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
      return;
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    vbg.a().b(localstSimpleMetaPerson.id, 1);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new vjs(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  public stSimpleMetaPerson a()
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) {
      return this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    }
    return null;
  }
  
  public void a()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if (vmg.a(localstSimpleMetaPerson)) {
      veu.a().a(this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localstSimpleMetaPerson.avatar, new vjr(this));
    }
  }
  
  public void a(vcf paramvcf, int paramInt)
  {
    if ((paramvcf == null) || (((ArrayList)paramvcf.a()).size() < 1)) {}
    do
    {
      return;
      this.jdField_a_of_type_Vcf = paramvcf;
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((ArrayList)paramvcf.a()).get(0));
    } while (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null);
    this.c = paramInt;
    a(paramvcf.a());
    a(paramvcf.a());
    paramvcf = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    if (paramvcf != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      }
      if (!vmg.a(paramvcf.followStatus)) {
        break label184;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    for (;;)
    {
      vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, true, "focus");
      vnd.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramvcf.avatar);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvcf.nick);
      if (!vmg.a(paramvcf)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
      label184:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    }
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = Color.parseColor("#67FFFFFF");; i = Color.parseColor("#FF7A46FF"))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(i);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vcf == null)
    {
      vmp.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
      return;
    }
    vka.a(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Vcf.a(), this.jdField_a_of_type_Vcf.a());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    if (vmg.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.followStatus))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
  }
  
  public void h()
  {
    super.h();
    veu.a().a(this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjo
 * JD-Core Version:    0.7.0.1
 */