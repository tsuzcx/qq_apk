import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class wmr
  implements Runnable
{
  public wmr(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
          ((LocalRedTouchManager)localObject3).a(100601, false);
          boolean bool1 = ((LocalRedTouchManager)localObject3).a(10015, false);
          boolean bool2 = ((LocalRedTouchManager)localObject3).a(10016, false);
          ((LocalRedTouchManager)localObject3).a(10012, false);
          localObject1 = localObject2;
          if (((LocalRedTouchManager)localObject3).a(((LocalRedTouchManager)localObject3).a(-3), true))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            localObject1 = localObject2;
            if ((bool1 | bool2))
            {
              MainAssistObserver.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
          }
        }
        Object localObject3 = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!((CardHandler)localObject3).b())
          {
            localObject1 = localObject2;
            if (((CardHandler)localObject3).a()) {
              localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
            }
          }
        }
        int i = ((NumRedPointManager)this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(63)).a(1);
        if (localObject1 != null) {
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
        }
        if (i > 0)
        {
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
          ((Message)localObject2).obj = localObject1;
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */