import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.tim.todo.TodoManager.3;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class auoi
  implements Manager
{
  private static Comparator<aupm> ap = new auoj();
  private static Comparator<aupm> aq = new auok();
  private boolean aEH;
  private QQAppInterface app;
  private long ayV = -1L;
  private String cII = "";
  private EntityManager em;
  private int erO;
  private ConcurrentHashMap<String, aupm> jR = new ConcurrentHashMap();
  private ConcurrentHashMap<String, aupm> jS = new ConcurrentHashMap();
  
  public auoi(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  public String Ff()
  {
    return this.cII;
  }
  
  public int OK()
  {
    return this.app.getApplication().getSharedPreferences("sp_todo_" + this.app.getCurrentAccountUin(), 0).getInt("finished_todo_count", 0);
  }
  
  public int OL()
  {
    return this.erO;
  }
  
  public void Zu(String paramString)
  {
    this.cII = paramString;
  }
  
  public void aaS(int paramInt)
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("sp_todo_" + this.app.getCurrentAccountUin(), 0);
    localSharedPreferences.edit().putInt("finished_todo_count", paramInt);
    localSharedPreferences.edit().commit();
  }
  
  public void aaT(int paramInt)
  {
    this.erO = paramInt;
    aaS(paramInt);
  }
  
  public ArrayList<TodoInfo> et()
  {
    if (!this.aEH) {
      init();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jR != null)
    {
      Iterator localIterator = this.jR.values().iterator();
      while (localIterator.hasNext())
      {
        TodoInfo localTodoInfo = (TodoInfo)localIterator.next();
        if ((localTodoInfo != null) && (localTodoInfo.status == 1)) {
          localArrayList.add(localTodoInfo);
        }
      }
    }
    Collections.sort(localArrayList, ap);
    return localArrayList;
  }
  
  public ArrayList<TodoInfo> eu()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jS != null)
    {
      Iterator localIterator = this.jS.values().iterator();
      while (localIterator.hasNext())
      {
        TodoInfo localTodoInfo = (TodoInfo)localIterator.next();
        if ((localTodoInfo != null) && (localTodoInfo.status == 2)) {
          localArrayList.add(localTodoInfo);
        }
      }
    }
    Collections.sort(localArrayList, aq);
    return localArrayList;
  }
  
  public void evO()
  {
    this.aEH = false;
    if (this.jR != null) {
      this.jR.clear();
    }
    localObject3 = null;
    localObject1 = null;
    do
    {
      try
      {
        localEntityTransaction = this.em.getTransaction();
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        localEntityTransaction.begin();
        localObject1 = localEntityTransaction;
        localObject3 = localEntityTransaction;
        boolean bool = this.em.isOpen();
        if (!bool) {
          return;
        }
      }
      catch (Exception localException)
      {
        EntityTransaction localEntityTransaction;
        localObject3 = localObject1;
        localException.printStackTrace();
        return;
      }
      finally
      {
        if (localObject3 == null) {
          break;
        }
        localObject3.end();
      }
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      this.em.drop(TodoInfo.class.getSimpleName());
      localObject1 = localEntityTransaction;
      localObject3 = localEntityTransaction;
      localEntityTransaction.commit();
    } while (localEntityTransaction == null);
    localEntityTransaction.end();
  }
  
  public void evP()
  {
    if (this.jS != null) {
      this.jS.clear();
    }
  }
  
  public long iD()
  {
    return this.ayV;
  }
  
  public long iE()
  {
    return this.app.getApplication().getSharedPreferences("sp_todo_" + this.app.getCurrentAccountUin(), 0).getLong("sp_todo_last_read_time", 0L);
  }
  
  public void init()
  {
    if (this.aEH) {
      return;
    }
    this.jR.clear();
    List localList = this.em.query(TodoInfo.class, false, null, null, null, null, "createTime desc", null);
    Object localObject;
    if ((localList != null) && (localList.size() > 0))
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TodoInfo localTodoInfo = (TodoInfo)((Iterator)localObject).next();
        if (localTodoInfo.status == 1) {
          this.jR.put(localTodoInfo.todoId, localTodoInfo);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("TodoManagerInitDB:");
      if (localList == null) {
        break label160;
      }
    }
    label160:
    for (int i = localList.size();; i = 0)
    {
      QLog.i("TodoManager", 0, i);
      this.erO = OK();
      this.aEH = true;
      return;
    }
  }
  
  public void nu(long paramLong)
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("sp_todo_" + this.app.getCurrentAccountUin(), 0);
    localSharedPreferences.edit().putLong("sp_todo_last_read_time", paramLong);
    localSharedPreferences.edit().commit();
  }
  
  public void nv(long paramLong)
  {
    this.ayV = paramLong;
  }
  
  public void oe(List<Pair<Integer, TodoInfo>> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (Pair)paramList.next();
        if ((localObject != null) && (((Pair)localObject).second != null))
        {
          int i = ((Integer)((Pair)localObject).first).intValue();
          localObject = (TodoInfo)((Pair)localObject).second;
          switch (i)
          {
          default: 
            break;
          case 1: 
            this.jS.put(((TodoInfo)localObject).todoId, localObject);
            break;
          case 2: 
            this.jS.remove(((TodoInfo)localObject).todoId);
          }
        }
      }
    }
  }
  
  public void of(List<Pair<Integer, TodoInfo>> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    og(paramList);
    oh(paramList);
  }
  
  public void og(List<Pair<Integer, TodoInfo>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        int i = ((Integer)((Pair)localObject).first).intValue();
        localObject = (TodoInfo)((Pair)localObject).second;
        if (QLog.isColorLevel()) {
          QLog.i("TodoManager", 0, "updateUndoneTodoForCache id:" + ((TodoInfo)localObject).todoId + ", status;" + i + ", infoStatus:" + ((TodoInfo)localObject).status);
        }
        switch (i)
        {
        default: 
          break;
        case 1: 
        case 2: 
          this.jR.put(((TodoInfo)localObject).todoId, localObject);
          break;
        case 3: 
        case 4: 
          this.jR.remove(((TodoInfo)localObject).todoId);
        }
      }
    }
  }
  
  public void oh(List<Pair<Integer, TodoInfo>> paramList)
  {
    ThreadManager.postImmediately(new TodoManager.3(this, paramList), null, true);
  }
  
  public void onDestroy()
  {
    this.em.close();
  }
  
  public boolean sX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jR.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public boolean sY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jR.get(paramString) != null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoi
 * JD-Core Version:    0.7.0.1
 */