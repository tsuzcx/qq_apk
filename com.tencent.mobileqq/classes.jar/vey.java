public class vey
{
  private long a;
  private long b;
  
  public vey(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public vey a()
  {
    return new vey(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vey
 * JD-Core Version:    0.7.0.1
 */