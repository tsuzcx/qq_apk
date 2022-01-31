import android.os.Process;

class ezk
  extends Thread
{
  ezk(ezj paramezj) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezk
 * JD-Core Version:    0.7.0.1
 */