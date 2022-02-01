import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.onlinestatus.AutoReplyManager.1;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aktg
  implements Manager
{
  private List<AutoReplyText> Ep;
  private QQAppInterface app;
  private Object ed = new Object();
  private EntityManager em;
  
  public aktg(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
    dDq();
  }
  
  private void dDq()
  {
    ThreadManager.getFileThreadHandler().post(new AutoReplyManager.1(this));
  }
  
  public void Z(List<AutoReplyText> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject2 = null;
    ??? = null;
    for (;;)
    {
      try
      {
        localEntityTransaction = this.em.getTransaction();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.begin();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        this.em.drop(AutoReplyText.class);
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Iterator localIterator = paramList.iterator();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (!localIterator.hasNext()) {
          break label251;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localAutoReplyText = (AutoReplyText)localIterator.next();
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        if (localAutoReplyText.getTextId() != paramInt) {
          continue;
        }
        ??? = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localAutoReplyText.mCheckFlag = 1;
      }
      catch (Exception localException)
      {
        EntityTransaction localEntityTransaction;
        AutoReplyText localAutoReplyText;
        localObject2 = ???;
        localException.printStackTrace();
        localObject2 = ???;
        QLog.d("AutoReplyManager", 1, "updateAutoReplyList, exception: ", localException);
        if (??? == null) {
          continue;
        }
        ???.end();
        synchronized (this.ed)
        {
          if (this.Ep != null) {
            break label322;
          }
          this.Ep = new ArrayList();
          this.Ep.addAll(paramList);
          return;
        }
        ??? = localException;
        localObject2 = localException;
        localAutoReplyText.mCheckFlag = 0;
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        localObject2.end();
      }
      ??? = localEntityTransaction;
      localObject2 = localEntityTransaction;
      this.em.persistOrReplace(localAutoReplyText);
    }
    for (;;)
    {
      label251:
      ??? = localException;
      localObject2 = localException;
      localException.commit();
      ??? = localException;
      localObject2 = localException;
      if (QLog.isColorLevel())
      {
        ??? = localException;
        localObject2 = localException;
        QLog.d("AutoReplyManager", 2, String.format("updateAutoReplyListCache, textList: %s, selectId: %s", new Object[] { paramList, Integer.valueOf(paramInt) }));
      }
      if (localException != null)
      {
        localException.end();
        continue;
        label322:
        this.Ep.clear();
      }
    }
  }
  
  public AutoReplyText a()
  {
    Object localObject = null;
    List localList = fM();
    Iterator localIterator = localList.iterator();
    if (localIterator.hasNext())
    {
      AutoReplyText localAutoReplyText = (AutoReplyText)localIterator.next();
      if (!localAutoReplyText.isChecked()) {
        break label107;
      }
      localObject = localAutoReplyText;
    }
    label107:
    for (;;)
    {
      break;
      if (localObject == null)
      {
        localObject = (AutoReplyText)localList.get(0);
        QLog.d("AutoReplyManager", 1, "getCurrentAutoReplyText is null, default check index 0");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyManager", 2, "getCurrentAutoReplyText: " + localObject);
        }
        return localObject;
      }
    }
  }
  
  public List<AutoReplyText> fM()
  {
    if ((this.Ep != null) && (this.Ep.size() > 0)) {
      return new ArrayList(this.Ep);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AutoReplyText(acfp.m(2131702977), 0));
    localArrayList.add(new AutoReplyText(acfp.m(2131702976), 1));
    localArrayList.add(new AutoReplyText(acfp.m(2131702974), 2));
    localArrayList.add(new AutoReplyText(acfp.m(2131702975), 2147483647));
    ((AutoReplyText)localArrayList.get(0)).mCheckFlag = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "getAutoReplyCache, buffList == null");
    }
    dDq();
    return localArrayList;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoReplyManager", 2, "AutoReplyManager onDestroy");
    }
    this.em.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktg
 * JD-Core Version:    0.7.0.1
 */