import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;

public class vto
  implements vvs
{
  public vto(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(@NonNull View paramView, int paramInt)
  {
    if (bnle.a)
    {
      paramInt = StoryPlayerGroupHolder.a(this.a);
      paramView = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
      paramView.bottomMargin = paramInt;
      this.a.a.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vto
 * JD-Core Version:    0.7.0.1
 */