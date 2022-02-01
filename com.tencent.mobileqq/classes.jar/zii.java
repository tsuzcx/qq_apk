import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

public class zii
  implements View.OnClickListener
{
  public zii(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, zhq paramzhq) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("postUin", this.jdField_a_of_type_Zhq.a.poster.id.get());
    if (this.jdField_a_of_type_Zhq.a.poster.youZhan.size() > 0) {
      if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_Zhq.a.poster.youZhan.get(0)).type.get() <= 1) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("has_shop", bool);
      QZoneHelper.forwardToQQPublicAccountPublishPage(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment.getActivity(), localIntent, 0);
      zxp.b(this.jdField_a_of_type_Zhq.a.poster.id.get(), "auth_person", "blank_post", 0, 0, new String[0]);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zii
 * JD-Core Version:    0.7.0.1
 */