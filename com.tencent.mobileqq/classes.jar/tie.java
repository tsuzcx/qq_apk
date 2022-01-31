import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class tie
  implements View.OnClickListener
{
  tie(tia paramtia) {}
  
  public void onClick(View paramView)
  {
    paramView = tia.a(this.a).a();
    if (!badq.g(paramView))
    {
      bbmy.a(paramView, 1, 2131628946, 0).a();
      return;
    }
    urk.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { tia.a(this.a) });
    tia.a(this.a).setVisibility(0);
    tia.a(this.a).removeCallbacks(tia.a(this.a));
    tia.a(this.a).postDelayed(tia.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tie
 * JD-Core Version:    0.7.0.1
 */