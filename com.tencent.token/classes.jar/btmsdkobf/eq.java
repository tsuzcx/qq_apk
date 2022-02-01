package btmsdkobf;

public class eq
  extends Thread
{
  private a oN;
  private Runnable oR;
  
  public void run()
  {
    a locala = this.oN;
    if (locala != null) {
      locala.beforeExecute(this, this.oR);
    }
    super.run();
    locala = this.oN;
    if (locala != null) {
      locala.b(this, this.oR);
    }
  }
  
  public void start()
  {
    try
    {
      if (this.oN != null) {
        this.oN.a(this, this.oR);
      }
      super.start();
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(Thread paramThread, Runnable paramRunnable);
    
    public abstract void b(Thread paramThread, Runnable paramRunnable);
    
    public abstract void beforeExecute(Thread paramThread, Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eq
 * JD-Core Version:    0.7.0.1
 */