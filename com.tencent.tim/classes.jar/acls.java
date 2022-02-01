import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.manager.Manager;

public class acls
  implements Manager
{
  private EntityManager em;
  
  public acls(QQAppInterface paramQQAppInterface)
  {
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    return (ShortVideoUpInfo)this.em.find(ShortVideoUpInfo.class, paramString);
  }
  
  public boolean kr(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.em.remove(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acls
 * JD-Core Version:    0.7.0.1
 */