import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

class vjp
  implements View.OnClickListener
{
  vjp(vjl paramvjl) {}
  
  public void onClick(View paramView)
  {
    paramView = vjl.a(this.a).a();
    if (!bdee.g(paramView))
    {
      QQToast.a(paramView, 1, 2131694764, 0).a();
      return;
    }
    wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { vjl.a(this.a) });
    vjl.a(this.a).setVisibility(0);
    vjl.a(this.a).removeCallbacks(vjl.a(this.a));
    vjl.a(this.a).postDelayed(vjl.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjp
 * JD-Core Version:    0.7.0.1
 */