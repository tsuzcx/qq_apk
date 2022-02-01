import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.widget.XListView;

public class as
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public as(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.this$0.mListView.getBottom() - LiteActivity.a(this.this$0).getTop();
    if ((LiteActivity.a(this.this$0).getVisibility() == 0) && (this.this$0.mListView.getPaddingBottom() != i)) {
      this.this$0.mListView.setPadding(this.this$0.mListView.getPaddingLeft(), this.this$0.mListView.getPaddingTop(), this.this$0.mListView.getPaddingRight(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     as
 * JD-Core Version:    0.7.0.1
 */