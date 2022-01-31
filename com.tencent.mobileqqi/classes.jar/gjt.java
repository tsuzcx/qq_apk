import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import friendlist.GetOnlineInfoResp;

public class gjt
  extends FriendListObserver
{
  public gjt(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.a(this.a)))) {
      this.a.runOnUiThread(new gju(this));
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.runOnUiThread(new gjv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjt
 * JD-Core Version:    0.7.0.1
 */