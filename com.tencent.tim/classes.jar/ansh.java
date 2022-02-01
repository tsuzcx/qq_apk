import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

public class ansh
{
  private Random rand = new Random();
  private long startTime = -1L;
  
  public void jG(int paramInt1, int paramInt2)
  {
    if (this.startTime == -1L) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.startTime;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cost", l1 - l2 + "");
    localHashMap.put("layout", paramInt1 + "");
    localHashMap.put("first", paramInt2 + "");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "structmsg_builder_getview", true, 0L, 0L, localHashMap, "", false);
    this.startTime = -1L;
  }
  
  public void reportStart()
  {
    if (this.rand.nextInt() % 300 != 1) {
      return;
    }
    this.startTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansh
 * JD-Core Version:    0.7.0.1
 */