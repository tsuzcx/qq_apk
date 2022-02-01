import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import friendlist.GetOnlineInfoResp;

public class gfj
  extends FriendListObserver
{
  public gfj(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.a(this.a)))) {
      this.a.runOnUiThread(new gfk(this));
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.runOnUiThread(new gfl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfj
 * JD-Core Version:    0.7.0.1
 */