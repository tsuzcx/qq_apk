import android.animation.TypeEvaluator;

final class wfa
  implements TypeEvaluator<wez>
{
  private wez a;
  
  public wez a(float paramFloat, wez paramwez1, wez paramwez2)
  {
    float f1 = paramwez1.a + (paramwez2.a - paramwez1.a) * paramFloat;
    float f2 = paramwez1.b + (paramwez2.b - paramwez1.b) * paramFloat;
    paramFloat = paramwez1.c + (paramwez2.c - paramwez1.c) * paramFloat;
    if (this.a == null) {
      this.a = new wez(f1, f2, paramFloat);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wfa
 * JD-Core Version:    0.7.0.1
 */