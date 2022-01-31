import android.animation.TypeEvaluator;

final class xyb
  implements TypeEvaluator<xya>
{
  private xya a;
  
  public xya a(float paramFloat, xya paramxya1, xya paramxya2)
  {
    float f1 = paramxya1.a + (paramxya2.a - paramxya1.a) * paramFloat;
    float f2 = paramxya1.b + (paramxya2.b - paramxya1.b) * paramFloat;
    paramFloat = paramxya1.c + (paramxya2.c - paramxya1.c) * paramFloat;
    if (this.a == null) {
      this.a = new xya(f1, f2, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a = f1;
      this.a.b = f2;
      this.a.c = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xyb
 * JD-Core Version:    0.7.0.1
 */