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

public class vkj
  implements vki
{
  private List<vkh> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private vkk jdField_a_of_type_Vkk;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (vkh)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull vkh paramvkh, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramvkh.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramvkh.a(paramConcurrentHashMap);
    if (!paramvkh.a())
    {
      if (this.jdField_a_of_type_Vkk != null) {
        this.jdField_a_of_type_Vkk.b();
      }
      a();
      return;
    }
    if (paramvkh.jdField_a_of_type_Boolean)
    {
      paramvkh.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramvkh));
  }
  
  public vkj a(@NonNull vkh paramvkh)
  {
    paramvkh.jdField_a_of_type_Vki = this;
    this.jdField_a_of_type_JavaUtilList.add(paramvkh);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Vkk = null;
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
  
  public void a(@NonNull vkk paramvkk)
  {
    this.jdField_a_of_type_Vkk = paramvkk;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vkk != null) {
        this.jdField_a_of_type_Vkk.c();
      }
      a();
      return;
    }
    vkh localvkh = (vkh)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localvkh.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localvkh.a(localvkh.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localvkh));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localvkh));
      return;
    }
    if (this.jdField_a_of_type_Vkk != null) {
      this.jdField_a_of_type_Vkk.b();
    }
    localvkh.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vkk != null) {
        this.jdField_a_of_type_Vkk.c();
      }
      a();
    }
    vkh localvkh;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localvkh = (vkh)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Vkk != null) {
        this.jdField_a_of_type_Vkk.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localvkh));
    return;
    label108:
    if (this.jdField_a_of_type_Vkk != null) {
      this.jdField_a_of_type_Vkk.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkj
 * JD-Core Version:    0.7.0.1
 */