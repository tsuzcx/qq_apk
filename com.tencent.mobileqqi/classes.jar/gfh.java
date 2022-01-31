import android.content.Context;
import android.support.v4.view.ViewPager.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.widget.AdapterViewPagerAdapter.AdapterViewFactory;

public class gfh
  implements AdapterViewPagerAdapter.AdapterViewFactory
{
  public gfh(QzonePhotoView paramQzonePhotoView) {}
  
  public AdapterView a(Context paramContext, int paramInt)
  {
    paramContext = new GridView(paramContext);
    paramContext.setNumColumns(4);
    paramContext.setFadingEdgeLength(0);
    paramContext.setHorizontalSpacing(QzonePhotoView.a(this.a));
    paramContext.setVerticalSpacing(QzonePhotoView.a(this.a));
    paramContext.setStretchMode(2);
    paramContext.setScrollingCacheEnabled(false);
    paramContext.setSelector(2131361815);
    ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
    localLayoutParams.gravity = 17;
    localLayoutParams.height = -2;
    localLayoutParams.width = -1;
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gfh
 * JD-Core Version:    0.7.0.1
 */