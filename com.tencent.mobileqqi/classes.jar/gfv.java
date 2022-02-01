import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager.BannerInfoHandler;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class gfv
  implements RedTouchManager.BannerInfoHandler
{
  gfv(gfu paramgfu) {}
  
  public boolean a(VipBannerInfo paramVipBannerInfo)
  {
    if ((paramVipBannerInfo != null) && (paramVipBannerInfo.a != null))
    {
      int m = paramVipBannerInfo.e;
      if ((1 == paramVipBannerInfo.a.iNewFlag.get()) && (1 == paramVipBannerInfo.f) && (!TextUtils.isEmpty(paramVipBannerInfo.b)) && (m >= 1) && (m <= 4))
      {
        int i;
        int j;
        label109:
        int k;
        if ((1 == m) && (!VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a)))
        {
          i = 1;
          if ((2 != m) || (VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
            break label230;
          }
          j = 1;
          if ((3 != m) || (!VipUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
            break label235;
          }
          k = 1;
          label134:
          if ((4 != m) || (!VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a))) {
            break label241;
          }
        }
        label230:
        label235:
        label241:
        for (m = 1;; m = 0)
        {
          if ((i == 0) && (j == 0) && (k == 0) && (m == 0)) {
            break label247;
          }
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
          Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(8, paramVipBannerInfo);
          localMessage.obj = paramVipBannerInfo;
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          return true;
          i = 0;
          break;
          j = 0;
          break label109;
          k = 0;
          break label134;
        }
      }
    }
    label247:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfv
 * JD-Core Version:    0.7.0.1
 */