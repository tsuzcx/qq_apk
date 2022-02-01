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

public class qdi
  implements qdh.a
{
  private qdi.a a;
  Executor l = Executors.newSingleThreadExecutor();
  public volatile boolean mIsCancelled;
  private List<qdh> nJ = Collections.synchronizedList(new ArrayList());
  
  private void a(@NonNull qdh paramqdh, @NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    paramqdh.cb = paramConcurrentHashMap;
    paramqdh.M(paramConcurrentHashMap);
    if (!paramqdh.Jp())
    {
      if (this.a != null) {
        this.a.bnH();
      }
      onDestroy();
      return;
    }
    if (paramqdh.aCQ)
    {
      paramqdh.bnE();
      return;
    }
    this.l.execute(new JobExecutor.2(this, paramqdh));
  }
  
  private void c(@NonNull ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    if (this.nJ.isEmpty()) {
      return;
    }
    K(new JobExecutor.1(this, (qdh)this.nJ.get(0), paramConcurrentHashMap));
  }
  
  public void K(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public qdi a(@NonNull qdh paramqdh)
  {
    paramqdh.a = this;
    this.nJ.add(paramqdh);
    return this;
  }
  
  public void a(@NonNull qdi.a parama)
  {
    this.a = parama;
    c(new ConcurrentHashMap());
  }
  
  protected void onDestroy()
  {
    if ((this.nJ != null) && (!this.nJ.isEmpty())) {
      this.nJ.clear();
    }
    this.a = null;
  }
  
  public void sB(boolean paramBoolean)
  {
    if (this.mIsCancelled)
    {
      if (this.a != null) {
        this.a.bnI();
      }
      onDestroy();
      return;
    }
    qdh localqdh = (qdh)this.nJ.get(0);
    if (paramBoolean)
    {
      if (localqdh.aCR)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          localqdh.sz(localqdh.Jq());
          return;
        }
        ThreadManager.getUIHandler().post(new JobExecutor.3(this, localqdh));
        return;
      }
      this.l.execute(new JobExecutor.4(this, localqdh));
      return;
    }
    if (this.a != null) {
      this.a.bnH();
    }
    localqdh.sz(paramBoolean);
    onDestroy();
  }
  
  public void sz(boolean paramBoolean)
  {
    if (this.mIsCancelled)
    {
      if (this.a != null) {
        this.a.bnI();
      }
      onDestroy();
    }
    qdh localqdh;
    do
    {
      return;
      if (!paramBoolean) {
        break label108;
      }
      localqdh = (qdh)this.nJ.remove(0);
      if (!this.nJ.isEmpty()) {
        break;
      }
      if (this.a != null) {
        this.a.bnG();
      }
    } while (!this.nJ.isEmpty());
    onDestroy();
    return;
    ThreadManager.getUIHandler().post(new JobExecutor.5(this, localqdh));
    return;
    label108:
    if (this.a != null) {
      this.a.bnH();
    }
    onDestroy();
  }
  
  public static abstract interface a
  {
    public abstract void bnG();
    
    public abstract void bnH();
    
    public abstract void bnI();
  }
  
  public static class b
    implements qdi.a
  {
    private qci jdField_b_of_type_Qci;
    private qdk jdField_b_of_type_Qdk;
    
    public b(qci paramqci, qdk paramqdk)
    {
      this.jdField_b_of_type_Qci = paramqci;
      this.jdField_b_of_type_Qdk = paramqdk;
    }
    
    public void bnG()
    {
      if (this.jdField_b_of_type_Qci != null) {
        this.jdField_b_of_type_Qci.j(this.jdField_b_of_type_Qdk);
      }
    }
    
    public void bnH()
    {
      if (this.jdField_b_of_type_Qci != null) {
        this.jdField_b_of_type_Qci.k(this.jdField_b_of_type_Qdk);
      }
    }
    
    public void bnI()
    {
      if (this.jdField_b_of_type_Qci != null) {
        this.jdField_b_of_type_Qci.l(this.jdField_b_of_type_Qdk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdi
 * JD-Core Version:    0.7.0.1
 */