import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.activity.profile.host.HostProfileFragment;

public class atcg
  implements accv.b
{
  public atcg(HostProfileFragment paramHostProfileFragment) {}
  
  public void D(int paramInt, boolean paramBoolean)
  {
    if ((this.this$0.bHl == 1) || (this.this$0.bHl == 2))
    {
      if (paramBoolean) {
        break label61;
      }
      HostProfileFragment.a(this.this$0);
      QQToast.a(this.this$0.getActivity(), 2131691963, 0).show(this.this$0.getActivity().getTitleBarHeight());
    }
    label61:
    while (paramInt != 2) {
      return;
    }
    HostProfileFragment.a(this.this$0);
    HostProfileFragment.a(this.this$0, this.this$0.bHl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcg
 * JD-Core Version:    0.7.0.1
 */