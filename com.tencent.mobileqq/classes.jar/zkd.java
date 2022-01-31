import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;

public class zkd
  implements Runnable
{
  public zkd(FavEmoRoamingHandler paramFavEmoRoamingHandler, faceroam_sso.RspUserInfo paramRspUserInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      FileUtils.c(AppConstants.aV + ".nomedia");
      List localList1 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.filename.get();
      List localList2 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.delete_file.get();
      List localList3 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.uint32_emoji_type.get();
      Object localObject = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.bid.get();
      int j = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.max_roam_size.get();
      FavEmoConstant.a = j;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler.b.getCurrentAccountUin();
      if (!TextUtils.isEmpty(str)) {
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("fav_roaming_max" + str, j).apply();
      }
      int i;
      if (localList1 != null)
      {
        i = localList1.size();
        if (i > FavEmoConstant.a)
        {
          FavEmoConstant.b = i;
          label175:
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "local max size:" + FavEmoConstant.a + ",server max size:" + FavEmoConstant.b + ",delListSize=" + localList2.size() + ",fileListSize=" + localList1.size());
          }
          if ((QLog.isColorLevel()) && (localList1 != null) && (localList2 != null)) {
            QLog.d("FavEmoRoamingHandler", 2, "ret = " + this.jdField_a_of_type_Long + " userlist= " + localList1.toString() + " delList=" + localList2.toString() + " bid=" + (String)localObject + " local_max =" + j);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label450;
          }
          localObject = "qq_expression";
        }
      }
      for (;;)
      {
        FavEmoRoamingHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler, localList2, localList1);
        localList1 = ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler.b.getManager(148)).a(localList2, localList1, (String)localObject, localList3);
        localObject = localList1;
        if (localList1 == null) {
          localObject = new ArrayList();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler.a(1, true, localObject);
        return;
        i = FavEmoConstant.a;
        break;
        FavEmoConstant.b = FavEmoConstant.a;
        break label175;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet error", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom2");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkd
 * JD-Core Version:    0.7.0.1
 */