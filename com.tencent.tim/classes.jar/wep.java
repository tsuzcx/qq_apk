import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.d;
import com.tencent.mobileqq.activity.TroopTransferActivity.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class wep
  extends acfd
{
  public wep(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.this$0.a.a(paramString) != null)) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = this.this$0.a.a(paramString);
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    Friends localFriends;
    do
    {
      return;
      localFriends = ((acff)this.this$0.app.getManager(51)).e(paramString.memberUin);
    } while (localFriends == null);
    this.this$0.a(paramString, localFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wep
 * JD-Core Version:    0.7.0.1
 */