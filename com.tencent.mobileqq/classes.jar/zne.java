import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zne
  implements View.OnClickListener
{
  zne(znd paramznd, uaq paramuaq, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    znd.a(this.jdField_a_of_type_Znd, paramView, this.jdField_a_of_type_Uaq);
    QQAppInterface localQQAppInterface = ((BaseActivity)paramView.getContext()).app;
    if (QLog.isColorLevel()) {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 2, "onClickFeedItem->uin:" + this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString + ", name:" + this.jdField_a_of_type_Uaq.c);
    }
    String str1 = "0X80067F1";
    int i = this.jdField_a_of_type_Uaq.jdField_a_of_type_Int;
    String str2;
    int j;
    if (i == 1)
    {
      str1 = "0X80067EF";
      long l = uaw.a().a(this.jdField_a_of_type_Uaq);
      bcef.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString, str1, str1, 0, 0, "" + i, "" + l, "" + (this.jdField_a_of_type_Int + 1), "" + this.jdField_a_of_type_Uaq.b);
      akmc.a(localQQAppInterface, this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uaq.jdField_a_of_type_Int, this.jdField_a_of_type_Uaq.b, 2, this.jdField_a_of_type_Uaq.c);
      str2 = this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Uaq.jdField_a_of_type_Int;
      j = this.jdField_a_of_type_Uaq.b;
      if (this.jdField_a_of_type_Uaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label471;
      }
    }
    label471:
    for (str1 = "";; str1 = this.jdField_a_of_type_Uaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
    {
      anxs.b(localQQAppInterface, str2, i, j, str1, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int + "");
      if (agjp.a(this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString)) {
        bcef.b(localQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.4.8", "");
      }
      zxp.a(this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", this.jdField_a_of_type_Uaq.c, this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangCharSequence.toString() });
      ugt.a(null, "SUBSCRIPT_AIO_COST");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2) {
        break;
      }
      str1 = "0X80067F0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zne
 * JD-Core Version:    0.7.0.1
 */