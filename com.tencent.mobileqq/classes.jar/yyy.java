import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class yyy
  implements Runnable
{
  public yyy(SpriteUIHandler paramSpriteUIHandler, int paramInt) {}
  
  public void run()
  {
    try
    {
      MqqHandler localMqqHandler = SpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler).a().a();
      if (1 == this.jdField_a_of_type_Int)
      {
        localMqqHandler.obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F / 2.84D) + 40, 0).sendToTarget();
        return;
      }
      if (2 == this.jdField_a_of_type_Int)
      {
        localMqqHandler.obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F) + 40, 0).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, localException, new Object[0]);
      return;
    }
    if (3 == this.jdField_a_of_type_Int) {
      localException.sendEmptyMessage(62);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyy
 * JD-Core Version:    0.7.0.1
 */