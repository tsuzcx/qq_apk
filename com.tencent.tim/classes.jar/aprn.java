import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aprn
  extends Observable
  implements Manager
{
  protected QQAppInterface app;
  protected EntityManager em;
  protected ConcurrentHashMap<String, TroopAioTopADInfo> iQ;
  
  public aprn(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
    if (this.iQ == null) {
      try
      {
        if (this.iQ == null) {
          this.iQ = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  public void TC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.iQ.remove(paramString);
      paramString = (TroopAioTopADInfo)this.em.find(TroopAioTopADInfo.class, paramString);
    } while (paramString == null);
    this.em.remove(paramString);
  }
  
  public TroopAioTopADInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (TroopAioTopADInfo)this.iQ.get(paramString);
  }
  
  public void onDestroy()
  {
    if ((this.em != null) && (this.em.isOpen())) {
      this.em.close();
    }
    if (this.iQ != null) {
      this.iQ.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprn
 * JD-Core Version:    0.7.0.1
 */