import android.animation.TypeEvaluator;

final class zrm
  implements TypeEvaluator<zrl>
{
  private zrl a;
  
  public zrl a(float paramFloat, zrl paramzrl1, zrl paramzrl2)
  {
    float f1 = paramzrl1.a + (paramzrl2.a - paramzrl1.a) * paramFloat;
    float f2 = paramzrl1.b + (paramzrl2.b - paramzrl1.b) * paramFloat;
    paramFloat = paramzrl1.c + (paramzrl2.c - paramzrl1.c) * paramFloat;
    if (this.a == null) {
      this.a = new zrl(f1, f2, paramFloat);
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
 * Qualified Name:     zrm
 * JD-Core Version:    0.7.0.1
 */