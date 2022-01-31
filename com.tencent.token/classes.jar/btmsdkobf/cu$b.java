package btmsdkobf;

public class cu$b
{
  private final Object V = new Object();
  private byte iy = 0;
  
  public byte bx()
  {
    synchronized (this.V)
    {
      if (this.iy + 1 == 127) {
        this.iy = 0;
      }
      byte b = (byte)(this.iy + 1);
      this.iy = b;
      return b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cu.b
 * JD-Core Version:    0.7.0.1
 */