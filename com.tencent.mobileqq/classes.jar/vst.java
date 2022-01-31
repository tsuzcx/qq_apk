import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class vst
  implements vvt
{
  public final ViewPager.PageTransformer a;
  
  public vst(ViewPager.PageTransformer paramPageTransformer)
  {
    this.a = paramPageTransformer;
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.a.transformPage(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vst
 * JD-Core Version:    0.7.0.1
 */