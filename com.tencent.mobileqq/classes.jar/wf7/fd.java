package wf7;

import android.content.Context;

public class fd
  extends ec
{
  private static fd pL;
  private static Context pM;
  private static fa pN;
  
  public static void a(boolean paramBoolean1, Context paramContext, fa paramfa, dp paramdp, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    pM = paramContext;
    pN = paramfa;
    paramfa = fc.dC();
    paramfa.init(true);
    a(paramBoolean1, paramContext, paramdp, paramfa, paramBoolean2, paramBoolean3, paramString);
  }
  
  public static fd dD()
  {
    if (pL == null) {
      try
      {
        if (pL == null) {
          pL = new fd();
        }
      }
      finally {}
    }
    return pL;
  }
  
  public static Context dE()
  {
    return pM;
  }
  
  public static fa dF()
  {
    return pN;
  }
  
  public static void x(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fd
 * JD-Core Version:    0.7.0.1
 */