import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.3.1;

public class ygo
  implements View.OnFocusChangeListener
{
  ygo(ygl paramygl) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.b();
    }
    while (ygl.a(this.a)) {
      return;
    }
    new Handler().postDelayed(new DetailCommentHelper.3.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygo
 * JD-Core Version:    0.7.0.1
 */