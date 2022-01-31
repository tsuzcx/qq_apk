import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;

public class cai
  implements TroopFileError.TroopFileErrorFilter
{
  public String a;
  
  public cai(String paramString)
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
 * Qualified Name:     cai
 * JD-Core Version:    0.7.0.1
 */