import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

class ahir
  implements View.OnTouchListener
{
  ahir(ahio paramahio) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ahio.a(this.this$0).setImageResource(2130838215);
    ahio.a(this.this$0).setTag(Integer.valueOf(2130838215));
    if (ahio.a(this.this$0))
    {
      ahio.a(this.this$0);
      ahio.a(this.this$0).removeView(ahio.a(this.this$0));
      ahio.a(this.this$0, false);
      paramView = this.this$0.getWindow().getAttributes();
      paramView.y = 0;
      this.this$0.getWindow().setAttributes(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahir
 * JD-Core Version:    0.7.0.1
 */