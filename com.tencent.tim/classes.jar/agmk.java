import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgRsp;
import mqq.app.MobileQQ;

class agmk
  implements awpw<WeiyunPB.PwdVerifyMsgRsp>
{
  agmk(agmf paramagmf) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + paramInt + "],errorMsg[" + paramString + "]");
    }
    agmf.a(this.b).a().b(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    String str = awrh.g(paramPwdVerifyMsgRsp.cs_sig.get());
    if (!TextUtils.isEmpty(str)) {
      awpx.du(agmf.a(this.b).getApplication().getApplicationContext(), str);
    }
    awpx.ac(agmf.a(this.b).getApplication().getApplicationContext(), true);
    agmf.a(this.b).a().b(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmk
 * JD-Core Version:    0.7.0.1
 */