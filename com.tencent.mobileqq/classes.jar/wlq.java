import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;

class wlq
  implements View.OnLongClickListener
{
  wlq(wlo paramwlo, ExtraTypeInfo paramExtraTypeInfo, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7003)
      {
        wlj.a(this.jdField_a_of_type_Wlo.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7002) {
          return true;
        }
        bool1 = bool2;
      } while (!(this.jdField_a_of_type_Wlo.itemView instanceof RelativeFeedItemView));
      bool1 = bool2;
    } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    this.jdField_a_of_type_Wlo.a.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, new wlr(this), new wls(this));
    xhe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_feeds", "press", 0, 0, new String[] { "", this.jdField_a_of_type_Wlo.getAdapterPosition() + "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlq
 * JD-Core Version:    0.7.0.1
 */