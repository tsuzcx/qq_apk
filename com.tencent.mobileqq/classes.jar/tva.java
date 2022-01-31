import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

class tva
  implements View.OnClickListener
{
  tva(tuw paramtuw) {}
  
  public void onClick(View paramView)
  {
    paramView = tuw.a(this.a).a();
    if (!bbev.g(paramView))
    {
      bcpw.a(paramView, 1, 2131694607, 0).a();
      return;
    }
    veg.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { tuw.a(this.a) });
    tuw.a(this.a).setVisibility(0);
    tuw.a(this.a).removeCallbacks(tuw.a(this.a));
    tuw.a(this.a).postDelayed(tuw.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tva
 * JD-Core Version:    0.7.0.1
 */