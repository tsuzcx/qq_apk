import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;

public class jgt
  implements View.OnTouchListener
{
  public jgt(QavRecordButtonView paramQavRecordButtonView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QavRecordButtonView.a(this.b) != 1) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgt
 * JD-Core Version:    0.7.0.1
 */