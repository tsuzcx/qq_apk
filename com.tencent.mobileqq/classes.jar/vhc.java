public class vhc
{
  private long a;
  private long b;
  
  public vhc(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public vhc a()
  {
    return new vhc(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhc
 * JD-Core Version:    0.7.0.1
 */