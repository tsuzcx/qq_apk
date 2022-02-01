import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class xha
  implements xje
{
  public xha(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void a(@NonNull View paramView, int paramInt)
  {
    if (LiuHaiUtils.a)
    {
      paramInt = StoryPlayerGroupHolder.a(this.a);
      paramView = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
      paramView.bottomMargin = paramInt;
      this.a.a.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */