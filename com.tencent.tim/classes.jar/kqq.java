import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class kqq
  implements View.OnTouchListener
{
  kqq(kqo paramkqo, Context paramContext) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      if ((this.val$context == null) || (!(this.val$context instanceof Activity)) || (((Activity)this.val$context).getIntent() == null)) {
        break label67;
      }
    }
    label67:
    for (int i = ((Activity)this.val$context).getIntent().getIntExtra("channel_from", -1);; i = 0)
    {
      kqo.a("0X8007BE7", null, null, null, null, i);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqq
 * JD-Core Version:    0.7.0.1
 */