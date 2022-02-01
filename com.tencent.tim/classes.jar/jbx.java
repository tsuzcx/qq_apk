import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jbx
  implements View.OnClickListener
{
  public jbx(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finishActivity();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbx
 * JD-Core Version:    0.7.0.1
 */