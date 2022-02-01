import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.text.TextPaint;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class ilf
{
  private static volatile boolean Sc = true;
  private static int aoz;
  private static int[] cw;
  private static int[] cx;
  private static final char[] h = { 36, 64, 38, 35, 37, 165 };
  
  static
  {
    cw = new int[] { Color.parseColor("#FFCC00"), Color.parseColor("#FB4D97"), Color.parseColor("#0096FF"), Color.parseColor("#1ACEA6"), Color.parseColor("#4752E7"), Color.parseColor("#22CE53"), Color.parseColor("#B53BF5"), Color.parseColor("#1ACEA6") };
    cx = new int[] { Color.parseColor("#80690B"), Color.parseColor("#6E3F78"), Color.parseColor("#096AAD"), Color.parseColor("#13A685"), Color.parseColor("#343FD8"), Color.parseColor("#1F9944"), Color.parseColor("#6E3F78"), Color.parseColor("#2E5556") };
    aoz = Color.parseColor("#FFFFFF");
  }
  
  public static void a(Paint paramPaint, TextPaint paramTextPaint)
  {
    int i = new Random().nextInt(cw.length);
    if (paramPaint != null) {
      paramPaint.setColor(cw[i]);
    }
    if (paramTextPaint != null)
    {
      paramTextPaint.setColor(aoz);
      paramTextPaint.setShadowLayer(0.1F, 1.3F, 2.0F, cx[i]);
    }
  }
  
  public static boolean a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f = (float)Math.sqrt(Math.pow(paramPointF2.x - paramPointF1.x, 2.0D) + Math.pow(paramPointF2.y - paramPointF1.y, 2.0D));
    return (float)Math.sqrt(Math.pow(paramPointF4.x - paramPointF3.x, 2.0D) + Math.pow(paramPointF4.y - paramPointF3.y, 2.0D)) >= f * 0.112F;
  }
  
  public static boolean cu(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    while (!paramString.equals("spit")) {
      return false;
    }
    return true;
  }
  
  public static String dn(String paramString)
  {
    String str = "";
    if (paramString.length() > 10)
    {
      str = "";
      return str;
    }
    int k = paramString.length();
    int j = k / 2;
    int i = j;
    if (k + j > 13) {
      i = 13 - k;
    }
    Random localRandom = new Random();
    char c;
    for (paramString = str;; paramString = paramString + c)
    {
      str = paramString;
      if (paramString.length() >= i) {
        break;
      }
      j = localRandom.nextInt(h.length);
      c = h[j];
    }
  }
  
  public static void il(boolean paramBoolean)
  {
    Sc = paramBoolean;
    if (QLog.isDevelopLevel()) {
      QLog.i("ARZimuUtil", 4, "setIsEnableARZimu, isEnable[" + paramBoolean + "]");
    }
  }
  
  public static boolean tO()
  {
    boolean bool = imy.ue();
    if (QLog.isDevelopLevel()) {
      QLog.i("ARZimuUtil", 4, "getIsEnableARZimu, isSoEnable[" + bool + "], isEnableARZimu[" + Sc + "]");
    }
    return (Sc) && (bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilf
 * JD-Core Version:    0.7.0.1
 */