public class vfa
{
  private long a;
  private long b;
  
  public long a()
  {
    return this.a;
  }
  
  public long a(long paramLong)
  {
    this.b = (paramLong - this.a);
    this.a = paramLong;
    return this.b;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfa
 * JD-Core Version:    0.7.0.1
 */