import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alfg
  implements View.OnClickListener
{
  public alfg(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.changeState(0);
    this.a.NF(false);
    StickyNotePublishFragment.a(this.a).setImageResource(2130845718);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getActivity().getString(2131690680));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfg
 * JD-Core Version:    0.7.0.1
 */