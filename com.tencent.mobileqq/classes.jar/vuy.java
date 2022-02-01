public class vuy
{
  private static volatile vuy a;
  
  public static vuy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new vuy();
      }
      return a;
    }
    finally {}
  }
  
  public vux a()
  {
    return new vux();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */