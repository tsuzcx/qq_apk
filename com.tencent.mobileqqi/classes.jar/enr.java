import android.content.Intent;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class enr
  extends MessageObserver
{
  public enr(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_Boolean == true)) {
      return;
    }
    if (((Integer)paramObject).intValue() == 2)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b, false);
      return;
    }
    this.a.jdField_a_of_type_Boolean = true;
    if (((Integer)paramObject).intValue() == 0)
    {
      MainAssistObserver.a(this.a);
      return;
    }
    MainAssistObserver.b(this.a);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.", 2, "onPushRecommandDevLock.isSuccess=" + paramBoolean1 + " canCancel=" + paramBoolean2 + " words=" + paramString1);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while ((!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.isResume()) || (!paramBoolean1)) {
      return;
    }
    Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, DevlockPushActivity.class);
    localIntent.putExtra("canCancel", paramBoolean2);
    localIntent.putExtra("tipMsg", paramString1);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("secondTitle", paramString3);
    localIntent.putExtra("thirdTitle", paramString4);
    localIntent.putStringArrayListExtra("wordsList", paramArrayList);
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(localIntent);
  }
  
  protected void b(Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (paramObject == null)) {}
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      i = ((Integer)paramObject[0]).intValue();
      j = ((Integer)paramObject[1]).intValue();
      k = ((Integer)paramObject[2]).intValue();
    } while (paramObject.length < 3);
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "欧盟登录：" + i + "欧盟用户：" + j + "父母授权：" + k, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     enr
 * JD-Core Version:    0.7.0.1
 */