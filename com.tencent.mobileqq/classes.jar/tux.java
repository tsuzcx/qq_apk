import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class tux
  implements View.OnClickListener
{
  tux(tut paramtut) {}
  
  public void onClick(View paramView)
  {
    paramView = tut.a(this.a).a();
    if (!bbfj.g(paramView))
    {
      bcql.a(paramView, 1, 2131694608, 0).a();
      return;
    }
    ved.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { tut.a(this.a) });
    tut.a(this.a).setVisibility(0);
    tut.a(this.a).removeCallbacks(tut.a(this.a));
    tut.a(this.a).postDelayed(tut.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tux
 * JD-Core Version:    0.7.0.1
 */