import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class wgo
  implements Runnable
{
  public wgo(TroopChatPie paramTroopChatPie, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    String str;
    if (localObject == null) {
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        if (localObject == null) {
          break label117;
        }
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("Q.aio.TroopChatPie", 2, String.format("checkSelfInTroop %s %s", new Object[] { str, Boolean.valueOf(bool) }));
      localObject = BaseApplicationImpl.getContext();
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new wgp(this, (Context)localObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgo
 * JD-Core Version:    0.7.0.1
 */