import com.tencent.mobileqq.app.ThreadManager;

public class jql
  implements jpl
{
  public void C(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void D(Runnable paramRunnable)
  {
    ThreadManager.executeOnFileThread(paramRunnable);
  }
  
  public void runOnSubThread(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jql
 * JD-Core Version:    0.7.0.1
 */