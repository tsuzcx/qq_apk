package wf7;

import android.os.IBinder;

public final class gw
{
  private static gn sB;
  
  public static IBinder P(String paramString)
  {
    try
    {
      paramString = fi().P(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  private static gn fi()
  {
    if (sB != null) {
      return sB;
    }
    Object localObject = gs.a("com.android.internal.os.BinderInternal", "getContextObject", null, null, null);
    if (!(localObject instanceof IBinder)) {
      return null;
    }
    sB = gx.a((IBinder)localObject);
    return sB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gw
 * JD-Core Version:    0.7.0.1
 */