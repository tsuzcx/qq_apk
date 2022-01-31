import com.tencent.qphone.base.util.QLog;

public class zry
{
  public static zrx a(Class<? extends zrx> paramClass, zrw paramzrw)
  {
    if (paramClass == zsx.class) {
      paramClass = new zsx();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramzrw);
      }
      return paramClass;
      if (paramClass == ztd.class) {
        paramClass = new ztd();
      } else {
        try
        {
          zrx localzrx = (zrx)paramClass.newInstance();
          paramClass = localzrx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zry
 * JD-Core Version:    0.7.0.1
 */