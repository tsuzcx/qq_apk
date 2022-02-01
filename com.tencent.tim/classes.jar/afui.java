import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afui
  implements View.OnClickListener
{
  public afui(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.b != null)
    {
      this.this$0.b.dcN();
      afxv.a().NF(3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afui
 * JD-Core Version:    0.7.0.1
 */