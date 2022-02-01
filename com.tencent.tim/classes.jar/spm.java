import android.support.annotation.FloatRange;
import android.view.View;

public class spm
  implements spo
{
  private spk a = spk.a(1);
  private spk b = spk.b(1);
  private float minScale = 0.8F;
  private float on = 0.2F;
  
  public void h(View paramView, float paramFloat)
  {
    this.a.eh(paramView);
    this.b.eh(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.minScale;
    paramFloat = (1.0F - paramFloat) * this.on + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
  
  public static class a
  {
    private spm a = new spm();
    private float maxScale = 1.0F;
    
    public a a(@FloatRange(from=0.01D) float paramFloat)
    {
      spm.a(this.a, paramFloat);
      return this;
    }
    
    public spm a()
    {
      spm.b(this.a, this.maxScale - spm.a(this.a));
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spm
 * JD-Core Version:    0.7.0.1
 */