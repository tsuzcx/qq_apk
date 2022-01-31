import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

public class cao
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public cao(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cao
 * JD-Core Version:    0.7.0.1
 */