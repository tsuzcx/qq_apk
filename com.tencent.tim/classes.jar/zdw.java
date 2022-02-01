import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class zdw
  extends jnm.d
{
  zdw(zdf paramzdf) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((zdf.a(this.this$0).isFinishing()) || (this.this$0.aRg))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.this$0.hideProgressDialog();
    if (zdf.a(this.this$0) != null) {
      zdf.a(this.this$0).removeCallbacks(zdf.b(this.this$0));
    }
    if (paramInt == 16)
    {
      this.this$0.bFG();
      return;
    }
    zdf.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdw
 * JD-Core Version:    0.7.0.1
 */