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
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class eoc
  extends BizTroopObserver
{
  public eoc(TroopCreateLogic paramTroopCreateLogic) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
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
      TroopInfo localTroopInfo;
      String str;
      break label46;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(i, "", "");
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    return;
    if (paramObject == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    localTroopInfo = (TroopInfo)paramObject;
    str = localTroopInfo.troopuin;
    if (TextUtils.isEmpty(str))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    this.a.jdField_c_of_type_JavaLangString = str;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(TroopCreateLogic.a(this.a).jdField_c_of_type_Int), "", "");
    if (TextUtils.isEmpty(TroopCreateLogic.a(this.a).d)) {}
    for (paramObject = "no_place";; paramObject = "place")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "create_suc", paramObject, 0, 0, str, Integer.toString(TroopCreateLogic.a(this.a).jdField_c_of_type_Int), "", "");
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(str, (byte)1, 0L, 0);
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
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(0, str, localTroopInfo.troopname);
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
      this.a.a(localBaseActivity);
      return;
    }
    paramObject = (TroopCreateAdvanceData)paramObject;
    if (paramObject == null)
    {
      this.a.a();
      this.a.a(localBaseActivity);
      this.a.a(localBaseActivity);
      return;
    }
    if (!paramObject.a())
    {
      QQToast.a(localBaseActivity, localBaseActivity.getString(paramObject.a()), 1).b(localBaseActivity.getTitleBarHeight());
      this.a.a();
      this.a.a(localBaseActivity);
      return;
    }
    this.a.l = 2;
    TroopCreateLogic.a(this.a).a = paramObject;
    switch (this.a.m)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
      }
      TroopQQBrowserHelper.a(localBaseActivity, this.a.m);
    case 0: 
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidAppActivity = null;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
        }
        TroopQQBrowserHelper.a(localBaseActivity);
      }
    }
    if (("1".equals(this.a.b)) || ("0".equals(this.a.b)) || ("2".equals(this.a.b))) {
      if (QLog.isColorLevel())
      {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.a.m), this.a.b }));
        TroopQQBrowserHelper.b(localBaseActivity, this.a.b);
      }
    }
    for (;;)
    {
      localBaseActivity.finish();
      break;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.a.m) }));
      }
      TroopQQBrowserHelper.a(localBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eoc
 * JD-Core Version:    0.7.0.1
 */