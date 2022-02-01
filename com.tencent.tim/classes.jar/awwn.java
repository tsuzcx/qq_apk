import android.view.View;
import android.view.ViewStub;
import java.util.LinkedList;
import java.util.Queue;

public abstract class awwn
{
  private final ViewStub O;
  private Queue<Runnable> R;
  private boolean dtn;
  
  public awwn(ViewStub paramViewStub)
  {
    this.O = paramViewStub;
    this.R = new LinkedList();
  }
  
  private void eHd()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.R.poll();
      if (localRunnable != null) {
        try
        {
          localRunnable.run();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          throw new RuntimeException("doPendingActions encounter an error", localException);
        }
      }
    }
  }
  
  protected void aA(Runnable paramRunnable)
  {
    if (this.dtn) {
      paramRunnable.run();
    }
    while (paramRunnable == null) {
      return;
    }
    this.R.add(paramRunnable);
  }
  
  public boolean aOe()
  {
    return this.dtn;
  }
  
  protected final void eHc()
  {
    if (this.dtn) {
      return;
    }
    View localView = this.O.inflate();
    this.dtn = true;
    jm(localView);
    eHd();
  }
  
  protected abstract void jm(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwn
 * JD-Core Version:    0.7.0.1
 */