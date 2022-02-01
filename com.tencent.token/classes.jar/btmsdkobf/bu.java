package btmsdkobf;

public class bu
{
  public static long a(int paramInt, long paramLong)
  {
    if (paramInt >= 0)
    {
      if (paramLong >= 0L) {
        return paramInt + paramLong;
      }
      throw new IllegalStateException("thread pool parent-ident is illegal");
    }
    throw new IllegalStateException("thread pool sub-ident is negative");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bu
 * JD-Core Version:    0.7.0.1
 */