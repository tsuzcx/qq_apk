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

public class xhq
  implements xhp
{
  private List<xho> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private xhr jdField_a_of_type_Xhr;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (xho)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull xho paramxho, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramxho.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramxho.a(paramConcurrentHashMap);
    if (!paramxho.a())
    {
      if (this.jdField_a_of_type_Xhr != null) {
        this.jdField_a_of_type_Xhr.b();
      }
      a();
      return;
    }
    if (paramxho.jdField_a_of_type_Boolean)
    {
      paramxho.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramxho));
  }
  
  public xhq a(@NonNull xho paramxho)
  {
    paramxho.jdField_a_of_type_Xhp = this;
    this.jdField_a_of_type_JavaUtilList.add(paramxho);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Xhr = null;
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
  
  public void a(@NonNull xhr paramxhr)
  {
    this.jdField_a_of_type_Xhr = paramxhr;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xhr != null) {
        this.jdField_a_of_type_Xhr.c();
      }
      a();
      return;
    }
    xho localxho = (xho)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localxho.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localxho.a(localxho.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localxho));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localxho));
      return;
    }
    if (this.jdField_a_of_type_Xhr != null) {
      this.jdField_a_of_type_Xhr.b();
    }
    localxho.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xhr != null) {
        this.jdField_a_of_type_Xhr.c();
      }
      a();
    }
    xho localxho;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localxho = (xho)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Xhr != null) {
        this.jdField_a_of_type_Xhr.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localxho));
    return;
    label108:
    if (this.jdField_a_of_type_Xhr != null) {
      this.jdField_a_of_type_Xhr.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhq
 * JD-Core Version:    0.7.0.1
 */