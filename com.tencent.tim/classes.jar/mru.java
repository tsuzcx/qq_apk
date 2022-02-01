import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class mru
{
  private static final String TAG = "Q.readinjoy.video." + mru.class.getSimpleName();
  private static final mru a = new mru();
  private int aTS;
  private int aTT;
  
  private mru()
  {
    if (Ec()) {
      this.aTS = aN("entrance_button_day_display_count");
    }
    for (this.aTT = aN("entrance_jump_app_display_count");; this.aTT = 0)
    {
      log("EntranceButtonExposureHelper() mDayDisplayCount:" + this.aTS + ",mEntranceDownloadInfoDisplayCount:" + this.aTT);
      return;
      this.aTS = 0;
    }
  }
  
  private static boolean Ec()
  {
    Object localObject1 = Calendar.getInstance();
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(2);
    int k = ((Calendar)localObject1).get(5);
    localObject1 = i + j + k;
    Object localObject2 = awit.a(kxm.a(), true, true);
    if (localObject2 == null)
    {
      log("checkIsToday() failed");
      return false;
    }
    String str = ((SharedPreferences)localObject2).getString("entrance_button_daily", null);
    log("checkIsToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(str))) {
      return true;
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("entrance_button_daily", (String)localObject1);
    awit.a((SharedPreferences.Editor)localObject2, true);
    return false;
  }
  
  public static mru a()
  {
    return a;
  }
  
  private void aM(String paramString, int paramInt)
  {
    if (awit.a(kxm.a(), true, true) == null)
    {
      log("writeToSP() failed");
      return;
    }
    awit.H(paramString, Integer.valueOf(paramInt));
  }
  
  private int aN(String paramString)
  {
    return awit.a(kxm.a(), true, true).getInt(paramString, 0);
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, paramString);
    }
  }
  
  public void b(nss paramnss)
  {
    for (;;)
    {
      try
      {
        boolean bool = Ec();
        if (bool)
        {
          this.aTS += 1;
          aM("entrance_button_day_display_count", this.aTS);
          if ((paramnss instanceof VideoInfo.EntranceDownloadInfo))
          {
            if (bool)
            {
              this.aTT += 1;
              aM("entrance_jump_app_display_count", this.aTT);
            }
          }
          else {
            log("addToCount() mDayDisplayCount:" + this.aTS + "，mEntranceDownloadInfoDisplayCount：" + this.aTT);
          }
        }
        else
        {
          this.aTS = 0;
          continue;
        }
        this.aTT = 0;
      }
      finally {}
    }
  }
  
  public int pH()
  {
    try
    {
      log("getDayDisplayCount() mDayDisplayCount:" + this.aTS);
      int i = this.aTS;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int pI()
  {
    try
    {
      int i = this.aTT;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mru
 * JD-Core Version:    0.7.0.1
 */