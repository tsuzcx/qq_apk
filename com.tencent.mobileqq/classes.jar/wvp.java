import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class wvp
  implements View.OnClickListener
{
  wvp(wvo paramwvo, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    wis.a(this.jdField_a_of_type_Wvo.a.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 0, wrq.a(wvo.a(this.jdField_a_of_type_Wvo), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.width.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.cover.height.get()));
    xhb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "blank_content_clk", 0, 0, new String[] { "", wvo.a(this.jdField_a_of_type_Wvo) + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvp
 * JD-Core Version:    0.7.0.1
 */