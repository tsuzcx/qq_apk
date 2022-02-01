import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

public class alfb
  implements View.OnClickListener
{
  public alfb(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(0);
    StickyNotePublishFragment.a(this.a).requestFocus();
    aurd.aO(StickyNotePublishFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfb
 * JD-Core Version:    0.7.0.1
 */