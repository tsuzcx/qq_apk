import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

@TargetApi(14)
public class pnr
{
  protected static pnr a;
  public static final String ath = acbn.bmi + "qqstory_watermark/";
  public static final String[] bN = { bY, ath };
  public static final String[] bO = { plr.atf, plr.ath, plr.atr };
  public static final String[] bP = { plr.atg };
  public static final String[] bQ = { plr.atc };
  public static final String bY = acbn.bmi + "qqstory/";
  
  public static pnr a()
  {
    if (a == null) {
      a = new pnr();
    }
    return a;
  }
  
  private void rY(boolean paramBoolean)
  {
    ThreadManager.post(new CacheCleaner.2(this, paramBoolean), 2, null, false);
  }
  
  protected boolean U(boolean paramBoolean)
  {
    long l1 = 3600L;
    label185:
    for (;;)
    {
      try
      {
        psr localpsr = (psr)psx.a(10);
        long l2 = System.currentTimeMillis();
        long l3 = ((Long)localpsr.c("cache_clean_latest_time", Long.valueOf(0L))).longValue();
        String str1;
        if (paramBoolean)
        {
          l3 = Math.abs(l2 - l3);
          if (l3 < l1 * 1000L)
          {
            l1 = l3 / 1000L / 60L / 60L;
            if (!paramBoolean) {
              break label185;
            }
            str1 = "low";
            ram.b("Q.qqstory.cleaner:CacheCleaner", "clean before %d h , no need to clean again , capacity state :%s", Long.valueOf(l1), str1);
            paramBoolean = false;
            return paramBoolean;
          }
        }
        else
        {
          l1 = ((Long)localpsr.c("StoryClearRate", Long.valueOf(3600L))).longValue();
          continue;
        }
        if (paramBoolean)
        {
          str1 = "low";
          ram.w("Q.qqstory.cleaner:CacheCleaner", "clean cache , capacity state :%s", new Object[] { str1 });
          localpsr.n("cache_clean_latest_time", Long.valueOf(l2));
          paramBoolean = true;
        }
        else
        {
          str1 = "healthy";
          continue;
          String str2 = "healthy";
        }
      }
      finally {}
    }
  }
  
  public void blX()
  {
    Bosses.get().postJob(new pns(this, "Q.qqstory.cleaner:CacheCleaner"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnr
 * JD-Core Version:    0.7.0.1
 */