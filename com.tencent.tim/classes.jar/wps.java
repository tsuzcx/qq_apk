import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class wps
  extends VasQuickUpdateManager.CallBacker
{
  public wps(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((1000L != paramLong) || (!"changeVoice_json".equals(paramString1))) {}
    do
    {
      return;
      if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
        QLog.d("ListenChangeVoicePanel", 2, "changeVoice jsonLoaded callBacker, errorCode=" + paramInt1);
      }
      if (paramInt1 == 0) {
        this.this$0.yL(true);
      }
    } while (paramVasQuickUpdateManager == null);
    paramVasQuickUpdateManager.removeCallBacker(this.this$0.callBacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wps
 * JD-Core Version:    0.7.0.1
 */