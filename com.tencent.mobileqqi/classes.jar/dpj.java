import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class dpj
  extends FriendListObserver
{
  public dpj(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))) {
      return;
    }
    this.a.jdField_b_of_type_Boolean = false;
    Object localObject = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendManager)localObject).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q = ((String)localObject);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.troopinfo", 2, "onUpdateFriendInfo|uin = " + paramString + ", tmpNickName = " + (String)localObject);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpj
 * JD-Core Version:    0.7.0.1
 */