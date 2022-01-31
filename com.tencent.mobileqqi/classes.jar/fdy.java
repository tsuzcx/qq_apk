import android.os.Process;

class fdy
  extends Thread
{
  fdy(fdx paramfdx) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdy
 * JD-Core Version:    0.7.0.1
 */