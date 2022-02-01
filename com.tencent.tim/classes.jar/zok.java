import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import friendlist.GetOnlineInfoResp;

class zok
  extends acfd
{
  zok(zof paramzof) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.this$0.mSessionInfo.aTl)) {
      this.this$0.bFq();
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.this$0.bFq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zok
 * JD-Core Version:    0.7.0.1
 */