import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;

public final class aqpb
{
  @NonNull
  public static final aqpb a = new aqpb();
  @NonNull
  public static final aqpb b;
  @NonNull
  public static final aqpb c;
  @NonNull
  public static final aqpb d;
  @NonNull
  public static final aqpb e;
  @NonNull
  public static final aqpb f;
  boolean cVs = true;
  final float[] dA = new float[3];
  final float[] dz = new float[3];
  final float[] mWeights = new float[3];
  
  static
  {
    c(a);
    d(a);
    b = new aqpb();
    b(b);
    d(b);
    c = new aqpb();
    a(c);
    d(c);
    d = new aqpb();
    c(d);
    e(d);
    e = new aqpb();
    b(e);
    e(e);
    f = new aqpb();
    a(f);
    e(f);
  }
  
  aqpb()
  {
    f(this.dz);
    f(this.dA);
    eeK();
  }
  
  private static void a(aqpb paramaqpb)
  {
    paramaqpb.dA[1] = 0.26F;
    paramaqpb.dA[2] = 0.45F;
  }
  
  private static void b(aqpb paramaqpb)
  {
    paramaqpb.dA[0] = 0.3F;
    paramaqpb.dA[1] = 0.5F;
    paramaqpb.dA[2] = 0.7F;
  }
  
  private static void c(aqpb paramaqpb)
  {
    paramaqpb.dA[0] = 0.55F;
    paramaqpb.dA[1] = 0.74F;
  }
  
  private static void d(aqpb paramaqpb)
  {
    paramaqpb.dz[0] = 0.35F;
    paramaqpb.dz[1] = 1.0F;
  }
  
  private static void e(aqpb paramaqpb)
  {
    paramaqpb.dz[1] = 0.3F;
    paramaqpb.dz[2] = 0.4F;
  }
  
  private void eeK()
  {
    this.mWeights[0] = 0.24F;
    this.mWeights[1] = 0.52F;
    this.mWeights[2] = 0.24F;
  }
  
  private static void f(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bC()
  {
    return this.dz[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bD()
  {
    return this.dz[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bE()
  {
    return this.dz[2];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bF()
  {
    return this.dA[0];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bG()
  {
    return this.dA[1];
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float bH()
  {
    return this.dA[2];
  }
  
  public float bI()
  {
    return this.mWeights[0];
  }
  
  public float bJ()
  {
    return this.mWeights[1];
  }
  
  public float bK()
  {
    return this.mWeights[2];
  }
  
  void eeL()
  {
    int j = 0;
    int k = this.mWeights.length;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < k; f1 = f2)
    {
      float f3 = this.mWeights[i];
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = f1 + f3;
      }
      i += 1;
    }
    if (f1 != 0.0F)
    {
      k = this.mWeights.length;
      i = j;
      while (i < k)
      {
        if (this.mWeights[i] > 0.0F)
        {
          float[] arrayOfFloat = this.mWeights;
          arrayOfFloat[i] /= f1;
        }
        i += 1;
      }
    }
  }
  
  public boolean isExclusive()
  {
    return this.cVs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpb
 * JD-Core Version:    0.7.0.1
 */