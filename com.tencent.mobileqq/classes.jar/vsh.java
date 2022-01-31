import android.animation.TypeEvaluator;

final class vsh
  implements TypeEvaluator<vsg>
{
  private vsg a;
  
  public vsg a(float paramFloat, vsg paramvsg1, vsg paramvsg2)
  {
    float f1 = paramvsg1.a + (paramvsg2.a - paramvsg1.a) * paramFloat;
    float f2 = paramvsg1.b + (paramvsg2.b - paramvsg1.b) * paramFloat;
    paramFloat = paramvsg1.c + (paramvsg2.c - paramvsg1.c) * paramFloat;
    if (this.a == null) {
      this.a = new vsg(f1, f2, paramFloat);
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
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */