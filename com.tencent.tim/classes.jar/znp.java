import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class znp
  implements wvs
{
  private wtc a;
  private zof b;
  private boolean bfS;
  private boolean brH;
  private Runnable dH = new MiniECommerceExposeDataReportHelper.1(this);
  
  znp(zof paramzof)
  {
    this.b = paramzof;
  }
  
  private ListView b()
  {
    return this.b.d;
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 13, 19, 12 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 5: 
    case 19: 
      do
      {
        do
        {
          return;
          this.a = new wtc();
          return;
        } while (this.brH);
        this.brH = true;
        ThreadManager.getUIHandler().postDelayed(this.dH, 800L);
        return;
      } while (!this.bfS);
      this.a.b(this.b.mApp, b());
      return;
    }
    this.bfS = false;
    this.brH = false;
    this.a = null;
    ThreadManager.getUIHandler().removeCallbacks(this.dH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znp
 * JD-Core Version:    0.7.0.1
 */