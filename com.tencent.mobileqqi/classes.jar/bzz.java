import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public final class bzz
  extends AsyncTask
{
  public bzz(QQAppInterface paramQQAppInterface, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    paramVarArgs = localList;
    if (localList == null) {
      paramVarArgs = new ArrayList();
    }
    if (ChatActivityFacade.a(paramVarArgs, 3, 0, this.jdField_a_of_type_JavaLangString) < 0) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEntityManager, 3, 0, this.jdField_a_of_type_JavaLangString, paramVarArgs);
    }
    localEntityManager.a();
    return null;
  }
  
  protected void a(Void paramVoid) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzz
 * JD-Core Version:    0.7.0.1
 */