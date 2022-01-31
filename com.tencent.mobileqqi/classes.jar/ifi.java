import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QLAndQQStructDef.QQ2QlSendFileResultInfo;
import cooperation.qlink.QLAndQQStructDef.Ql2QQExtraTransInfo;
import cooperation.qlink.QLAndQQStructDef.Ql2QQRecvFileInfo;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQServiceForQlink;

public class ifi
  extends RemoteCommand
{
  public ifi(QQServiceForQlink paramQQServiceForQlink, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("Event", 0);
    QLog.d("QQServiceForQlink", 1, "[QLINK] QQ - recv qlink.notify event:" + i);
    switch (i)
    {
    default: 
      QLog.e("QQServiceForQlink", 1, "[QLINK] QQ - unimplement event[" + i + "]");
    }
    for (;;)
    {
      return null;
      paramOnInvokeFinishLinstener = paramBundle.getString("Uin");
      paramBundle = (QLAndQQStructDef.Ql2QQRecvFileInfo)paramBundle.getSerializable("FileInfo");
      QQServiceForQlink.a(this.a).a().a(paramOnInvokeFinishLinstener, paramBundle);
      continue;
      long l = paramBundle.getLong("param.sessionid");
      i = paramBundle.getInt("param.msgstatus");
      int j = paramBundle.getInt("param.msgstatuserrcode");
      int k = paramBundle.getInt("param.transextfailedcode");
      int m = paramBundle.getInt("param.transpjspeed");
      int n = paramBundle.getInt("param.transinspeed");
      int i1 = paramBundle.getInt("param.transoutspeed");
      paramOnInvokeFinishLinstener = paramBundle.getString("param.transssid");
      paramBundle = (QLAndQQStructDef.Ql2QQExtraTransInfo)paramBundle.getSerializable("param.transextrainfo");
      QQServiceForQlink.a(this.a).a().a(l, i, j, k, m, n, i1, paramOnInvokeFinishLinstener, paramBundle);
      continue;
      paramBundle = paramBundle.getString("param.uin");
      QQServiceForQlink.a(this.a).a().a(paramBundle);
      continue;
      l = paramBundle.getLong("param.sessionid");
      float f = paramBundle.getFloat("param.transprogress");
      i = paramBundle.getInt("param.transspeed");
      QQServiceForQlink.a(this.a).a().a(l, f, i);
      continue;
      l = paramBundle.getLong("param.sessionid");
      boolean bool1 = paramBundle.getBoolean("param.transresult");
      i = paramBundle.getInt("param.transfailedcode");
      paramOnInvokeFinishLinstener = paramBundle.getString("param.transfilepath");
      boolean bool2 = paramBundle.getBoolean("param.transisthumb");
      j = paramBundle.getInt("param.transpjspeed");
      k = paramBundle.getInt("param.transinspeed");
      m = paramBundle.getInt("param.transoutspeed");
      paramBundle = (QLAndQQStructDef.Ql2QQExtraTransInfo)paramBundle.getSerializable("param.transextrainfo");
      QQServiceForQlink.a(this.a).a().a(l, bool1, i, paramOnInvokeFinishLinstener, Boolean.valueOf(bool2).booleanValue(), j, k, m, paramBundle);
      continue;
      l = paramBundle.getLong("param.sessionid");
      QQServiceForQlink.a(this.a).a().a(l);
      continue;
      l = paramBundle.getLong("TOUIN");
      paramOnInvokeFinishLinstener = paramBundle.getByteArray("BODYCONTENT");
      Object localObject = paramBundle.getByteArray("TEMPSIGNATURE");
      i = paramBundle.getInt("Cookie");
      this.a.a(String.valueOf(l), 1032, paramOnInvokeFinishLinstener, (byte[])localObject, i);
      continue;
      l = paramBundle.getLong("param.sessionid");
      paramBundle = (QLAndQQStructDef.QQ2QlSendFileResultInfo)paramBundle.getSerializable("param.sendfilemsgresult");
      QQServiceForQlink.a(this.a).a().a(l, paramBundle);
      continue;
      l = paramBundle.getLong("param.sessionid");
      paramBundle = paramBundle.getString("param.uin");
      QQServiceForQlink.a(this.a).a().a(l, paramBundle);
      continue;
      l = paramBundle.getLong("param.uin");
      paramOnInvokeFinishLinstener = paramBundle.getByteArray("param.msgcontent");
      localObject = paramBundle.getByteArray("param.tempsignature");
      i = paramBundle.getInt("param.cookie");
      this.a.a(String.valueOf(l), 1033, paramOnInvokeFinishLinstener, (byte[])localObject, i);
      continue;
      i = paramBundle.getInt("param.reportnbinfotype");
      paramBundle = paramBundle.getSerializable("param.reportnbinfo");
      QQServiceForQlink.a(this.a).a().a(i, paramBundle);
      continue;
      paramOnInvokeFinishLinstener = paramBundle.getString("param.fromuin");
      localObject = paramBundle.getString("param.touin");
      paramBundle = paramBundle.getByteArray("param.tempsign");
      QQServiceForQlink.a(this.a).a().a(paramOnInvokeFinishLinstener, (String)localObject, paramBundle);
      continue;
      paramBundle = paramBundle.getString("param.uin");
      QQServiceForQlink.a(this.a).a().b(paramBundle);
      continue;
      paramBundle = paramBundle.getStringArrayList("param.qquins");
      QQServiceForQlink.a(this.a).a().a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ifi
 * JD-Core Version:    0.7.0.1
 */