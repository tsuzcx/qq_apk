import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class asyt
  implements asyr
{
  private asys a;
  private boolean dgF;
  
  public asyt(asys paramasys)
  {
    this.a = paramasys;
  }
  
  private void doScan()
  {
    Object localObject1 = Pandora.getApplicationList(BaseApplication.getContext());
    PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
    if ((localPackageManager != null) && (localObject1 != null)) {
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.dgF) {}
      }
      else
      {
        return;
      }
      if (this.a != null) {
        try
        {
          localObject2 = localPackageManager.getPackageInfo((String)localObject2, 0);
          this.a.F(getType(), localObject2);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  private void esw()
  {
    if (this.dgF) {}
    do
    {
      return;
      this.dgF = true;
    } while (this.a == null);
    this.a.E(getType(), null);
  }
  
  private void esx()
  {
    if (!this.dgF) {}
    do
    {
      return;
      this.dgF = false;
    } while (this.a == null);
    this.a.G(getType(), null);
  }
  
  public String getType()
  {
    return "App";
  }
  
  public void start()
  {
    if (this.dgF) {
      return;
    }
    try
    {
      esw();
      doScan();
      label16:
      esx();
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyt
 * JD-Core Version:    0.7.0.1
 */