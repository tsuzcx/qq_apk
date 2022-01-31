import android.animation.TypeEvaluator;

final class wfd
  implements TypeEvaluator<wfc>
{
  private wfc a;
  
  public wfc a(float paramFloat, wfc paramwfc1, wfc paramwfc2)
  {
    float f1 = paramwfc1.a + (paramwfc2.a - paramwfc1.a) * paramFloat;
    float f2 = paramwfc1.b + (paramwfc2.b - paramwfc1.b) * paramFloat;
    paramFloat = paramwfc1.c + (paramwfc2.c - paramwfc1.c) * paramFloat;
    if (this.a == null) {
      this.a = new wfc(f1, f2, paramFloat);
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
 * Qualified Name:     wfd
 * JD-Core Version:    0.7.0.1
 */