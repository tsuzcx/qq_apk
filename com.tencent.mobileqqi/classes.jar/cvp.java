import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class cvp
  extends FriendListObserver
{
  public cvp(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.b.a()))) {}
    while (this.a.a == null) {
      return;
    }
    paramString = GesturePWDUnlockActivity.a(this.a, this.a.b.a(), true);
    this.a.a.setImageBitmap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cvp
 * JD-Core Version:    0.7.0.1
 */