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

public class xdv
  implements xdu
{
  private List<xdt> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private xdw jdField_a_of_type_Xdw;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (xdt)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull xdt paramxdt, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramxdt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramxdt.a(paramConcurrentHashMap);
    if (!paramxdt.a())
    {
      if (this.jdField_a_of_type_Xdw != null) {
        this.jdField_a_of_type_Xdw.b();
      }
      a();
      return;
    }
    if (paramxdt.jdField_a_of_type_Boolean)
    {
      paramxdt.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramxdt));
  }
  
  public xdv a(@NonNull xdt paramxdt)
  {
    paramxdt.jdField_a_of_type_Xdu = this;
    this.jdField_a_of_type_JavaUtilList.add(paramxdt);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Xdw = null;
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
  
  public void a(@NonNull xdw paramxdw)
  {
    this.jdField_a_of_type_Xdw = paramxdw;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xdw != null) {
        this.jdField_a_of_type_Xdw.c();
      }
      a();
      return;
    }
    xdt localxdt = (xdt)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localxdt.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localxdt.a(localxdt.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localxdt));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localxdt));
      return;
    }
    if (this.jdField_a_of_type_Xdw != null) {
      this.jdField_a_of_type_Xdw.b();
    }
    localxdt.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xdw != null) {
        this.jdField_a_of_type_Xdw.c();
      }
      a();
    }
    xdt localxdt;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localxdt = (xdt)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Xdw != null) {
        this.jdField_a_of_type_Xdw.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localxdt));
    return;
    label108:
    if (this.jdField_a_of_type_Xdw != null) {
      this.jdField_a_of_type_Xdw.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdv
 * JD-Core Version:    0.7.0.1
 */