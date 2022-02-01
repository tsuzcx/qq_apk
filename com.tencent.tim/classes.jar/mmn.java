import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mmn
  implements View.OnClickListener
{
  public mmn(EditVideoFragment paramEditVideoFragment) {}
  
  public void onClick(View paramView)
  {
    if ((EditVideoFragment.b(this.a) != null) && (EditVideoFragment.b(this.a).isShowing())) {
      EditVideoFragment.b(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmn
 * JD-Core Version:    0.7.0.1
 */