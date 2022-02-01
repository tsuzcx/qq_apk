import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.g;

public class qjm
  implements XViewPager.g
{
  public qjm(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (ayxa.sHasNotch)
    {
      paramInt = StoryPlayerGroupHolder.a(this.this$0);
      paramView = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
      paramView.bottomMargin = paramInt;
      this.this$0.a.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjm
 * JD-Core Version:    0.7.0.1
 */