import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.3.1;

public class qse
  implements View.OnFocusChangeListener
{
  qse(qsb paramqsb) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.this$0.bmx();
    }
    while (qsb.a(this.this$0)) {
      return;
    }
    new Handler().postDelayed(new DetailCommentHelper.3.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qse
 * JD-Core Version:    0.7.0.1
 */