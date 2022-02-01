import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class ahkf
  extends jnm.d
{
  ahkf(ahkd paramahkd, long paramLong, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      bool = true;
      ahlw.x("KEY_STAGE_2_NORMAL_B77", bool);
      if (System.currentTimeMillis() - this.val$start <= 10000L) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label123;
      }
      ahkd.a(this.a, new Object[] { Integer.valueOf(0), "", acfp.m(2131706500), "" }, -6);
      return;
      bool = false;
      break;
    }
    label123:
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      if ((l == -1L) || (l != ahkd.a(this.a)))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "handleGetMessageState currentRequestTime =" + ahkd.a(this.a) + ", sendStamp = " + l);
        return;
      }
    }
    paramBundle = ForwardUtils.cz(this.bh.getInt("req_type"));
    Object localObject = ForwardUtils.cx(this.bh.getInt("uintype"));
    String str = this.bh.getString("title");
    anot.a(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, paramBundle, (String)localObject, str);
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      ahkd.a(this.a, this.bh);
    }
    paramBundle = this.a;
    localObject = ForwardUtils.a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      paramInt = -7;
    }
    ahkd.a(paramBundle, (Object[])localObject, paramInt);
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkf
 * JD-Core Version:    0.7.0.1
 */