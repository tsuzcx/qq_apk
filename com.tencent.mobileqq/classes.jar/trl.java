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

public class trl
  implements trk
{
  private List<trj> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private trm jdField_a_of_type_Trm;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (trj)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull trj paramtrj, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramtrj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramtrj.a(paramConcurrentHashMap);
    if (!paramtrj.a())
    {
      if (this.jdField_a_of_type_Trm != null) {
        this.jdField_a_of_type_Trm.b();
      }
      a();
      return;
    }
    if (paramtrj.jdField_a_of_type_Boolean)
    {
      paramtrj.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramtrj));
  }
  
  public trl a(@NonNull trj paramtrj)
  {
    paramtrj.jdField_a_of_type_Trk = this;
    this.jdField_a_of_type_JavaUtilList.add(paramtrj);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Trm = null;
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
  
  public void a(@NonNull trm paramtrm)
  {
    this.jdField_a_of_type_Trm = paramtrm;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Trm != null) {
        this.jdField_a_of_type_Trm.c();
      }
      a();
      return;
    }
    trj localtrj = (trj)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localtrj.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localtrj.a(localtrj.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localtrj));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localtrj));
      return;
    }
    if (this.jdField_a_of_type_Trm != null) {
      this.jdField_a_of_type_Trm.b();
    }
    localtrj.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Trm != null) {
        this.jdField_a_of_type_Trm.c();
      }
      a();
    }
    trj localtrj;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localtrj = (trj)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Trm != null) {
        this.jdField_a_of_type_Trm.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localtrj));
    return;
    label108:
    if (this.jdField_a_of_type_Trm != null) {
      this.jdField_a_of_type_Trm.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trl
 * JD-Core Version:    0.7.0.1
 */