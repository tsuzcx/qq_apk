import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alfh
  implements View.OnClickListener
{
  public alfh(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.changeState(1);
    StickyNotePublishFragment.a(this.a).setImageResource(2130837612);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getActivity().getString(2131690681));
    anot.a(null, "dc00898", "", "", "0X800AB2D", "0X800AB2D", 0, 0, "0", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfh
 * JD-Core Version:    0.7.0.1
 */