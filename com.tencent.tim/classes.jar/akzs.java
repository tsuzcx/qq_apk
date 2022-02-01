import android.view.animation.Transformation;

class akzs
  implements aqnc.a<Float>
{
  akzs(akzr paramakzr) {}
  
  public void a(aqnc<Float> paramaqnc, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.scaleY = paramFloat1.floatValue();
    this.a.scaleX = (1.1F - (paramFloat1.floatValue() - 1.0F));
    if (this.a.a != null)
    {
      this.a.a.scaleY = paramFloat1.floatValue();
      this.a.a.scaleX = this.a.scaleX;
    }
    this.a.Lw((int)(this.a.cJX * paramFloat1.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzs
 * JD-Core Version:    0.7.0.1
 */