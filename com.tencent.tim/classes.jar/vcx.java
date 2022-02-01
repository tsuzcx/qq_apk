import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class vcx
  extends acfd
{
  public vcx(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.this$0.app.getCurrentAccountUin()))) {}
    while (this.this$0.cY == null) {
      return;
    }
    paramString = this.this$0.app.a(this.this$0.app.getCurrentAccountUin(), (byte)1, false);
    this.this$0.cY.setImageBitmap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcx
 * JD-Core Version:    0.7.0.1
 */