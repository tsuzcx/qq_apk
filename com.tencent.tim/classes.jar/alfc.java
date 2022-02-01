import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

public class alfc
  implements View.OnTouchListener
{
  public alfc(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (StickyNotePublishFragment.a(this.a))
    {
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      aurd.hide(StickyNotePublishFragment.a(this.a));
      return false;
    }
    if (StickyNotePublishFragment.a(this.a) == 0)
    {
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(8);
      StickyNotePublishFragment.a(this.a).setVisibility(0);
      StickyNotePublishFragment.a(this.a).requestFocus();
      aurd.aO(StickyNotePublishFragment.a(this.a));
      return false;
    }
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a, 0);
    this.a.Ix(false);
    this.a.NF(false);
    this.a.NG(true);
    this.a.jg(0, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfc
 * JD-Core Version:    0.7.0.1
 */