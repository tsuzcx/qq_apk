import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.util.VersionUtils;

public class aqen
{
  public static void cq(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    int i = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getOrientation();
    switch (paramActivity.getResources().getConfiguration().orientation)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramActivity.setRequestedOrientation(i);
      return;
      if ((i == 0) || (i == 1) || (!VersionUtils.isGingerBread())) {
        break;
      }
      i = 8;
      continue;
      if ((i != 0) && (i != 3) && (VersionUtils.isGingerBread())) {
        i = 9;
      } else {
        i = 1;
      }
    }
  }
  
  public static void cr(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.setRequestedOrientation(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqen
 * JD-Core Version:    0.7.0.1
 */