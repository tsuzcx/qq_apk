import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class adyi
{
  public float alpha = 1.0F;
  public int mOperation;
  public float mX;
  public float mY;
  public float rotate;
  public float vA;
  public float vB;
  public float vC;
  public float vz;
  
  public adyi(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.vz = paramFloat1;
    this.vA = paramFloat2;
    this.vB = paramFloat3;
    this.vC = paramFloat4;
    this.mX = paramFloat5;
    this.mY = paramFloat6;
    this.mOperation = 2;
  }
  
  public adyi(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mOperation = paramInt;
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }
  
  public static adyi a(float paramFloat1, float paramFloat2)
  {
    return new adyi(1, paramFloat1, paramFloat2);
  }
  
  public static adyi a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return new adyi(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public static adyi b(float paramFloat1, float paramFloat2)
  {
    return new adyi(0, paramFloat1, paramFloat2);
  }
  
  @TargetApi(11)
  public static class a
    implements TypeEvaluator<adyi>
  {
    public adyi a(float paramFloat, adyi paramadyi1, adyi paramadyi2)
    {
      float f1;
      float f2;
      if (paramadyi2.mOperation == 2)
      {
        f1 = 1.0F - paramFloat;
        f2 = f1 * f1 * f1 * paramadyi1.mX + 3.0F * f1 * f1 * paramFloat * paramadyi2.vz + 3.0F * f1 * paramFloat * paramFloat * paramadyi2.vB + paramFloat * paramFloat * paramFloat * paramadyi2.mX;
        float f3 = paramadyi1.mY;
        float f4 = paramadyi2.vA;
        f1 = f1 * 3.0F * paramFloat * paramFloat * paramadyi2.vC + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramadyi2.mY;
      }
      for (;;)
      {
        adyi localadyi = adyi.b(f2, f1);
        paramadyi1.alpha += (paramadyi2.alpha - paramadyi1.alpha) * paramFloat;
        paramadyi1.rotate += (paramadyi2.rotate - paramadyi1.rotate) * paramFloat;
        return localadyi;
        if (paramadyi2.mOperation == 1)
        {
          f1 = paramadyi1.mX;
          f2 = (paramadyi2.mX - paramadyi1.mX) * paramFloat + f1;
          f1 = paramadyi1.mY + (paramadyi2.mY - paramadyi1.mY) * paramFloat;
        }
        else
        {
          f2 = paramadyi2.mX;
          f1 = paramadyi2.mY;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyi
 * JD-Core Version:    0.7.0.1
 */