package cooperation.hce;

import aczc;

public class HceDataProxy
{
  private static final String TAG = "HceDataProxy";
  
  public static void startLocation(String paramString, GetLocationListener paramGetLocationListener)
  {
    if (paramGetLocationListener == null) {
      return;
    }
    aczc.a(new HceDataProxy.1(paramString, paramGetLocationListener));
  }
  
  public static abstract interface GetLocationListener
  {
    public abstract void onLocationFinish(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.hce.HceDataProxy
 * JD-Core Version:    0.7.0.1
 */