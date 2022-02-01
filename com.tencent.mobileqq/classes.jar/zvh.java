import android.animation.TypeEvaluator;

final class zvh
  implements TypeEvaluator<zvg>
{
  private zvg a;
  
  public zvg a(float paramFloat, zvg paramzvg1, zvg paramzvg2)
  {
    float f1 = paramzvg1.a + (paramzvg2.a - paramzvg1.a) * paramFloat;
    float f2 = paramzvg1.b + (paramzvg2.b - paramzvg1.b) * paramFloat;
    paramFloat = paramzvg1.c + (paramzvg2.c - paramzvg1.c) * paramFloat;
    if (this.a == null) {
      this.a = new zvg(f1, f2, paramFloat);
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
 * Qualified Name:     zvh
 * JD-Core Version:    0.7.0.1
 */