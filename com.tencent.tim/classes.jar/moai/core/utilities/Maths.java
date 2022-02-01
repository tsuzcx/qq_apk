package moai.core.utilities;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import java.util.List;
import java.util.Random;

public final class Maths
{
  private static final int CANTOR_ERROR = 1000;
  private static final ThreadLocal<Random> threadLocalRandom = new Maths.1();
  
  public static float angle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.atan2(paramFloat4 - paramFloat2, paramFloat3 - paramFloat1);
  }
  
  public static float angle(PointF paramPointF1, PointF paramPointF2)
  {
    return angle(paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
  }
  
  public static double avg(List<Double> paramList)
  {
    if (paramList == null) {
      throw new RuntimeException("DevRuntimeException: data is null");
    }
    double d = 0.0D;
    int i = 0;
    while (i < paramList.size())
    {
      d += ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return d / paramList.size();
  }
  
  public static int cantor(float paramFloat1, float paramFloat2)
  {
    return cantor(Math.round(paramFloat1 * 1000.0F), Math.round(1000.0F * paramFloat2));
  }
  
  public static int cantor(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) * (paramInt1 + paramInt2 + 1) / 2 + paramInt2;
  }
  
  public static int ceil(int paramInt1, int paramInt2)
  {
    if (paramInt1 % paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt1 / paramInt2 + 1) * paramInt2;
  }
  
  public static <T> T conditions(T[] paramArrayOfT, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return paramArrayOfT[0];
      }
      return paramArrayOfT[1];
    }
    if (paramBoolean2) {
      return paramArrayOfT[2];
    }
    return paramArrayOfT[3];
  }
  
  public static float distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float distance(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static float distance(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return 0.0F;
    }
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static double findMax(List<Double> paramList)
  {
    if (paramList == null) {
      throw new RuntimeException("DevRuntimeException: data is null");
    }
    double d1 = 4.9E-324D;
    int i = 0;
    while (i < paramList.size())
    {
      double d2 = d1;
      if (d1 < ((Double)paramList.get(i)).doubleValue()) {
        d2 = ((Double)paramList.get(i)).doubleValue();
      }
      i += 1;
      d1 = d2;
    }
    return d1;
  }
  
  public static double findMin(List<Double> paramList)
  {
    if (paramList == null) {
      throw new RuntimeException("DevRuntimeException: data is null");
    }
    double d1 = 1.7976931348623157E+308D;
    int i = 0;
    while (i < paramList.size())
    {
      double d2 = d1;
      if (d1 > ((Double)paramList.get(i)).doubleValue()) {
        d2 = ((Double)paramList.get(i)).doubleValue();
      }
      i += 1;
      d1 = d2;
    }
    return d1;
  }
  
  public static boolean in(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 <= paramInt3) && (paramInt3 <= paramInt2);
  }
  
  public static boolean intersection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if ((paramInt1 <= paramInt4) && (paramInt2 >= paramInt3))
    {
      paramArrayOfInt[0] = Math.max(paramInt1, paramInt3);
      paramArrayOfInt[1] = Math.min(paramInt2, paramInt4);
      return true;
    }
    return false;
  }
  
  public static boolean isRange(String paramString)
  {
    return (paramString != null) && (paramString.length() != 0) && (Patterns.match("\\d+-\\d+", paramString));
  }
  
  public static double max(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 >= paramDouble2) {
      return paramDouble1;
    }
    return paramDouble2;
  }
  
  public static int max(List<Integer> paramList)
  {
    int j = -2147483648;
    int i = 0;
    while (i < paramList.size())
    {
      int k = j;
      if (((Integer)paramList.get(i)).intValue() > j) {
        k = ((Integer)paramList.get(i)).intValue();
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static void midpoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    paramPointF.x = ((paramFloat1 + paramFloat3) / 2.0F);
    paramPointF.y = ((paramFloat2 + paramFloat4) / 2.0F);
  }
  
  public static void midpoint(MotionEvent paramMotionEvent, PointF paramPointF)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return;
    }
    midpoint(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1), paramPointF);
  }
  
  public static double min(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 >= paramDouble2) {
      return paramDouble2;
    }
    return paramDouble1;
  }
  
  public static int nextPowerOfTwo(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    paramInt -= 1;
    paramInt |= paramInt >> 1;
    paramInt |= paramInt >> 2;
    paramInt |= paramInt >> 4;
    paramInt |= paramInt >> 8;
    return (paramInt | paramInt >> 16) + 1;
  }
  
  public static Range<Integer> parseRange(String paramString)
  {
    if (!isRange(paramString)) {
      return Range.singleton(Integer.valueOf(0));
    }
    paramString = paramString.split("-");
    if (paramString.length == 1) {
      return Range.singleton(Ints.tryParse(paramString[0]));
    }
    return Range.closed(Ints.tryParse(paramString[0]), Ints.tryParse(paramString[1]));
  }
  
  public static int random(int paramInt)
  {
    return ((Random)threadLocalRandom.get()).nextInt(paramInt);
  }
  
  public static double randomDouble()
  {
    return ((Random)threadLocalRandom.get()).nextDouble();
  }
  
  public static double round1(double paramDouble)
  {
    return Math.round(paramDouble * 10.0D) / 10.0D;
  }
  
  public static double round2(double paramDouble)
  {
    return Math.round(paramDouble * 100.0D) / 100.0D;
  }
  
  public static int setBitTo0(int paramInt1, int paramInt2)
  {
    return (1 << paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  public static int setBitTo1(int paramInt1, int paramInt2)
  {
    return 1 << paramInt2 | paramInt1;
  }
  
  public static boolean union(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if ((paramInt1 <= paramInt4) && (paramInt2 >= paramInt3))
    {
      paramArrayOfInt[0] = Math.min(paramInt1, paramInt3);
      paramArrayOfInt[1] = Math.max(paramInt2, paramInt4);
      return true;
    }
    return false;
  }
  
  public void rotate(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    paramPointF1.x = ((float)Math.cos(paramFloat) * (f1 - f3) - (float)Math.sin(paramFloat) * (f2 - f4) + f3);
    paramPointF1.y = ((f1 - f3) * (float)Math.sin(paramFloat) + (f2 - f4) * (float)Math.cos(paramFloat) + f4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Maths
 * JD-Core Version:    0.7.0.1
 */