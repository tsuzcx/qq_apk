import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class uyo
  extends VasQuickUpdateManager.CallBacker
{
  public uyo(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((VipProfileCardDiyActivity.b(paramLong, paramString1, this.this$0.a.d.diyTextFontId)) && (paramInt1 == 0))
    {
      paramString1 = this.this$0.b.obtainMessage();
      paramString1.what = 5;
      paramString1.obj = this.this$0.a.d;
      paramString1.arg1 = 0;
      paramString1.arg2 = 17;
      this.this$0.b.sendMessage(paramString1);
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyo
 * JD-Core Version:    0.7.0.1
 */