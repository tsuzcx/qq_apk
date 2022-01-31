import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class cpj
  extends FriendListObserver
{
  public cpj(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
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
 * Qualified Name:     cpj
 * JD-Core Version:    0.7.0.1
 */