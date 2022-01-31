import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class wem
  implements Runnable
{
  public wem(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.a(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.a.a.obtainMessage(1);
    localMessage.obj = localList;
    this.a.a.sendMessage(localMessage);
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wem
 * JD-Core Version:    0.7.0.1
 */