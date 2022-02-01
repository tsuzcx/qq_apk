package moai.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import moai.core.utilities.Indexes;

public class HaffmanEncodeOutputStream
  extends FilterOutputStream
{
  private int count;
  private final ByteBuffer oneIntBuffer = ByteBuffer.allocate(8);
  
  public HaffmanEncodeOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    Indexes.encodeOneInt(paramInt, this.oneIntBuffer);
    this.out.write(this.oneIntBuffer.array(), 0, this.oneIntBuffer.limit());
    this.count += this.oneIntBuffer.limit();
  }
  
  public void write(int[] paramArrayOfInt)
    throws IOException
  {
    write(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  public void write(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      write(paramArrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.HaffmanEncodeOutputStream
 * JD-Core Version:    0.7.0.1
 */