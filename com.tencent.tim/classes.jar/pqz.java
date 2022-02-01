import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class pqz
  implements TextView.OnEditorActionListener
{
  public pqz(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramTextView = paramTextView.getText().toString();
      if (paramTextView.length() <= 0) {
        break label140;
      }
      this.this$0.setKeyBoardState(false);
      if (this.this$0.c != null) {
        this.this$0.c.a(paramTextView, this.this$0.d);
      }
      this.this$0.hide();
      this.this$0.b.setText("");
      if (StoryInputBarView.a(this.this$0) != null) {
        StoryInputBarView.a(this.this$0).b(paramTextView, this.this$0.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:StoryInputBarView", 2, "onEditorAction vaule=" + paramTextView);
      }
    }
    return false;
    label140:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqz
 * JD-Core Version:    0.7.0.1
 */