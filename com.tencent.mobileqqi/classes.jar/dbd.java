import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class dbd
  implements Runnable
{
  public dbd(PublicAccountChatActivity paramPublicAccountChatActivity, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountChatActivity.b.a().createEntityManager();
      PublicAccountMenuEntity localPublicAccountMenuEntity = (PublicAccountMenuEntity)localEntityManager.a(PublicAccountMenuEntity.class, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountChatActivity.a.jdField_a_of_type_JavaLangString);
      if (localPublicAccountMenuEntity != null) {
        localEntityManager.b(localPublicAccountMenuEntity);
      }
      if (localEntityManager != null) {
        localEntityManager.a();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(PublicAccountChatActivity.e(), 4, localException.getMessage());
        }
      }
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dbd
 * JD-Core Version:    0.7.0.1
 */