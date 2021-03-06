import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class jzp
{
  public static double a(String paramString, double paramDouble)
  {
    double d = paramDouble;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        d = Double.valueOf(paramString.trim()).doubleValue();
      }
      return d;
    }
    catch (Exception paramString)
    {
      do
      {
        d = paramDouble;
      } while (!QLog.isColorLevel());
      QLog.d("ParseUtil", 2, " parseDouble error message=" + paramString.getMessage());
    }
    return paramDouble;
  }
  
  public static float b(String paramString, float paramFloat)
  {
    float f = paramFloat;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        f = Float.valueOf(paramString.trim()).floatValue();
      }
      return f;
    }
    catch (Exception paramString)
    {
      do
      {
        f = paramFloat;
      } while (!QLog.isColorLevel());
      QLog.d("ParseUtil", 2, " parseFloat error message=" + paramString.getMessage());
    }
    return paramFloat;
  }
  
  public static long d(String paramString, long paramLong)
  {
    long l = paramLong;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.valueOf(paramString.trim()).longValue();
      }
      return l;
    }
    catch (Exception paramString)
    {
      do
      {
        l = paramLong;
      } while (!QLog.isColorLevel());
      QLog.d("ParseUtil", 2, " parseLong error message=" + paramString.getMessage());
    }
    return paramLong;
  }
  
  public static int l(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        int i = Color.parseColor(paramString1.trim());
        return i;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParseUtil", 2, " parseColor error message=" + paramString1.getMessage());
      }
    }
    return Color.parseColor(paramString2);
  }
  
  public static int o(String paramString, int paramInt)
  {
    int i = paramInt;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.valueOf(paramString.trim()).intValue();
      }
      return i;
    }
    catch (Exception paramString)
    {
      do
      {
        i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.d("ParseUtil", 2, " parseInteger error message=" + paramString.getMessage());
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzp
 * JD-Core Version:    0.7.0.1
 */