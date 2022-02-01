import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.tim.activity.profile.host.HostProfileFragment;
import mqq.app.QQPermissionCallback;

class atci
  implements QQPermissionCallback
{
  atci(atch paramatch) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.a.this$0.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    HostProfileFragment.a(this.a.this$0, ProfileActivity.a(this.a.this$0.getActivity(), 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atci
 * JD-Core Version:    0.7.0.1
 */