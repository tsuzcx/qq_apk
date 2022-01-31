import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class flk
  implements Runnable
{
  public flk(StrangerHandler paramStrangerHandler) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flk
 * JD-Core Version:    0.7.0.1
 */