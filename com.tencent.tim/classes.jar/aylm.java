import android.animation.TypeEvaluator;

public class aylm
  implements TypeEvaluator<aylk>
{
  private aylk a;
  
  public aylk a(float paramFloat, aylk paramaylk1, aylk paramaylk2)
  {
    float f1 = paramaylk1.x + (paramaylk2.x - paramaylk1.x) * paramFloat;
    float f2 = paramaylk1.y + (paramaylk2.y - paramaylk1.y) * paramFloat;
    float f3 = paramaylk1.scale + (paramaylk2.scale - paramaylk1.scale) * paramFloat;
    paramFloat = paramaylk1.rotate + (paramaylk2.rotate - paramaylk1.rotate) * paramFloat;
    if (this.a == null) {
      this.a = new aylk(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.set(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylm
 * JD-Core Version:    0.7.0.1
 */