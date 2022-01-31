import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class xri
  implements Runnable
{
  public xri(RecentOptPopBar paramRecentOptPopBar, View paramView) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a(this.jdField_a_of_type_AndroidViewView);
    CmGameUtil.b(2);
    Object localObject = (ApolloManager)CmGameUtil.a().getManager(152);
    if (localObject == null) {
      return;
    }
    ((ApolloManager)localObject).j = true;
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    CmGameUtil.a().getCurrentAccountUin();
    ((SharedPreferences)localObject).edit().putBoolean("is_new_user_bar_showed" + CmGameUtil.a().getCurrentAccountUin(), true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */