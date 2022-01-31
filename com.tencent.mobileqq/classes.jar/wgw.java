import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

public class wgw
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public wgw(String paramString)
  {
    this.a = paramString;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */