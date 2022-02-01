import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.config.Config;

public class txc
{
  public static int bCZ;
  public static SparseArray<txc.a> bm;
  private static long startDate = Math.round((float)(System.currentTimeMillis() / 86400000L));
  
  static
  {
    bm = new SparseArray(18);
    bm.put(6, new txc.a(0L, 0));
    bm.put(14, new txc.a(0L, 0));
  }
  
  public static void init()
  {
    long l;
    if (MagnifierSDK.x != null) {
      l = MagnifierSDK.x.getLong("last_start_date", 0L);
    }
    int[] arrayOfInt;
    int j;
    int i;
    int k;
    for (;;)
    {
      if ((startDate - l > 0L) && (MagnifierSDK.editor != null))
      {
        MagnifierSDK.editor.putLong("last_start_date", startDate);
        MagnifierSDK.editor.putInt("count_today_reported", 0);
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            k = arrayOfInt[i];
            MagnifierSDK.editor.putInt("count_plugin_" + String.valueOf(k), 0);
            bm.put(k, new txc.a(0L, 0));
            i += 1;
            continue;
            l = startDate;
            break;
          }
        }
        MagnifierSDK.editor.apply();
      }
    }
    for (;;)
    {
      return;
      if (MagnifierSDK.x != null)
      {
        bCZ = MagnifierSDK.x.getInt("count_today_reported", 0);
        if (bCZ >= Config.MAX_REPORT_NUM) {
          break;
        }
        arrayOfInt = Config.Plugins;
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          int m = MagnifierSDK.x.getInt("count_plugin_" + String.valueOf(k), 0);
          bm.put(k, new txc.a(0L, m));
          i += 1;
        }
      }
    }
  }
  
  public static class a
  {
    public boolean aQx = true;
    public int bDa;
    public long mLastTimestamp;
    
    a(long paramLong, int paramInt)
    {
      this.mLastTimestamp = paramLong;
      this.bDa = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */