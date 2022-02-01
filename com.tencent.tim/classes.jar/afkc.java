import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import mqq.util.WeakReference;

class afkc
  extends VasQuickUpdateManager.CallBacker
{
  afkc(afkb paramafkb) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    paramString2 = (QQAppInterface)this.this$0.K.get();
    if (paramString2 == null) {}
    while (!"emoji_app_vip_emoji_aio_android_config.json".equals(paramString1)) {
      return;
    }
    ((VasQuickUpdateManager)paramString2.getManager(184)).removeCallBacker(this.this$0.g);
    paramString1 = VasQuickUpdateManager.getJSONFromLocal(paramString2, "emoji_app_vip_emoji_aio_android_config.json", false, null);
    this.this$0.bd(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkc
 * JD-Core Version:    0.7.0.1
 */