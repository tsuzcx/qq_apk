public class avft
{
  private static final String[] iL = { "B", "K", "M", "G" };
  
  public static final String cs(long paramLong)
  {
    float f1 = 0.0F;
    int i = 0;
    while (paramLong >= 1024L)
    {
      paramLong /= 1024L;
      f1 = (float)(paramLong % 1024L);
      i += 1;
    }
    if (f1 == 0.0F)
    {
      f1 = (float)paramLong;
      return String.valueOf(paramLong) + iL[i];
    }
    f1 /= 1024.0F;
    float f2 = (float)paramLong;
    return String.format("%.2f", new Object[] { Float.valueOf(f1 + f2) }) + iL[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avft
 * JD-Core Version:    0.7.0.1
 */