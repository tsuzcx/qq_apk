import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afvj
  implements View.OnClickListener
{
  public afvj(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment, ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getActivity() != null) {
      afxn.a(this.this$0.getActivity(), this.b.idx, this.b.category, this.b.schoolName, this.b.schoolId);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvj
 * JD-Core Version:    0.7.0.1
 */