import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afvi
  implements View.OnClickListener
{
  public afvi(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getActivity() != null)
    {
      String str = "";
      if (this.this$0.getActivity().app != null) {
        str = ((afsi)this.this$0.getActivity().app.getManager(264)).uG();
      }
      afxn.E(this.this$0.getActivity(), str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvi
 * JD-Core Version:    0.7.0.1
 */