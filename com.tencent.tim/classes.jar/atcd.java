import android.support.v4.app.FragmentActivity;
import com.tencent.tim.activity.profile.host.HostProfileFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class atcd
  implements Function1<Boolean, Unit>
{
  public atcd(HostProfileFragment paramHostProfileFragment) {}
  
  public Unit a(Boolean paramBoolean)
  {
    if ((this.this$0.aWO) && (this.this$0.I != null))
    {
      this.this$0.I.dismiss();
      this.this$0.I = null;
      if (!this.this$0.getActivity().isFinishing()) {
        this.this$0.getActivity().finish();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcd
 * JD-Core Version:    0.7.0.1
 */