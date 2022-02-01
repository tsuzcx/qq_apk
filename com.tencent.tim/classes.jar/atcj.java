import com.tencent.tim.activity.profile.host.HostProfileFragment;
import mqq.app.QQPermissionCallback;

public class atcj
  implements QQPermissionCallback
{
  public atcj(HostProfileFragment paramHostProfileFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.this$0.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    HostProfileFragment.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcj
 * JD-Core Version:    0.7.0.1
 */