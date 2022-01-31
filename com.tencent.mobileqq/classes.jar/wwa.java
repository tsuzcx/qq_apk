import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wwa
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private CertifiedAccountMeta.StQQGroup jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public wwa(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
    this.b = ((TextView)paramView.findViewById(2131378282));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363600));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(CertifiedAccountMeta.StQQGroup paramStQQGroup)
  {
    String str;
    if (paramStQQGroup != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStQQGroup.name.get());
      this.b.setText(paramStQQGroup.memberNum.get() + ajya.a(2131713382));
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup = paramStQQGroup;
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramStQQGroup.joinState.get() != 1) {
        break label143;
      }
      str = ajya.a(2131713378);
      localButton.setText(str);
      if (RelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView).user != null)
      {
        str = RelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView).user.id.get();
        if (paramStQQGroup.joinState.get() != 1) {
          break label152;
        }
      }
    }
    label143:
    label152:
    for (paramStQQGroup = "open_butten";; paramStQQGroup = "enter_butten")
    {
      xhb.a(str, "auth_fan", paramStQQGroup, 0, 0, new String[0]);
      return;
      str = ajya.a(2131713377);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup != null) && (paramView != null) && (paramView.getContext() != null))
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.joinState.get() == 1)
      {
        localObject = actj.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("uin", String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.id.get()));
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.name.get());
        paramView.getContext().startActivity((Intent)localObject);
      }
    }
    else {
      return;
    }
    Object localObject = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.id.get()), 4);
    ((Bundle)localObject).putInt("t_s_f", 1001);
    banb.a(paramView.getContext(), (Bundle)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwa
 * JD-Core Version:    0.7.0.1
 */