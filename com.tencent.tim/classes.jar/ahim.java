import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class ahim
  extends jnm.d
{
  ahim(ahij paramahij) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ahlw.x("KEY_STAGE_2_IMAGE_DC2", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(ahij.access$000(), 2, new Object[] { "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(ahij.a(this.this$0)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l != -1L) && (l == ahij.a(this.this$0))) {
        break;
      }
      ahij.a(this.this$0);
      return;
    }
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(ahij.access$000(), 1, new Object[] { "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      ahij.a(this.this$0);
      return;
    }
    ahij.a(this.this$0, paramArrayOfByte);
    ForwardUtils.a(ahij.a(this.this$0), paramArrayOfByte, ahij.a(this.this$0), ahij.a(this.this$0).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(ahij.access$000(), 1, "notifyImageSendMessage onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahim
 * JD-Core Version:    0.7.0.1
 */