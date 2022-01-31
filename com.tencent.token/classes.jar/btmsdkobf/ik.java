package btmsdkobf;

class ik
  implements Runnable
{
  ik(ds paramds, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      ds.b(this.c).c(this.a, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      eh.h("TcpNetwork", localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ik
 * JD-Core Version:    0.7.0.1
 */