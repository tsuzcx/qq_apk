import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class brb
  implements CompoundButton.OnCheckedChangeListener
{
  public brb(PubAccountAssistantSettingAdapter paramPubAccountAssistantSettingAdapter, PublicAccountInfo paramPublicAccountInfo, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
    int i;
    Object localObject;
    label33:
    String str;
    if (paramBoolean)
    {
      i = 1;
      paramCompoundButton.mShowMsgFlag = i;
      paramCompoundButton = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
      if (!paramBoolean) {
        break label152;
      }
      i = 1;
      PubAccountAssistantSettingAdapter.a(paramCompoundButton, (PublicAccountInfo)localObject, 5, i);
      localObject = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131560566);
      str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
      if (!paramBoolean) {
        break label157;
      }
    }
    label152:
    label157:
    for (paramCompoundButton = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131562562);; paramCompoundButton = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131561841))
    {
      paramCompoundButton = String.format((String)localObject, new Object[] { str, paramCompoundButton });
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramCompoundButton);
      ReportController.b(PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter), "P_CliOper", "Pb_account_lifeservice", PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getAccount(), "mp_msg_zhushou_3", "share_succ", 0, 0, "", "", "", "");
      return;
      i = 0;
      break;
      i = 2;
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     brb
 * JD-Core Version:    0.7.0.1
 */