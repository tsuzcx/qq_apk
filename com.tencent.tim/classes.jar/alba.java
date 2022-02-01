import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import mqq.app.QQPermissionCallback;

public class alba
  implements QQPermissionCallback
{
  public alba(CustomCoverFragment paramCustomCoverFragment, FragmentActivity paramFragmentActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.b, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CustomCoverFragment.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alba
 * JD-Core Version:    0.7.0.1
 */