import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class cwq
  implements Runnable
{
  public cwq(StrangerHandler paramStrangerHandler) {}
  
  public void run()
  {
    Object localObject = this.a.a.a().createEntityManager();
    List localList = ((EntityManager)localObject).a(Stranger.class);
    ((EntityManager)localObject).a();
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    this.a.a(3, true, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwq
 * JD-Core Version:    0.7.0.1
 */