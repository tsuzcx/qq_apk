import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

class vny
  implements View.OnClickListener
{
  vny(vnu paramvnu) {}
  
  public void onClick(View paramView)
  {
    paramView = vnu.a(this.a).a();
    if (!bdin.g(paramView))
    {
      QQToast.a(paramView, 1, 2131694766, 0).a();
      return;
    }
    wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { vnu.a(this.a) });
    vnu.a(this.a).setVisibility(0);
    vnu.a(this.a).removeCallbacks(vnu.a(this.a));
    vnu.a(this.a).postDelayed(vnu.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */