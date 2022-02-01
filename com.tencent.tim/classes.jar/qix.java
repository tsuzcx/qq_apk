import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.h;

public class qix
  implements XViewPager.h
{
  public final ViewPager.PageTransformer a;
  
  public qix(ViewPager.PageTransformer paramPageTransformer)
  {
    this.a = paramPageTransformer;
  }
  
  public void transformPage(View paramView, float paramFloat)
  {
    this.a.transformPage(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qix
 * JD-Core Version:    0.7.0.1
 */