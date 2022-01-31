import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class uvy
  implements uvi
{
  public long a;
  protected awgf a;
  protected String a;
  protected ConcurrentHashMap<Long, Long> a;
  protected boolean a;
  public String b;
  protected ConcurrentHashMap<Long, PromoteTaskEntry> b;
  
  public uvy()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaLangString = "";
  }
  
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
  
  public List<PromoteTaskEntry> a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wxe.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
      return Collections.emptyList();
    }
    List localList = this.jdField_a_of_type_Awgf.a(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "feedId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      a(localList, "findPromoteTaskListByFeedIdInner() returns");
      return localList;
    }
    wxe.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public List<PromoteTaskEntry> a(@NonNull List<String> paramList, int paramInt)
  {
    wxe.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIds(%s, %d)", paramList, Integer.valueOf(paramInt));
    a();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.addAll(a((String)paramList.get(i), paramInt));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    int j = 0;
    this.jdField_a_of_type_Awgf = QQStoryContext.a().a().createEntityManager();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject2 = new ArrayList();
    this.jdField_b_of_type_JavaLangString = ((String)((uvt)uwa.a(10)).b("key_story_player_promote_url", this.jdField_b_of_type_JavaLangString));
    wxe.a("StoryPromoteTaskManager", "onInit() mUrl = %s", this.jdField_b_of_type_JavaLangString);
    Object localObject1 = this.jdField_a_of_type_Awgf.a(PromoteTaskEntry.class);
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
      a((List)localObject1, "onInit() before delete expired local entries");
      if (!((List)localObject2).isEmpty())
      {
        a((List)localObject2);
        localObject1 = this.jdField_a_of_type_Awgf.a(PromoteTaskEntry.class);
      }
    }
    for (;;)
    {
      a((List)localObject1, "onInit() local entries");
      if (localObject1 != null)
      {
        i = j;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (PromoteTaskEntry)((List)localObject1).get(i);
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), localObject2);
          i += 1;
        }
      }
      if ((a()) && (localObject1 != null))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PromoteTaskEntry)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), Long.valueOf(((PromoteTaskEntry)localObject2).promoteCount));
        }
        wxe.a("StoryPromoteTaskManager", "onInit() update memory count from DB; %s", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      }
      return;
    }
  }
  
  void a(String paramString) {}
  
  void a(List<PromoteTaskEntry> paramList, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (this.jdField_a_of_type_Long > l)
    {
      wxe.a("StoryPromoteTaskManager", "refreshPromoteTask, time not expire now: %s(%d), expire: %s(%d), won't request!", xqz.a(l), Long.valueOf(l), xqz.a(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long));
      return;
    }
    wxe.a("StoryPromoteTaskManager", "refreshPromoteTask(clear=%b), time expire, will request new list, now: %d, expire: %d", Boolean.valueOf(paramBoolean), Long.valueOf(l), Long.valueOf(this.jdField_a_of_type_Long));
    if (paramBoolean) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    vgt localvgt = new vgt(this.jdField_a_of_type_JavaLangString);
    urp.a().a(localvgt, new uvz(this));
  }
  
  public boolean a()
  {
    Object localObject = (uvt)uwa.a(10);
    String str = xqz.a();
    if (TextUtils.equals((String)((uvt)localObject).b("key_story_promote_task_date", ""), str))
    {
      wxe.a("StoryPromoteTaskManager", "ensureCountValidate() date is %s, keep last promoteCount", str);
      return true;
    }
    wxe.a("StoryPromoteTaskManager", "ensureCountValidate() date is %s new date, so mTaskIdCounts should be empty, taskIdCounts=%s", str, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    ((uvt)localObject).b("key_story_promote_task_date", str);
    localObject = "update " + PromoteTaskEntry.class.getSimpleName() + " set promoteCount = 0";
    this.jdField_a_of_type_Awgf.b((String)localObject);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    wxe.a("StoryPromoteTaskManager", "ensureCountValidate() exec sql: taskEntry updated sql=%s", localObject);
    a("ensureCountValidate() after execSQL()");
    return false;
  }
  
  public boolean a(long paramLong)
  {
    wxe.a("StoryPromoteTaskManager", "markTaskIdPromoted(%s)", Long.valueOf(paramLong));
    return b((PromoteTaskEntry)this.jdField_a_of_type_Awgf.a(PromoteTaskEntry.class, "taskId = ?", new String[] { String.valueOf(paramLong) }));
  }
  
  public boolean a(PromoteTaskEntry paramPromoteTaskEntry)
  {
    boolean bool = true;
    if (paramPromoteTaskEntry.getStatus() == 1000)
    {
      this.jdField_a_of_type_Awgf.b(paramPromoteTaskEntry);
      if (paramPromoteTaskEntry.getStatus() != 1001) {}
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramPromoteTaskEntry.taskId), paramPromoteTaskEntry);
      wxe.a("StoryPromoteTaskManager", "updateEntry %s, return %b", paramPromoteTaskEntry, Boolean.valueOf(bool));
      return bool;
      bool = false;
      continue;
      if ((paramPromoteTaskEntry.getStatus() == 1001) || (paramPromoteTaskEntry.getStatus() == 1002))
      {
        bool = this.jdField_a_of_type_Awgf.a(paramPromoteTaskEntry);
      }
      else
      {
        wxe.e("StoryPromoteTaskManager", "updateEntry error: entry status unknown: %d", new Object[] { Integer.valueOf(paramPromoteTaskEntry.getStatus()) });
        bool = false;
      }
    }
  }
  
  public boolean a(qqstory_service.RspGetPromoteTaskList paramRspGetPromoteTaskList)
  {
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet());
    paramRspGetPromoteTaskList = paramRspGetPromoteTaskList.promote_tasks.get();
    int i = 0;
    if (i < paramRspGetPromoteTaskList.size())
    {
      Object localObject = uxg.a((qqstory_service.PromoteTask)paramRspGetPromoteTaskList.get(i));
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(((uxg)localObject).jdField_a_of_type_Long));
      if (localLong != null) {}
      for (((uxg)localObject).e = localLong.longValue();; ((uxg)localObject).e = 0L)
      {
        localArrayList.remove(Long.valueOf(((uxg)localObject).jdField_a_of_type_Long));
        localObject = ((uxg)localObject).a();
        a((PromoteTaskEntry)localObject);
        wxe.a("StoryPromoteTaskManager", "overwriteEntries() [%d] taskEntry updated %s", Integer.valueOf(i), localObject);
        i += 1;
        break;
      }
    }
    if (!localArrayList.isEmpty())
    {
      wxe.b("StoryPromoteTaskManager", "overwriteEntries() taskIds not empty, will delete it");
      a(localArrayList);
    }
    return true;
  }
  
  public boolean a(List<Long> paramList)
  {
    wxe.a("StoryPromoteTaskManager", "deleteListOfTasks(%s)", paramList);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
      }
      localObject = new Long[paramList.size()];
      paramList.toArray((Object[])localObject);
      paramList = a((Object[])localObject);
      paramList = "delete from " + PromoteTaskEntry.class.getSimpleName() + " where taskId in " + paramList;
      wxe.a("StoryPromoteTaskManager", "deleteListOfTasks() exec sql: taskEntry updated %s", paramList);
      return this.jdField_a_of_type_Awgf.b(paramList);
    }
    return false;
  }
  
  public List<PromoteTaskEntry> b(String paramString, int paramInt)
  {
    wxe.a("StoryPromoteTaskManager", "findPromoteTaskByUnionId(%s, %d)", paramString, Integer.valueOf(paramInt));
    a();
    List localList = this.jdField_a_of_type_Awgf.a(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "unionId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      a(localList, "findPromoteTaskListByUnionId() returns");
      return localList;
    }
    wxe.a("StoryPromoteTaskManager", "findPromoteTaskListByUnionId(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Awgf.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b(PromoteTaskEntry paramPromoteTaskEntry)
  {
    wxe.a("StoryPromoteTaskManager", "markEntryPromoted(%s)", paramPromoteTaskEntry);
    if (paramPromoteTaskEntry == null)
    {
      wxe.b("StoryPromoteTaskManager", "markEntryPromoted entry is null!");
      return false;
    }
    if (paramPromoteTaskEntry.promoteCount >= paramPromoteTaskEntry.limitPromoteCount)
    {
      wxe.e("StoryPromoteTaskManager", "Error: entry.promoteCount >= entry.limitPromoteCount");
      return false;
    }
    paramPromoteTaskEntry.promoteCount += 1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramPromoteTaskEntry.taskId), Long.valueOf(paramPromoteTaskEntry.promoteCount));
    a(paramPromoteTaskEntry);
    return true;
  }
  
  public void c()
  {
    ((uvt)uwa.a(10)).b("key_story_promote_task_date", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvy
 * JD-Core Version:    0.7.0.1
 */