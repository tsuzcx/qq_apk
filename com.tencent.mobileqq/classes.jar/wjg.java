import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.1;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.2;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.3;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.4;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.5;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import mqq.os.MqqHandler;

public class wjg
  implements wjf
{
  private List<wje> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private wjh jdField_a_of_type_Wjh;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (wje)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull wje paramwje, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramwje.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramwje.a(paramConcurrentHashMap);
    if (!paramwje.a())
    {
      if (this.jdField_a_of_type_Wjh != null) {
        this.jdField_a_of_type_Wjh.b();
      }
      a();
      return;
    }
    if (paramwje.jdField_a_of_type_Boolean)
    {
      paramwje.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramwje));
  }
  
  public wjg a(@NonNull wje paramwje)
  {
    paramwje.jdField_a_of_type_Wjf = this;
    this.jdField_a_of_type_JavaUtilList.add(paramwje);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Wjh = null;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public void a(@NonNull wjh paramwjh)
  {
    this.jdField_a_of_type_Wjh = paramwjh;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Wjh != null) {
        this.jdField_a_of_type_Wjh.c();
      }
      a();
      return;
    }
    wje localwje = (wje)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localwje.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localwje.a(localwje.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localwje));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localwje));
      return;
    }
    if (this.jdField_a_of_type_Wjh != null) {
      this.jdField_a_of_type_Wjh.b();
    }
    localwje.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Wjh != null) {
        this.jdField_a_of_type_Wjh.c();
      }
      a();
    }
    wje localwje;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localwje = (wje)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Wjh != null) {
        this.jdField_a_of_type_Wjh.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localwje));
    return;
    label108:
    if (this.jdField_a_of_type_Wjh != null) {
      this.jdField_a_of_type_Wjh.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjg
 * JD-Core Version:    0.7.0.1
 */