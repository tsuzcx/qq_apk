import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class aeyu
{
  private static final Formatter a = new Formatter(o, Locale.getDefault());
  private static final Date d;
  private static final SimpleDateFormat k = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
  private static final StringBuilder o;
  private static float sDensity = -1.0F;
  
  static
  {
    d = new Date();
    o = new StringBuilder();
  }
  
  public static int a(aexe paramaexe1, aexe paramaexe2, long paramLong)
  {
    if ((paramaexe1.bX(paramLong)) || (paramaexe2.bX(paramLong))) {}
    float[] arrayOfFloat2;
    do
    {
      return -1;
      arrayOfFloat1 = paramaexe1.getCollisionRectAtTime(paramaexe1.fA());
      arrayOfFloat2 = paramaexe2.getCollisionRectAtTime(paramaexe1.fA());
    } while ((arrayOfFloat1 == null) || (arrayOfFloat2 == null));
    int i = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / paramaexe2.getSpeedX());
    float[] arrayOfFloat1 = paramaexe1.getCollisionRectAtTime(paramaexe1.fz());
    return Math.max(i, (int)((paramaexe2.getCollisionRectAtTime(paramaexe1.fz())[0] - arrayOfFloat1[2]) / paramaexe2.getSpeedX()));
  }
  
  public static boolean aiE()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static String bo(long paramLong)
  {
    if (paramLong < 86400000L)
    {
      paramLong /= 1000L;
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L % 60L;
      long l3 = paramLong / 3600L;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      o.setLength(0);
      if (l2 > 0L) {
        return a.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      }
      return a.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    d.setTime(paramLong);
    return k.format(d);
  }
  
  public static int compare(aexe paramaexe1, aexe paramaexe2)
  {
    int i = 0;
    if (paramaexe1 == paramaexe2) {}
    int j;
    do
    {
      do
      {
        return i;
        if (paramaexe1 == null) {
          return -1;
        }
        if (paramaexe2 == null) {
          return 1;
        }
      } while (paramaexe1.equals(paramaexe2));
      long l = paramaexe1.getTime() - paramaexe2.getTime();
      if (l > 0L) {
        return 1;
      }
      if (l < 0L) {
        return -1;
      }
      i = paramaexe1.CK() - paramaexe2.CK();
      if (i > 0) {
        return -1;
      }
      if (i < 0) {
        return 1;
      }
      i = paramaexe1.getRepeatTime() - paramaexe2.getRepeatTime();
      if (i > 0) {
        return 1;
      }
      if (i < 0) {
        return -1;
      }
      i = paramaexe1.CL() - paramaexe2.CL();
      if (i > 0) {
        return -1;
      }
      if (i < 0) {
        return 1;
      }
      l = paramaexe1.getIndex() - paramaexe2.getIndex();
      if (l > 0L) {
        return -1;
      }
      if (l < 0L) {
        return 1;
      }
      j = paramaexe1.getType() - paramaexe2.getType();
      if (j > 0) {
        return 1;
      }
      i = j;
    } while (j >= 0);
    return -1;
  }
  
  public static int dip2px(float paramFloat)
  {
    if (sDensity < 0.0F) {
      sDensity = aewr.a().a().d().getDisplayMetrics().density;
    }
    return (int)(sDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyu
 * JD-Core Version:    0.7.0.1
 */