import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1;

public class ayfu
  implements View.OnTouchListener
{
  public ayfu(EditVideoDTextFace.1 param1) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
    {
      ayft.a(this.a.this$0);
      rar.a("video_edit_text", "clk_textWording", 0, 0, new String[] { this.a.this$0.cWT, "", "", "" });
    }
    this.a.this$0.eRu();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfu
 * JD-Core Version:    0.7.0.1
 */