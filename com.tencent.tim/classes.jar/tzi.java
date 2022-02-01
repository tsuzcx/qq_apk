import com.tencent.qphone.base.util.QLog;

public class tzi
{
  public static tzh a(Class<? extends tzh> paramClass, tzg paramtzg)
  {
    if (paramClass == uad.class) {
      paramClass = new uad();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.b(paramtzg);
      }
      return paramClass;
      if (paramClass == uag.class) {
        paramClass = new uag();
      } else {
        try
        {
          tzh localtzh = (tzh)paramClass.newInstance();
          paramClass = localtzh;
        }
        catch (Exception localException)
        {
          QLog.e("DoraemonOpenAPI.moduleFactory", 1, "newInstance error module=" + paramClass, localException);
          paramClass = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */