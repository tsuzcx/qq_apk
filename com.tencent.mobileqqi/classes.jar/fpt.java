import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.qphone.base.util.QLog;

public class fpt
  implements Runnable
{
  public fpt(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    Object localObject1 = ((FriendManager)this.a.b.getManager(8)).a(this.a.b.a());
    if (localObject1 != null)
    {
      localObject2 = new String[4];
      localObject2[0] = "-1";
      localObject2[1] = "-1";
      localObject2[2] = "-1";
      localObject2[3] = "-1";
    }
    while (!QLog.isColorLevel()) {
      try
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(((Card)localObject1).strCountry, ((Card)localObject1).strProvince, ((Card)localObject1).strCity);
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject1);
        Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
        localMessage.obj = new Object[] { localObject1, localObject2 };
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(ConditionSearchFriendActivity.c(), 2, "fillLocationData | exception: " + Log.getStackTraceString(localException));
            localObject1 = localObject2;
          }
        }
      }
    }
    QLog.d(ConditionSearchFriendActivity.c(), 2, "fillLocationData | card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpt
 * JD-Core Version:    0.7.0.1
 */