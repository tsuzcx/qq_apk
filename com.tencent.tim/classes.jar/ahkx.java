import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class ahkx
  extends jnm.d
{
  ahkx(ahkr paramahkr, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ahlw.x("KEY_STAGE_2_IMAGE_B77", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "handleGetMessageState currentRequestTime =", Long.valueOf(ahkr.a(this.this$0)), ", sendStamp = ", Long.valueOf(l) });
      if ((l != -1L) && (l == ahkr.a(this.this$0))) {
        break;
      }
      ahkr.a(this.this$0, ahkr.access$200(), this.val$key);
      return;
    }
    anot.a(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, "4", this.bKN, this.val$title);
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "大图发送消息后客户端收到回调=0X8009C94, errorCode=", Integer.valueOf(paramInt), ", fileType=4, toType=", this.bKN, ", title=", this.val$title });
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
      ahkr.a(this.this$0, (String)paramArrayOfByte[2], this.val$key);
      return;
    }
    ahkr.a(this.this$0, "", this.val$key);
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkx
 * JD-Core Version:    0.7.0.1
 */