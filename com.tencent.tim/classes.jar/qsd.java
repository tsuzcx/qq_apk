import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class qsd
  implements View.OnTouchListener
{
  qsd(qsb paramqsb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (qsb.a(this.this$0)) {
        break label105;
      }
      this.this$0.a = StoryInputBarView.a(qsb.a(this.this$0), qsb.a(this.this$0), this.this$0.b, qsb.a(this.this$0).aET);
      qsb.a(this.this$0).a = this.this$0.a;
      paramView = this.this$0;
      if (this.this$0.a == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      qsb.a(paramView, bool);
      return false;
    }
    label105:
    this.this$0.bmx();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsd
 * JD-Core Version:    0.7.0.1
 */