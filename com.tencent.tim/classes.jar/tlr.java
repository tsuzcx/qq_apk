import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.List;
import mqq.os.MqqHandler;

public class tlr
  implements skj.a
{
  public void callback(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("city");
    this.b.bzk();
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "getUserInfo : name -> " + str1 + ", phone -> " + str2 + ", city -> " + paramBundle);
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.pU.contains(AuthorizationItem.a))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(str1)) {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (this.pU.contains(AuthorizationItem.b))
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(str2)) {
        bool2 = false;
      }
    }
    if ((this.pU.contains(AuthorizationItem.c)) && (TextUtils.isEmpty(paramBundle))) {}
    for (bool1 = false;; bool1 = bool2)
    {
      paramBundle = tlq.a(this.jdField_a_of_type_Tlq, str1, str2, paramBundle, this.pU);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        tlq.a(this.jdField_a_of_type_Tlq, this.val$context, bool1, paramBundle, this.jdField_a_of_type_Tlq$a, this.pU);
        return;
      }
      ThreadManager.getUIHandler().post(new GdtUserInfoAuthorizationHelper.1.1(this, bool1, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlr
 * JD-Core Version:    0.7.0.1
 */