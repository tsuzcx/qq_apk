import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

class avcl
  extends acje
{
  avcl(avcj paramavcj, Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener) {}
  
  public void m(boolean paramBoolean, String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSuccess", paramBoolean);
    ((Bundle)localObject).putString("uin", paramString);
    this.N.putAll((Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("publicAccount.followUin, isSuccess=").append(paramBoolean).append("; result=");
      if (this.N == null) {
        break label108;
      }
    }
    label108:
    for (paramString = this.N.toString();; paramString = "null")
    {
      QLog.d("BuscardPluginRemoteCommand", 2, paramString);
      if (this.c != null) {
        this.c.onInvokeFinish(this.N);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcl
 * JD-Core Version:    0.7.0.1
 */