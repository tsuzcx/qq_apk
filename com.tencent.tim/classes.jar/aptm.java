import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class aptm
{
  private static final Drawable fG = new ColorDrawable(-5658199);
  
  public static boolean bF(Context paramContext)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    String str = new SimpleDateFormat("yyyy年MM月dd日").format(localCalendar.getTime());
    if ((!TextUtils.isEmpty(str)) && (str.equals(aqfe.get(paramContext, "glamour_has_update_today")))) {
      return false;
    }
    if (localCalendar.get(11) >= 4)
    {
      ebK();
      aqfe.J(paramContext, "glamour_has_update_today", str);
    }
    return true;
  }
  
  public static String bR(String paramString1, String paramString2)
  {
    return "https://qun.qq.com/qqweb/m/qun/rank/rank.html?from=31&_wv=1031&_bid=2468&uin=" + paramString1 + "&gc=" + paramString2;
  }
  
  protected static void ebK()
  {
    int i = 0;
    while (i < 20)
    {
      Object localObject = String.format("https://pub.idqqimg.com/pc/misc/groupgift/global_troop_level_%d.png", new Object[] { Integer.valueOf(i) });
      URLDrawable.removeMemoryCacheByUrl((String)localObject);
      localObject = aoiz.getFile((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptm
 * JD-Core Version:    0.7.0.1
 */