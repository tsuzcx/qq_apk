import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ScoreManager;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.ScoreReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class tvr
  implements View.OnClickListener
{
  public tvr(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    long l2 = 0L;
    long l1 = l2;
    if (this.a.jdField_b_of_type_JavaLangString != null)
    {
      l1 = l2;
      if (!this.a.jdField_b_of_type_JavaLangString.isEmpty()) {
        l1 = ScoreManager.a(this.a.jdField_b_of_type_JavaLangString);
      }
    }
    paramView = SharedPreUtils.f(this.a.jdField_d_of_type_JavaLangString);
    l2 = paramView.getLong("qav_roomid", 0L);
    long l3 = paramView.getLong(VideoConstants.g, 0L);
    ScoreReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_Long, this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Long, this.a.e, this.a.jdField_a_of_type_Int, l3, l1, l2, this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "reportEvent beginTime: " + this.a.jdField_a_of_type_Long + ", endTime: " + this.a.jdField_b_of_type_Long + ", sdkVersion: " + this.a.jdField_a_of_type_Int + ", peerSdkVersion: " + l3 + ", bussinessType: " + this.a.jdField_c_of_type_Long + ", bussinessFlag: " + this.a.jdField_d_of_type_Long + ", ip: " + this.a.jdField_b_of_type_JavaLangString + ", toUin: " + this.a.jdField_c_of_type_JavaLangString + ", score: " + this.a.e + ", problems: " + this.a.jdField_a_of_type_JavaLangString);
    }
    paramView.edit().putBoolean(VideoConstants.l, true).commit();
    if (this.a.f != 0L) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_b_of_type_Int, this.a.f);
      this.a.getActivity().finish();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScoreActivity", 2, "removeMsgByUniseq : " + paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvr
 * JD-Core Version:    0.7.0.1
 */