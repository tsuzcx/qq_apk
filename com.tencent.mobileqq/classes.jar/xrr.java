public class xrr
{
  private double jdField_a_of_type_Double = 1.0D;
  private long jdField_a_of_type_Long;
  
  public xrr()
  {
    a();
  }
  
  private long b()
  {
    return (System.nanoTime() / 1000L * this.jdField_a_of_type_Double);
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public long a()
  {
    return b() - this.jdField_a_of_type_Long;
  }
  
  public long a(long paramLong)
  {
    return paramLong - a();
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = (b() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrr
 * JD-Core Version:    0.7.0.1
 */