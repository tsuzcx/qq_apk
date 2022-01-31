import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.qphone.base.util.QLog;

public class guu
  extends MessageObserver
{
  public guu(NearbyOpenTroop paramNearbyOpenTroop) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    int j = k;
    int i;
    if (paramArrayOfString != null) {
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) {
          j = 1;
        }
      }
      else
      {
        if (j != 0)
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a(this.a.jdField_a_of_type_JavaLangString, true))
          {
            NearbyOpenTroop.b(this.a);
            if (QLog.isColorLevel()) {
              QLog.d("EnterTroopTipsMsg", 2, "显示拉群活动失败，直接生成tips");
            }
            NearbyOpenTroop.a(this.a);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     guu
 * JD-Core Version:    0.7.0.1
 */