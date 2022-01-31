import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import mqq.app.MobileQQ;

public final class ygw
  implements Runnable
{
  public ygw(AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[checkJsonParse]");
      }
      Object localObject = (ApolloDaoManager)this.a.getManager(154);
      ApolloManager localApolloManager = (ApolloManager)this.a.getManager(152);
      List localList = ((ApolloDaoManager)localObject).a();
      boolean bool = this.a.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean("7.6.0" + this.a.getCurrentAccountUin(), false);
      if ((localList == null) || (localList.size() == 0) || (!bool))
      {
        localApolloManager.b();
        QLog.d("ApolloManager", 1, "[checkJsonParse] parse action json");
      }
      localObject = ((ApolloDaoManager)localObject).f();
      if (((localObject == null) || (((List)localObject).size() == 0)) && (new File(ApolloUtil.b).exists()))
      {
        localApolloManager.c();
        QLog.d("ApolloManager", 1, "[checkJsonParse] parse game json");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygw
 * JD-Core Version:    0.7.0.1
 */