import android.animation.TypeEvaluator;

final class yus
  implements TypeEvaluator<yur>
{
  private yur a;
  
  public yur a(float paramFloat, yur paramyur1, yur paramyur2)
  {
    float f1 = paramyur1.a + (paramyur2.a - paramyur1.a) * paramFloat;
    float f2 = paramyur1.b + (paramyur2.b - paramyur1.b) * paramFloat;
    paramFloat = paramyur1.c + (paramyur2.c - paramyur1.c) * paramFloat;
    if (this.a == null) {
      this.a = new yur(f1, f2, paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */