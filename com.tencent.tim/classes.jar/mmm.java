import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mmm
  implements View.OnClickListener
{
  public mmm(EditVideoFragment paramEditVideoFragment) {}
  
  public void onClick(View paramView)
  {
    if ((EditVideoFragment.a(this.a) != null) && (EditVideoFragment.a(this.a).isShowing())) {
      EditVideoFragment.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmm
 * JD-Core Version:    0.7.0.1
 */