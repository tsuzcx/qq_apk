import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class psv
  implements psj
{
  protected ConcurrentHashMap<Long, Long> bW = new ConcurrentHashMap();
  protected ConcurrentHashMap<Long, PromoteTaskEntry> bX = new ConcurrentHashMap();
  protected boolean isDestroy;
  protected String mCookie = "";
  protected EntityManager mEntityManager;
  public long mExpireTime;
  public String mUrl = "";
  
  static <T> String a(T[] paramArrayOfT)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0)) {
      return "()";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    int j = paramArrayOfT.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfT[i]);
      localStringBuilder.append(", ");
      i += 1;
    }
    localStringBuilder.append(paramArrayOfT[j]);
    return ')';
  }
  
  public boolean IT()
  {
    Object localObject = (psr)psx.a(10);
    String str = roq.getDateString();
    if (TextUtils.equals((String)((psr)localObject).c("key_story_promote_task_date", ""), str))
    {
      ram.b("StoryPromoteTaskManager", "ensureCountValidate() date is %s, keep last promoteCount", str);
      return true;
    }
    ram.b("StoryPromoteTaskManager", "ensureCountValidate() date is %s new date, so mTaskIdCounts should be empty, taskIdCounts=%s", str, this.bW);
    ((psr)localObject).n("key_story_promote_task_date", str);
    localObject = "update " + PromoteTaskEntry.class.getSimpleName() + " set promoteCount = 0";
    this.mEntityManager.execSQL((String)localObject);
    this.bW.clear();
    ram.b("StoryPromoteTaskManager", "ensureCountValidate() exec sql: taskEntry updated sql=%s", localObject);
    ro("ensureCountValidate() after execSQL()");
    return false;
  }
  
  public boolean Q(List<Long> paramList)
  {
    ram.b("StoryPromoteTaskManager", "deleteListOfTasks(%s)", paramList);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        this.bX.remove(Long.valueOf(l));
        this.bW.remove(Long.valueOf(l));
      }
      localObject = new Long[paramList.size()];
      paramList.toArray((Object[])localObject);
      paramList = a((Object[])localObject);
      paramList = "delete from " + PromoteTaskEntry.class.getSimpleName() + " where taskId in " + paramList;
      ram.b("StoryPromoteTaskManager", "deleteListOfTasks() exec sql: taskEntry updated %s", paramList);
      return this.mEntityManager.execSQL(paramList);
    }
    return false;
  }
  
  public boolean a(PromoteTaskEntry paramPromoteTaskEntry)
  {
    boolean bool = true;
    if (paramPromoteTaskEntry.getStatus() == 1000)
    {
      this.mEntityManager.persistOrReplace(paramPromoteTaskEntry);
      if (paramPromoteTaskEntry.getStatus() != 1001) {}
    }
    for (;;)
    {
      this.bX.put(Long.valueOf(paramPromoteTaskEntry.taskId), paramPromoteTaskEntry);
      ram.b("StoryPromoteTaskManager", "updateEntry %s, return %b", paramPromoteTaskEntry, Boolean.valueOf(bool));
      return bool;
      bool = false;
      continue;
      if ((paramPromoteTaskEntry.getStatus() == 1001) || (paramPromoteTaskEntry.getStatus() == 1002))
      {
        bool = this.mEntityManager.update(paramPromoteTaskEntry);
      }
      else
      {
        ram.e("StoryPromoteTaskManager", "updateEntry error: entry status unknown: %d", new Object[] { Integer.valueOf(paramPromoteTaskEntry.getStatus()) });
        bool = false;
      }
    }
  }
  
  public boolean a(qqstory_service.RspGetPromoteTaskList paramRspGetPromoteTaskList)
  {
    ArrayList localArrayList = new ArrayList(this.bX.keySet());
    paramRspGetPromoteTaskList = paramRspGetPromoteTaskList.promote_tasks.get();
    int i = 0;
    if (i < paramRspGetPromoteTaskList.size())
    {
      Object localObject = pts.a((qqstory_service.PromoteTask)paramRspGetPromoteTaskList.get(i));
      Long localLong = (Long)this.bW.get(Long.valueOf(((pts)localObject).taskId));
      if (localLong != null) {}
      for (((pts)localObject).promoteCount = localLong.longValue();; ((pts)localObject).promoteCount = 0L)
      {
        localArrayList.remove(Long.valueOf(((pts)localObject).taskId));
        localObject = ((pts)localObject).a();
        a((PromoteTaskEntry)localObject);
        ram.b("StoryPromoteTaskManager", "overwriteEntries() [%d] taskEntry updated %s", Integer.valueOf(i), localObject);
        i += 1;
        break;
      }
    }
    if (!localArrayList.isEmpty())
    {
      ram.d("StoryPromoteTaskManager", "overwriteEntries() taskIds not empty, will delete it");
      Q(localArrayList);
    }
    return true;
  }
  
  public boolean aX(long paramLong)
  {
    ram.b("StoryPromoteTaskManager", "markTaskIdPromoted(%s)", Long.valueOf(paramLong));
    return b((PromoteTaskEntry)this.mEntityManager.find(PromoteTaskEntry.class, "taskId = ?", new String[] { String.valueOf(paramLong) }));
  }
  
  public boolean b(PromoteTaskEntry paramPromoteTaskEntry)
  {
    ram.b("StoryPromoteTaskManager", "markEntryPromoted(%s)", paramPromoteTaskEntry);
    if (paramPromoteTaskEntry == null)
    {
      ram.d("StoryPromoteTaskManager", "markEntryPromoted entry is null!");
      return false;
    }
    if (paramPromoteTaskEntry.promoteCount >= paramPromoteTaskEntry.limitPromoteCount)
    {
      ram.e("StoryPromoteTaskManager", "Error: entry.promoteCount >= entry.limitPromoteCount");
      return false;
    }
    paramPromoteTaskEntry.promoteCount += 1L;
    this.bW.put(Long.valueOf(paramPromoteTaskEntry.taskId), Long.valueOf(paramPromoteTaskEntry.promoteCount));
    a(paramPromoteTaskEntry);
    return true;
  }
  
  public void bmI()
  {
    ((psr)psx.a(10)).n("key_story_promote_task_date", "");
  }
  
  public List<PromoteTaskEntry> d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.b("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
      return Collections.emptyList();
    }
    List localList = this.mEntityManager.query(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "feedId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      m(localList, "findPromoteTaskListByFeedIdInner() returns");
      return localList;
    }
    ram.b("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public List<PromoteTaskEntry> e(String paramString, int paramInt)
  {
    ram.b("StoryPromoteTaskManager", "findPromoteTaskByUnionId(%s, %d)", paramString, Integer.valueOf(paramInt));
    IT();
    List localList = this.mEntityManager.query(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "unionId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      m(localList, "findPromoteTaskListByUnionId() returns");
      return localList;
    }
    ram.b("StoryPromoteTaskManager", "findPromoteTaskListByUnionId(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public List<PromoteTaskEntry> e(@NonNull List<String> paramList, int paramInt)
  {
    ram.b("StoryPromoteTaskManager", "findPromoteTaskListByFeedIds(%s, %d)", paramList, Integer.valueOf(paramInt));
    IT();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.addAll(d((String)paramList.get(i), paramInt));
      i += 1;
    }
    return localArrayList;
  }
  
  void m(List<PromoteTaskEntry> paramList, String paramString) {}
  
  public void onDestroy()
  {
    this.mEntityManager.close();
    this.isDestroy = true;
  }
  
  public void onInit()
  {
    int j = 0;
    this.mEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject2 = new ArrayList();
    this.mUrl = ((String)((psr)psx.a(10)).c("key_story_player_promote_url", this.mUrl));
    ram.b("StoryPromoteTaskManager", "onInit() mUrl = %s", this.mUrl);
    Object localObject1 = this.mEntityManager.query(PromoteTaskEntry.class);
    int i;
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        PromoteTaskEntry localPromoteTaskEntry = (PromoteTaskEntry)((List)localObject1).get(i);
        if (l > localPromoteTaskEntry.expireTime) {
          ((List)localObject2).add(Long.valueOf(localPromoteTaskEntry.taskId));
        }
        i += 1;
      }
      m((List)localObject1, "onInit() before delete expired local entries");
      if (!((List)localObject2).isEmpty())
      {
        Q((List)localObject2);
        localObject1 = this.mEntityManager.query(PromoteTaskEntry.class);
      }
    }
    for (;;)
    {
      m((List)localObject1, "onInit() local entries");
      if (localObject1 != null)
      {
        i = j;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (PromoteTaskEntry)((List)localObject1).get(i);
          this.bX.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), localObject2);
          i += 1;
        }
      }
      if ((IT()) && (localObject1 != null))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PromoteTaskEntry)((Iterator)localObject1).next();
          this.bW.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), Long.valueOf(((PromoteTaskEntry)localObject2).promoteCount));
        }
        ram.b("StoryPromoteTaskManager", "onInit() update memory count from DB; %s", this.bW);
      }
      return;
    }
  }
  
  void ro(String paramString) {}
  
  public void sk(boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (this.mExpireTime > l)
    {
      ram.a("StoryPromoteTaskManager", "refreshPromoteTask, time not expire now: %s(%d), expire: %s(%d), won't request!", roq.aH(l), Long.valueOf(l), roq.aH(this.mExpireTime), Long.valueOf(this.mExpireTime));
      return;
    }
    ram.a("StoryPromoteTaskManager", "refreshPromoteTask(clear=%b), time expire, will request new list, now: %d, expire: %d", Boolean.valueOf(paramBoolean), Long.valueOf(l), Long.valueOf(this.mExpireTime));
    if (paramBoolean) {
      this.mCookie = "";
    }
    pzw localpzw = new pzw(this.mCookie);
    ppv.a().a(localpzw, new psw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psv
 * JD-Core Version:    0.7.0.1
 */