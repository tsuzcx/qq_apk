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

public class wdd
  implements View.OnClickListener
{
  public wdd(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, wcm paramwcm) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("postUin", this.jdField_a_of_type_Wcm.a.poster.id.get());
    if (this.jdField_a_of_type_Wcm.a.poster.youZhan.size() > 0) {
      if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_Wcm.a.poster.youZhan.get(0)).type.get() <= 1) {
        break label132;
      }
    }
    label132:
    for (boolean bool = true;; bool = false)
    {
      paramView.putExtra("has_shop", bool);
      bfpr.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalBottomOpusFragment.getActivity(), paramView, 0);
      wye.b(this.jdField_a_of_type_Wcm.a.poster.id.get(), "auth_person", "blank_post", 0, 0, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdd
 * JD-Core Version:    0.7.0.1
 */