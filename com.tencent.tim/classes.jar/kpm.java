import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.SyncSteps.2;
import java.util.Collections;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public final class kpm
  extends kpi
  implements kpl
{
  private final kpi[] a;
  private LinkedList w;
  
  public kpm(@NotNull kph paramkph, @NotNull kpi[] paramArrayOfkpi)
  {
    super(paramkph, false, "SyncSteps");
    this.a = paramArrayOfkpi;
    this.w = new LinkedList();
    int j = paramArrayOfkpi.length;
    j = paramArrayOfkpi.length;
    while (i < j)
    {
      paramArrayOfkpi[i].a(this);
      i += 1;
    }
    Collections.addAll(this.w, paramArrayOfkpi);
  }
  
  public boolean Ai()
  {
    super.Ai();
    this.w.clear();
    Collections.addAll(this.w, this.a);
    return true;
  }
  
  public boolean Aj()
  {
    aFK();
    return false;
  }
  
  public final void aFK()
  {
    if (!this.w.isEmpty())
    {
      Object localObject = (kpi)this.w.removeFirst();
      if (((kpi)localObject).Ai())
      {
        SyncSteps.1 local1 = new SyncSteps.1(this, (kpi)localObject);
        if (((kpi)localObject).isRunOnUIThread())
        {
          local1.run();
          return;
        }
        localObject = a().a();
        if (localObject != null)
        {
          ((kpk)localObject).execute(local1);
          return;
        }
        new Thread(local1).start();
        return;
      }
      a().runOnUiThread(new SyncSteps.2(this, (kpi)localObject));
      return;
    }
    aFM();
  }
  
  public void onStop()
  {
    super.onStop();
    kpi[] arrayOfkpi = this.a;
    int j = arrayOfkpi.length;
    int i = 0;
    while (i < j)
    {
      arrayOfkpi[i].onStop();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpm
 * JD-Core Version:    0.7.0.1
 */