package wf7;

import android.content.Context;

public final class dg
{
  private static boolean kj = false;
  private static dd kk = new di();
  
  public static void a(Context paramContext, String paramString) {}
  
  public static boolean bI()
  {
    return kj;
  }
  
  public static void i(boolean paramBoolean)
  {
    kj = paramBoolean;
    if (kj)
    {
      kk = new dh();
      return;
    }
    kk = new di();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.dg
 * JD-Core Version:    0.7.0.1
 */