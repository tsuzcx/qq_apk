import android.animation.TypeEvaluator;

final class zjl
  implements TypeEvaluator<zjk>
{
  private zjk a;
  
  public zjk a(float paramFloat, zjk paramzjk1, zjk paramzjk2)
  {
    float f1 = paramzjk1.a + (paramzjk2.a - paramzjk1.a) * paramFloat;
    float f2 = paramzjk1.b + (paramzjk2.b - paramzjk1.b) * paramFloat;
    paramFloat = paramzjk1.c + (paramzjk2.c - paramzjk1.c) * paramFloat;
    if (this.a == null) {
      this.a = new zjk(f1, f2, paramFloat);
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
 * Qualified Name:     zjl
 * JD-Core Version:    0.7.0.1
 */