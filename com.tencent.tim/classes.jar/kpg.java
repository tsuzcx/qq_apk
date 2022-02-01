import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.1;
import com.tencent.biz.pubaccount.readinjoy.automator.AsyncSteps.2;
import org.jetbrains.annotations.NotNull;

public final class kpg
  extends kpi
  implements kpl
{
  private final kpi[] a;
  private int aKW;
  
  public kpg(@NotNull kph paramkph, @NotNull kpi[] paramArrayOfkpi)
  {
    super(paramkph, false, "AsyncSteps");
    this.a = paramArrayOfkpi;
    paramkph = this.a;
    int j = paramkph.length;
    while (i < j)
    {
      paramkph[i].a(this);
      i += 1;
    }
  }
  
  public boolean Ai()
  {
    super.Ai();
    this.aKW = 0;
    return true;
  }
  
  public boolean Aj()
  {
    kpi[] arrayOfkpi = this.a;
    int j = arrayOfkpi.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfkpi[i];
      AsyncSteps.1 local1;
      if (((kpi)localObject).Ai())
      {
        local1 = new AsyncSteps.1(this, (kpi)localObject);
        if (((kpi)localObject).isRunOnUIThread()) {
          local1.run();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = a().a();
        if (localObject != null)
        {
          ((kpk)localObject).execute(local1);
        }
        else
        {
          new Thread(local1).start();
          continue;
          a().runOnUiThread(new AsyncSteps.2(this, (kpi)localObject));
        }
      }
    }
    return false;
  }
  
  public final void aFI()
  {
    this.aKW += 1;
    log("AsyncSteps onEnd: mFinishCount = " + this.aKW);
    if (this.aKW == this.a.length) {
      aFM();
    }
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
 * Qualified Name:     kpg
 * JD-Core Version:    0.7.0.1
 */