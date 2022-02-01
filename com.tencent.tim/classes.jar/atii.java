import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;

class atii
  implements View.OnTouchListener
{
  atii(atie paramatie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      atie.a(this.this$0, true);
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() == 1)
      {
        if (atie.a(this.this$0))
        {
          paramView = new Intent(this.this$0.mContext, CloudUploadingListActivity.class);
          this.this$0.mContext.startActivity(paramView);
          return true;
        }
        atie.a(this.this$0, false);
        return true;
      }
    } while (paramMotionEvent.getAction() != 3);
    atie.a(this.this$0, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atii
 * JD-Core Version:    0.7.0.1
 */