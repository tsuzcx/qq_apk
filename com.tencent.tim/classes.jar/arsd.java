import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.open.agent.OpenSelectPermissionFragment.4.1;
import com.tencent.qphone.base.util.QLog;

public class arsd
  extends artd
{
  public arsd(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, arte paramarte)
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize activity is null");
      return;
    }
    this.this$0.getActivity().runOnUiThread(new OpenSelectPermissionFragment.4.1(this, paramBoolean, paramarte, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsd
 * JD-Core Version:    0.7.0.1
 */