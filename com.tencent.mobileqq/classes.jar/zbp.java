import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class zbp
  implements Runnable
{
  public zbp(HotChatCenterManager paramHotChatCenterManager) {}
  
  public void run()
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (this.a.jdField_a_of_type_JavaUtilSet != null)
      {
        localObject1 = localObject3;
        if (this.a.jdField_a_of_type_JavaUtilSet.size() > 0) {
          localObject1 = this.a.jdField_a_of_type_JavaUtilSet.toArray();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        Object localObject2 = localObject3;
      }
    }
    if ((localObject1 != null) && (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
      SharedPreferencesHandler.a(this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit(), "hotchat_new_unread_list", (Object[])localObject1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zbp
 * JD-Core Version:    0.7.0.1
 */