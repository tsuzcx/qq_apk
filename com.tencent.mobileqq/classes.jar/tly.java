import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class tly
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private tly(tlx paramtlx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + tlx.a(this.jdField_a_of_type_Tlx));
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + tlx.a(this.jdField_a_of_type_Tlx));
            }
          } while (tlx.a(this.jdField_a_of_type_Tlx) != 2);
          this.jdField_a_of_type_Tlx.a();
          this.jdField_a_of_type_Tlx.c();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + tlx.a(this.jdField_a_of_type_Tlx));
        }
      } while ((tlx.a(this.jdField_a_of_type_Tlx) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_Tlx.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */