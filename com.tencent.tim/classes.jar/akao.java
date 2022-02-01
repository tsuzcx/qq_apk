import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class akao
  implements View.OnTouchListener
{
  akao(ajzv paramajzv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      this.this$0.Fb.findViewById(2131378177).setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      this.this$0.Fb.findViewById(2131378177).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akao
 * JD-Core Version:    0.7.0.1
 */