import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.1;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.3;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.4;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.5;
import com.tencent.biz.pubaccount.readinjoy.automator.Automator.6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class kph
{
  @Nullable
  private kpj jdField_a_of_type_Kpj;
  @Nullable
  private kpk jdField_a_of_type_Kpk;
  @Nullable
  private Runnable cB;
  private ArrayList<kpi> kk = new ArrayList();
  private final Handler uiHandler = new Handler(Looper.getMainLooper());
  private final LinkedList<kpi> v = new LinkedList();
  
  private void aFK()
  {
    if (!this.v.isEmpty())
    {
      localObject = (kpi)this.v.removeFirst();
      if (((kpi)localObject).Ai())
      {
        local4 = new Automator.4(this, (kpi)localObject);
        if (((kpi)localObject).isRunOnUIThread()) {
          local4.run();
        }
      }
    }
    while (this.cB == null)
    {
      Automator.4 local4;
      return;
      Object localObject = this.jdField_a_of_type_Kpk;
      if (localObject != null)
      {
        ((kpk)localObject).execute(local4);
        return;
      }
      new Thread(local4).start();
      return;
      runOnUiThread(new Automator.5(this, (kpi)localObject));
      return;
    }
    this.cB.run();
  }
  
  public final void E(@Nullable Runnable paramRunnable)
  {
    this.cB = paramRunnable;
  }
  
  @Nullable
  public final kpj a()
  {
    return this.jdField_a_of_type_Kpj;
  }
  
  @Nullable
  public final kpk a()
  {
    return this.jdField_a_of_type_Kpk;
  }
  
  public final void a(@NotNull kpi paramkpi)
  {
    runOnUiThread(new Automator.6(this, paramkpi));
  }
  
  public final void a(@Nullable kpj paramkpj)
  {
    this.jdField_a_of_type_Kpj = paramkpj;
  }
  
  public final void a(@Nullable kpk paramkpk)
  {
    this.jdField_a_of_type_Kpk = paramkpk;
  }
  
  public final void a(@NotNull kpi[] paramArrayOfkpi, boolean paramBoolean)
  {
    runOnUiThread(new Automator.1(this, paramArrayOfkpi, paramBoolean));
  }
  
  public final void aFJ()
  {
    runOnUiThread(new Automator.3(this));
  }
  
  public final void aFL()
  {
    Iterator localIterator = this.kk.iterator();
    while (localIterator.hasNext()) {
      ((kpi)localIterator.next()).onStop();
    }
  }
  
  public void runOnUiThread(@NotNull Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    this.uiHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kph
 * JD-Core Version:    0.7.0.1
 */