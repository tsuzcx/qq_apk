import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopCreateAdvanceData;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Timer;

public class gzx
  extends BizTroopObserver
{
  public gzx(TroopCreateLogic paramTroopCreateLogic) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(TroopCreateLogic.a(this.a));
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback == null) {
      return;
    }
    int i = -1;
    if (!paramBoolean) {}
    try
    {
      j = ((TroopCreateLogic.TroopCreateResult)paramObject).b;
      i = j;
    }
    catch (Exception paramObject)
    {
      int j;
      label46:
      String str;
      break label46;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(i, "");
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    return;
    if (paramObject == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    str = ((TroopInfo)paramObject).troopuin;
    if (TextUtils.isEmpty(str))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    this.a.b = str;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(TroopCreateLogic.a(this.a).jdField_c_of_type_Int), "", "");
    if (TextUtils.isEmpty(TroopCreateLogic.a(this.a).d)) {}
    for (paramObject = "no_place";; paramObject = "place")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "create_suc", paramObject, 0, 0, str, Integer.toString(TroopCreateLogic.a(this.a).jdField_c_of_type_Int), "", "");
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(str, (byte)1, 0L, 0);
      paramObject = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(str);
      if (paramObject != null)
      {
        paramObject.dwGroupClassExt = TroopCreateLogic.a(this.a).jdField_c_of_type_Int;
        paramObject.mRichFingerMemo = TroopCreateLogic.a(this.a).jdField_c_of_type_JavaLangString;
        Object localObject = TroopCreateLogic.a(this.a).d.split("\\|");
        j = 0;
        i = 0;
        if (localObject.length == 4)
        {
          j = (int)(Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
          i = (int)(Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
        }
        paramObject.troopLat = j;
        paramObject.troopLon = i;
        localObject = (FriendsManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localObject != null) {
          ((FriendsManagerImp)localObject).b(paramObject);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(0, str);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
  }
  
  protected void j(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.a.jdField_a_of_type_JavaUtilTimer.cancel();
      this.a.jdField_a_of_type_JavaUtilTimer = null;
    }
    TroopCreateLogic.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(TroopCreateLogic.a(this.a));
    BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_AndroidAppActivity;
    if (localBaseActivity == null)
    {
      this.a.a();
      return;
    }
    if (!paramBoolean)
    {
      this.a.a();
      this.a.a(localBaseActivity);
      return;
    }
    paramObject = (TroopCreateAdvanceData)paramObject;
    if (paramObject == null)
    {
      this.a.a();
      this.a.a(localBaseActivity);
      return;
    }
    if (!paramObject.a())
    {
      QQToast.a(localBaseActivity, localBaseActivity.getString(paramObject.a()), 1).b(localBaseActivity.d());
      this.a.a();
      return;
    }
    this.a.k = 2;
    TroopCreateLogic.a(this.a).a = paramObject;
    if (this.a.l != 0) {
      TroopQQBrowserHelper.a(localBaseActivity, this.a.l);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidAppActivity = null;
      return;
      TroopQQBrowserHelper.a(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzx
 * JD-Core Version:    0.7.0.1
 */