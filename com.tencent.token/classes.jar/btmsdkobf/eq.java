package btmsdkobf;

public class eq
  extends Thread
{
  private eq.a oN;
  private Runnable oR;
  
  public void run()
  {
    if (this.oN != null) {
      this.oN.beforeExecute(this, this.oR);
    }
    super.run();
    if (this.oN != null) {
      this.oN.b(this, this.oR);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eq
 * JD-Core Version:    0.7.0.1
 */