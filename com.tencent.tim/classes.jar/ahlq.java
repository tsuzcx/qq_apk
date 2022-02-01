import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahlq
  extends jnm.d
{
  ahlq(ahlj paramahlj, Bundle paramBundle) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ahlw.x("KEY_STAGE_2_NORMAL_B77", bool);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(ahlj.a(this.this$0)), ", isFirstShow =", Boolean.valueOf(ahlj.b(this.this$0)) });
      if (ahlj.b(this.this$0)) {
        break;
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isFirstShow =" + ahlj.b(this.this$0));
      return;
    }
    if (ahlj.a(this.this$0))
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for isTimeOut =" + ahlj.a(this.this$0));
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xb77_9_sendTime", -1L);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage currentRequestTime =" + ahlj.b(this.this$0) + ", sendStamp = " + l);
      if ((l == -1L) || (l != ahlj.b(this.this$0)))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage return for sendStamp");
        return;
      }
    }
    ahlj.a(this.this$0, true);
    paramBundle = ForwardUtils.a(paramArrayOfByte);
    int i = ((Integer)paramBundle[0]).intValue();
    String str1 = (String)paramBundle[1];
    String str2 = (String)paramBundle[2];
    String str3 = (String)paramBundle[3];
    ahlj.a(this.this$0).removeMessages(94);
    this.this$0.dow();
    paramBundle = ahlj.a(this.this$0);
    String str4 = ForwardUtils.cz(ahlj.a(this.this$0).getInt("req_type"));
    String str5 = ForwardUtils.cx(ahlj.a(this.this$0).getInt("uintype"));
    if ((paramBundle instanceof AbsShareMsg)) {}
    for (paramBundle = ((AbsShareMsg)paramBundle).mContentTitle;; paramBundle = "")
    {
      anot.a(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, str4, str5, paramBundle);
      if ((paramInt == 0) && (paramArrayOfByte != null)) {
        break;
      }
      ahlj.a(this.this$0, paramInt, str2, str3);
      return;
    }
    if (i != 0) {
      ahlj.b(this.this$0, str1);
    }
    for (;;)
    {
      ahlj.c(this.this$0, this.bh.getString("share_comment_message_for_server"));
      return;
      ahlj.a(this.this$0);
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QLog.isColorLevel())) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlq
 * JD-Core Version:    0.7.0.1
 */