import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import java.util.ArrayList;

public class uvb
  extends bjwy<uof>
{
  private static final int jdField_a_of_type_Int = uxr.a(5.0F);
  private static final int b = uxr.a(2.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private RoundTextView jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView;
  private uof jdField_a_of_type_Uof;
  private int c;
  
  private uvb(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131560399);
    c();
  }
  
  public static uvb a(ViewGroup paramViewGroup)
  {
    return new uvb(paramViewGroup);
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
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131381196));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131381198));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381221));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)a(2131381202));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131381186));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new uvc(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/followbtn.json");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderInnerPadding(5);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(b);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(a().getResources().getColor(2131167337));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      uya.b("WSFollowFriendFeedHolder", "[showFollowAction] is null");
      return;
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    ung.a().b(localstSimpleMetaPerson.id, 1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new uvd(this));
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
    if (this.jdField_a_of_type_Uof == null)
    {
      uya.b("WSFollowFriendFeedHolder", "[reportExposure] mCurrentItemData is null");
      return;
    }
    uvm.a(this.c + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_Uof.a(), this.jdField_a_of_type_Uof.a());
  }
  
  public void a(uof paramuof, int paramInt)
  {
    if ((paramuof == null) || (((ArrayList)paramuof.a()).size() < 1)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Uof = paramuof;
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((ArrayList)paramuof.a()).get(0));
      } while (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null);
      this.c = paramInt;
      a(paramuof.a());
      a(paramuof.a());
      paramuof = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    } while (paramuof == null);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    }
    if (uxr.a(paramuof.followStatus)) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    for (;;)
    {
      uyo.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, true, "focus");
      uyo.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramuof.avatar);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramuof.nick);
      return;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFrame(1);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    }
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
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed == null) || (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster == null)) {
      return;
    }
    if (uxr.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.followStatus))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvb
 * JD-Core Version:    0.7.0.1
 */