import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class aygd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aygd(ayfw paramayfw) {}
  
  public void onGlobalLayout()
  {
    this.this$0.a.getViewTreeObserver().removeGlobalOnLayoutListener(ayfw.a(this.this$0));
    this.this$0.b.a(Message.obtain(null, 20));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygd
 * JD-Core Version:    0.7.0.1
 */