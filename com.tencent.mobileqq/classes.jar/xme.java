import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class xme
  implements xpe
{
  public final ViewPager.PageTransformer a;
  
  public xme(ViewPager.PageTransformer paramPageTransformer)
  {
    this.a = paramPageTransformer;
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.a.transformPage(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */