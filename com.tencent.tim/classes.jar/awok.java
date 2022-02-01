public class awok
{
  public static String TAG = "WadlProxyServiceUtil";
  private static awol mWadlProxyService;
  
  public static awol a()
  {
    if (mWadlProxyService == null) {
      eEF();
    }
    return mWadlProxyService;
  }
  
  public static void a(awoe paramawoe)
  {
    if (mWadlProxyService != null) {
      mWadlProxyService.a(paramawoe);
    }
  }
  
  public static void b(awoe paramawoe)
  {
    if (mWadlProxyService != null) {
      mWadlProxyService.b(paramawoe);
    }
  }
  
  public static void eEF()
  {
    synchronized (TAG)
    {
      if (mWadlProxyService == null) {
        mWadlProxyService = new awol();
      }
      mWadlProxyService.eEF();
      return;
    }
  }
  
  public static void release()
  {
    if (mWadlProxyService != null)
    {
      mWadlProxyService.destroy();
      mWadlProxyService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awok
 * JD-Core Version:    0.7.0.1
 */