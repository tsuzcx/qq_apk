import java.io.IOException;

public abstract interface aliv
{
  public abstract aliv.a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void init(int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
  
  public abstract void release()
    throws IOException;
  
  public static class a
  {
    public byte[] data;
    public int offset;
    public int size;
    
    public a(byte[] paramArrayOfByte, int paramInt)
    {
      this.size = paramInt;
      this.data = paramArrayOfByte;
      this.offset = 0;
    }
    
    public a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.size = paramInt2;
      this.data = paramArrayOfByte;
      this.offset = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aliv
 * JD-Core Version:    0.7.0.1
 */