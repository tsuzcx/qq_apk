import android.os.SystemClock;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akpb
{
  private static boolean ctH = true;
  private int actionType;
  private long adZ;
  private int doH;
  private long pS;
  
  public static boolean ass()
  {
    return ctH;
  }
  
  public void dCy()
  {
    long l;
    if (ass())
    {
      l = SystemClock.uptimeMillis() - this.pS;
      if (l <= 40L) {
        break label66;
      }
      Log.e("GestureFps", "Frame time: " + l);
    }
    for (;;)
    {
      this.doH += 1;
      this.pS = SystemClock.uptimeMillis();
      return;
      label66:
      if (l > 20L) {
        Log.w("GestureFps", "Frame time: " + l);
      }
    }
  }
  
  public void start(int paramInt)
  {
    if (ass())
    {
      this.actionType = paramInt;
      long l = SystemClock.uptimeMillis();
      this.pS = l;
      this.adZ = l;
      this.doH = 0;
    }
  }
  
  public void stop()
  {
    if ((ass()) && (this.doH > 0))
    {
      int i = (int)(SystemClock.uptimeMillis() - this.adZ);
      i = Math.round(1000.0F * this.doH / i);
      HashMap localHashMap = new HashMap();
      localHashMap.put("actType", String.valueOf(this.actionType));
      localHashMap.put("actFps", String.valueOf(i));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureFps", true, 0L, 0L, localHashMap, null);
      QLog.d("GestureFps", 1, new Object[] { "report ActOcrGestureFps, type:", Integer.valueOf(this.actionType), " fps:", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpb
 * JD-Core Version:    0.7.0.1
 */