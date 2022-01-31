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

public class vga
  implements vfz
{
  private List<vfy> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  Executor jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor();
  private vgb jdField_a_of_type_Vgb;
  public volatile boolean a;
  
  private void a(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    a(new JobExecutor.1(this, (vfy)this.jdField_a_of_type_JavaUtilList.get(0), paramConcurrentHashMap));
  }
  
  private void a(@NonNull vfy paramvfy, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramvfy.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    paramvfy.a(paramConcurrentHashMap);
    if (!paramvfy.a())
    {
      if (this.jdField_a_of_type_Vgb != null) {
        this.jdField_a_of_type_Vgb.b();
      }
      a();
      return;
    }
    if (paramvfy.jdField_a_of_type_Boolean)
    {
      paramvfy.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.2(this, paramvfy));
  }
  
  public vga a(@NonNull vfy paramvfy)
  {
    paramvfy.jdField_a_of_type_Vfz = this;
    this.jdField_a_of_type_JavaUtilList.add(paramvfy);
    return this;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_Vgb = null;
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
  
  public void a(@NonNull vgb paramvgb)
  {
    this.jdField_a_of_type_Vgb = paramvgb;
    a(new ConcurrentHashMap());
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vgb != null) {
        this.jdField_a_of_type_Vgb.c();
      }
      a();
      return;
    }
    vfy localvfy = (vfy)this.jdField_a_of_type_JavaUtilList.get(0);
    if (paramBoolean)
    {
      if (localvfy.b)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localvfy.a(localvfy.b());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localvfy));
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new JobExecutor.4(this, localvfy));
      return;
    }
    if (this.jdField_a_of_type_Vgb != null) {
      this.jdField_a_of_type_Vgb.b();
    }
    localvfy.a(paramBoolean);
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vgb != null) {
        this.jdField_a_of_type_Vgb.c();
      }
      a();
    }
    vfy localvfy;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localvfy = (vfy)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Vgb != null) {
        this.jdField_a_of_type_Vgb.a();
      }
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    a();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localvfy));
    return;
    label108:
    if (this.jdField_a_of_type_Vgb != null) {
      this.jdField_a_of_type_Vgb.b();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vga
 * JD-Core Version:    0.7.0.1
 */