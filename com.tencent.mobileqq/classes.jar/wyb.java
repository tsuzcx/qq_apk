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

public class wyb
  implements wya
{
  private List<wxz> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private wyc jdField_a_of_type_Wyc;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (wxz)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull wxz paramwxz, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramwxz.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramwxz.a(paramConcurrentHashMap);
    if (!paramwxz.a())
    {
      if (this.jdField_a_of_type_Wyc != null) {
        this.jdField_a_of_type_Wyc.b();
      }
      a();
      return;
    }
    if (paramwxz.jdField_a_of_type_Boolean)
    {
      paramwxz.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramwxz));
  }
  
  public wyb a(@NonNull wxz paramwxz)
  {
    paramwxz.jdField_a_of_type_Wya = this;
    this.jdField_a_of_type_JavaUtilList.add(paramwxz);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Wyc = null;
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
  
  public void a(@NonNull wyc paramwyc)
  {
    this.jdField_a_of_type_Wyc = paramwyc;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Wyc != null) {
        this.jdField_a_of_type_Wyc.c();
      }
      a();
      return;
    }
    wxz localwxz = (wxz)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localwxz.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localwxz.a(localwxz.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localwxz));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localwxz));
      return;
    }
    if (this.jdField_a_of_type_Wyc != null) {
      this.jdField_a_of_type_Wyc.b();
    }
    localwxz.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Wyc != null) {
        this.jdField_a_of_type_Wyc.c();
      }
      a();
    }
    wxz localwxz;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localwxz = (wxz)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Wyc != null) {
        this.jdField_a_of_type_Wyc.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localwxz));
    return;
    label108:
    if (this.jdField_a_of_type_Wyc != null) {
      this.jdField_a_of_type_Wyc.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyb
 * JD-Core Version:    0.7.0.1
 */