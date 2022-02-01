public class aurn
{
  private static ThreadLocal<StringBuilder> z = new ThreadLocal();
  
  public static StringBuilder d()
  {
    StringBuilder localStringBuilder = (StringBuilder)z.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder();
      z.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurn
 * JD-Core Version:    0.7.0.1
 */