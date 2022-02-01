import java.lang.reflect.Array;

public final class lr
{
  private final byte[][] d;
  private final int height;
  private final int width;
  
  public lr(int paramInt1, int paramInt2)
  {
    this.d = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public byte a(int paramInt1, int paramInt2)
  {
    return this.d[paramInt2][paramInt1];
  }
  
  public byte[][] a()
  {
    return this.d;
  }
  
  public void b(byte paramByte)
  {
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      while (j < this.width)
      {
        this.d[i][j] = paramByte;
        j += 1;
      }
      i += 1;
    }
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.d[paramInt2];
    if (paramBoolean) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      arrayOfByte[paramInt1] = ((byte)paramInt2);
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.width * 2 * this.height + 2);
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      if (j < this.width)
      {
        switch (this.d[i][j])
        {
        default: 
          localStringBuilder.append("  ");
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuilder.append(" 0");
          continue;
          localStringBuilder.append(" 1");
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lr
 * JD-Core Version:    0.7.0.1
 */