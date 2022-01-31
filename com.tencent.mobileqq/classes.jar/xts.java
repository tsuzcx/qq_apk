import android.animation.TypeEvaluator;

final class xts
  implements TypeEvaluator<xtr>
{
  private xtr a;
  
  public xtr a(float paramFloat, xtr paramxtr1, xtr paramxtr2)
  {
    float f1 = paramxtr1.a + (paramxtr2.a - paramxtr1.a) * paramFloat;
    float f2 = paramxtr1.b + (paramxtr2.b - paramxtr1.b) * paramFloat;
    paramFloat = paramxtr1.c + (paramxtr2.c - paramxtr1.c) * paramFloat;
    if (this.a == null) {
      this.a = new xtr(f1, f2, paramFloat);
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
 * Qualified Name:     xts
 * JD-Core Version:    0.7.0.1
 */