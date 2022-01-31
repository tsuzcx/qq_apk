import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.richstatus.IIconListener;

public class wsy
  implements IIconListener
{
  private wsy(FriendFragment paramFriendFragment) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((FriendFragment.b(this.a)) && (paramBitmap != null) && (paramInt2 == 200)) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsy
 * JD-Core Version:    0.7.0.1
 */