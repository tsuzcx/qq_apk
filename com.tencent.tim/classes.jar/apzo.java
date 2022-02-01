import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class apzo
  extends DataOutputStream
{
  private static final byte[] gw = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final byte[] gx = { 13, 10 };
  private static final byte[] gy = { 48, 13, 10 };
  protected byte[] buffer;
  protected int dXZ;
  protected int dYa = -1;
  protected byte[] gz = new byte[32];
  
  public apzo(OutputStream paramOutputStream)
  {
    this(new byte[512], paramOutputStream);
  }
  
  public apzo(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.buffer = paramArrayOfByte;
    this.dYa = paramArrayOfByte.length;
  }
  
  protected final void append(int paramInt)
    throws IOException
  {
    if (this.dXZ + 1 >= this.dYa) {
      ecL();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.dXZ;
    this.dXZ = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public final void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.dXZ + paramInt2 >= this.dYa) {
      ecL();
    }
    if (paramInt2 < this.buffer.length)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.dXZ, paramInt2);
      this.dXZ += paramInt2;
      return;
    }
    p(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void close()
    throws IOException
  {
    close(true);
  }
  
  public void close(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      ecL();
      ecK();
      super.close();
      return;
    }
    ecL();
    ecK();
  }
  
  protected void ecK()
    throws IOException
  {
    this.out.write(gy, 0, 3);
    this.out.write(gx, 0, 2);
    this.out.flush();
  }
  
  protected void ecL()
    throws IOException
  {
    if (this.dXZ == 0) {
      return;
    }
    p(this.buffer, 0, this.dXZ);
    this.dXZ = 0;
  }
  
  public void flush()
    throws IOException
  {
    ecL();
    super.flush();
  }
  
  protected void p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0) {
      return;
    }
    int i = 3;
    this.gz[30] = 13;
    this.gz[31] = 10;
    int j = paramInt2;
    while (j > 15)
    {
      this.gz[(32 - i)] = gw[(j % 16)];
      j >>= 4;
      i += 1;
    }
    this.gz[(32 - i)] = gw[j];
    this.out.write(this.gz, 32 - i, i);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.out.write(gx, 0, 2);
    this.out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    append(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    append(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzo
 * JD-Core Version:    0.7.0.1
 */