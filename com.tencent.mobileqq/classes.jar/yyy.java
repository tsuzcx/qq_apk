import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.List;
import mqq.os.MqqHandler;

public class yyy
  implements wxt
{
  public void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("city");
    this.jdField_a_of_type_Wxr.b();
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "getUserInfo : name -> " + str1 + ", phone -> " + str2 + ", city -> " + paramBundle);
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.a))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(str1)) {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.b))
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(str2)) {
        bool2 = false;
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.c)) && (TextUtils.isEmpty(paramBundle))) {}
    for (bool1 = false;; bool1 = bool2)
    {
      paramBundle = yyx.a(this.jdField_a_of_type_Yyx, str1, str2, paramBundle, this.jdField_a_of_type_JavaUtilList);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        yyx.a(this.jdField_a_of_type_Yyx, this.jdField_a_of_type_AndroidAppActivity, bool1, paramBundle, this.jdField_a_of_type_Yyz, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      ThreadManager.getUIHandler().post(new GdtUserInfoAuthorizationHelper.1.1(this, bool1, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyy
 * JD-Core Version:    0.7.0.1
 */