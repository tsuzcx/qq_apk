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

public class tri
  implements trh
{
  private List<trg> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private trj jdField_a_of_type_Trj;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (trg)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull trg paramtrg, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramtrg.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramtrg.a(paramConcurrentHashMap);
    if (!paramtrg.a())
    {
      if (this.jdField_a_of_type_Trj != null) {
        this.jdField_a_of_type_Trj.b();
      }
      a();
      return;
    }
    if (paramtrg.jdField_a_of_type_Boolean)
    {
      paramtrg.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramtrg));
  }
  
  public tri a(@NonNull trg paramtrg)
  {
    paramtrg.jdField_a_of_type_Trh = this;
    this.jdField_a_of_type_JavaUtilList.add(paramtrg);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Trj = null;
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
  
  public void a(@NonNull trj paramtrj)
  {
    this.jdField_a_of_type_Trj = paramtrj;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Trj != null) {
        this.jdField_a_of_type_Trj.c();
      }
      a();
      return;
    }
    trg localtrg = (trg)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localtrg.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localtrg.a(localtrg.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localtrg));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localtrg));
      return;
    }
    if (this.jdField_a_of_type_Trj != null) {
      this.jdField_a_of_type_Trj.b();
    }
    localtrg.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Trj != null) {
        this.jdField_a_of_type_Trj.c();
      }
      a();
    }
    trg localtrg;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localtrg = (trg)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Trj != null) {
        this.jdField_a_of_type_Trj.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localtrg));
    return;
    label108:
    if (this.jdField_a_of_type_Trj != null) {
      this.jdField_a_of_type_Trj.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tri
 * JD-Core Version:    0.7.0.1
 */