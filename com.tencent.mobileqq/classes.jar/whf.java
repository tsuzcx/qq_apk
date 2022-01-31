import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class whf
  implements View.OnClickListener
{
  whf(whe paramwhe, rof paramrof, int paramInt) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = ((BaseActivity)paramView.getContext()).app;
    Object localObject = new Intent(paramView.getContext(), ChatActivity.class);
    ((Intent)localObject).putExtra("uintype", 1008);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_Rof.c);
    ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("red_hot_count", this.jdField_a_of_type_Rof.b);
    ((Intent)localObject).putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 2, "onClickFeedItem->uin:" + this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString + ", name:" + this.jdField_a_of_type_Rof.c);
    }
    paramView = "0X80067F1";
    int i = this.jdField_a_of_type_Rof.jdField_a_of_type_Int;
    String str;
    int j;
    if (i == 1)
    {
      paramView = "0X80067EF";
      long l = rol.a().a(this.jdField_a_of_type_Rof);
      awqx.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString, paramView, paramView, 0, 0, "" + i, "" + l, "" + (this.jdField_a_of_type_Int + 1), "" + this.jdField_a_of_type_Rof.b);
      ahcb.a(localQQAppInterface, this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rof.jdField_a_of_type_Int, this.jdField_a_of_type_Rof.b, 2, this.jdField_a_of_type_Rof.c);
      localObject = "";
      paramView = (View)localObject;
      if (this.jdField_a_of_type_Rof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        paramView = (View)localObject;
        if (this.jdField_a_of_type_Rof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          paramView = this.jdField_a_of_type_Rof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      str = this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Rof.jdField_a_of_type_Int;
      j = this.jdField_a_of_type_Rof.b;
      if (this.jdField_a_of_type_Rof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label569;
      }
    }
    label569:
    for (localObject = "";; localObject = this.jdField_a_of_type_Rof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
    {
      akij.b(localQQAppInterface, str, i, j, (String)localObject, paramView);
      if (adkp.a(this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString)) {
        awqx.b(localQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.2.6", "");
      }
      wye.a(this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", this.jdField_a_of_type_Rof.c, this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangCharSequence.toString() });
      ruf.a(null, "SUBSCRIPT_AIO_COST");
      return;
      if (i != 2) {
        break;
      }
      paramView = "0X80067F0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     whf
 * JD-Core Version:    0.7.0.1
 */