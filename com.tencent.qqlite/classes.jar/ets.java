import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ets
  extends TroopObserver
{
  public ets(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((TroopShareUtility.a(this.a) == null) || (TroopShareUtility.a(this.a).c == null) || (paramTroopShareResp == null) || (!TroopShareUtility.a(this.a).c.equals(paramTroopShareResp.jdField_a_of_type_JavaLangString))) {
      if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      }
    }
    label250:
    label634:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((TroopShareUtility.a(this.a) == null) || (!TroopShareUtility.a(this.a).isShowing()) || (TroopShareUtility.a(this.a) == -1) || (TroopShareUtility.b(this.a) == -1)) {
                  break label634;
                }
                if ((!paramBoolean) || (paramTroopShareResp.jdField_a_of_type_Int != 0)) {
                  break label455;
                }
                if (!paramTroopShareResp.jdField_a_of_type_Boolean) {
                  break;
                }
                TroopShareUtility.a(this.a, paramTroopShareResp.b);
                if (TroopShareUtility.b(this.a) == 0) {
                  break label250;
                }
              } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
              ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
              return;
              TroopShareUtility.b(this.a, paramTroopShareResp.b);
              if (TroopShareUtility.b(this.a) == 1) {
                break;
              }
            } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
            ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
            return;
            switch (TroopShareUtility.a(this.a))
            {
            default: 
              return;
            case 0: 
              QQAppInterface localQQAppInterface = (QQAppInterface)TroopShareUtility.a(this.a).getAppRuntime();
              String str = localQQAppInterface.a(4, 3000, TroopShareUtility.a(this.a).c);
              Setting localSetting = localQQAppInterface.a(str);
              paramTroopShareResp = localSetting;
              if (localSetting == null) {
                paramTroopShareResp = localQQAppInterface.b(str);
              }
              if (paramTroopShareResp != null) {
                TroopShareUtility.c(this.a, paramTroopShareResp.url);
              }
              if (TroopShareUtility.a(this.a) == null) {
                ((FriendListHandler)localQQAppInterface.a(1)).c(TroopShareUtility.a(this.a).c);
              }
              this.a.b();
              TroopShareUtility.d(this.a);
              return;
            case 2: 
              this.a.b();
              TroopShareUtility.b(this.a);
              return;
            case 1: 
              this.a.b();
              TroopShareUtility.c(this.a);
              return;
            }
            this.a.b();
            TroopShareUtility.e(this.a);
            return;
            if ((!paramTroopShareResp.jdField_a_of_type_Boolean) || (TroopShareUtility.b(this.a) == 0)) {
              break;
            }
          } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
          ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
          return;
          if ((paramTroopShareResp.jdField_a_of_type_Boolean) || (TroopShareUtility.b(this.a) == 1)) {
            break;
          }
        } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
        ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
        return;
        this.a.b();
        QQToast.a(TroopShareUtility.a(this.a), 1, TroopShareUtility.a(this.a).getString(2131363716), 0).b(TroopShareUtility.a(this.a).getTitleBarHeight());
        TroopShareUtility.a(this.a, -1);
        TroopShareUtility.b(this.a, -1);
      } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
      ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      return;
    } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
    label455:
    ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ets
 * JD-Core Version:    0.7.0.1
 */