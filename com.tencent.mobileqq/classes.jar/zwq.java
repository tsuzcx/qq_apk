import com.tencent.mobileqq.app.ThreadManager;

class zwq
  implements Runnable
{
  zwq(zwp paramzwp) {}
  
  public void run()
  {
    ThreadManager.post(this.a, 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */