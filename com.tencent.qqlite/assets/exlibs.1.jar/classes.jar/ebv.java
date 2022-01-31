import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager.BannerInfoHandler;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class ebv
  implements RedTouchManager.BannerInfoHandler
{
  ebv(ebu paramebu) {}
  
  public boolean a(VipBannerInfo paramVipBannerInfo)
  {
    int i;
    label161:
    int j;
    label185:
    int k;
    if (1 == paramVipBannerInfo.f)
    {
      this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), System.currentTimeMillis() + paramVipBannerInfo.jdField_a_of_type_Long).commit();
      paramVipBannerInfo.jdField_b_of_type_Long = paramVipBannerInfo.jdField_a_of_type_Long;
      i = 1;
      if ((paramVipBannerInfo == null) || (paramVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null)) {
        break label400;
      }
      m = paramVipBannerInfo.e;
      if ((1 != paramVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get()) || (i == 0) || (TextUtils.isEmpty(paramVipBannerInfo.jdField_b_of_type_JavaLangString)) || (m < 1) || (m > 4)) {
        break label400;
      }
      if ((1 != m) || (VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
        break label378;
      }
      i = 1;
      if ((2 != m) || (VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
        break label383;
      }
      j = 1;
      if ((3 != m) || (!VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
        break label388;
      }
      k = 1;
      label210:
      if ((4 != m) || (!VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
        break label394;
      }
    }
    label388:
    label394:
    for (int m = 1;; m = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
        break label400;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(8, paramVipBannerInfo);
      localMessage.obj = paramVipBannerInfo;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return true;
      long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("blue_banner_time_out" + this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getAccount(), -1L);
      if (l > System.currentTimeMillis())
      {
        paramVipBannerInfo.jdField_b_of_type_Long = (l - System.currentTimeMillis());
        i = 1;
        break;
      }
      i = 0;
      break;
      label378:
      i = 0;
      break label161;
      label383:
      j = 0;
      break label185;
      k = 0;
      break label210;
    }
    label400:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebv
 * JD-Core Version:    0.7.0.1
 */