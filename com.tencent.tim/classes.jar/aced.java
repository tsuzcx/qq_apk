import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqConfig;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aced
  implements Manager
{
  private EqqConfig a;
  private ConcurrentHashMap<String, EqqDetail> dT;
  private EntityManager em;
  
  public aced(QQAppInterface paramQQAppInterface)
  {
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  public void DD(String paramString)
  {
    if (this.a == null) {
      this.a = new EqqConfig(paramString);
    }
    a(this.a);
  }
  
  public EqqDetail a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.dT == null) {
      return null;
    }
    return (EqqDetail)this.dT.get(paramString);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.em.update(paramEntity);
  }
  
  public void f(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {}
    do
    {
      return;
      a(paramEqqDetail);
      if (this.dT == null) {
        this.dT = new ConcurrentHashMap();
      }
    } while (paramEqqDetail.followType != 0);
    this.dT.put(paramEqqDetail.uin, paramEqqDetail);
  }
  
  public void g(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {}
    do
    {
      return;
      this.em.remove(paramEqqDetail);
      this.em.close();
    } while (this.dT == null);
    this.dT.remove(paramEqqDetail.uin);
  }
  
  public void onDestroy()
  {
    if (this.em != null) {
      this.em.close();
    }
  }
  
  public String ry()
  {
    String str2 = "";
    if (this.a == null)
    {
      List localList = this.em.query(EqqConfig.class);
      String str1 = str2;
      if (localList != null)
      {
        str1 = str2;
        if (localList.size() >= 1)
        {
          this.a = ((EqqConfig)localList.get(0));
          str1 = this.a.getData();
        }
      }
      return str1;
    }
    return this.a.getData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aced
 * JD-Core Version:    0.7.0.1
 */