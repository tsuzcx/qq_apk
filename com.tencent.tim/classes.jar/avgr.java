import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;

public class avgr
  extends RemoteCommand
{
  private QQAppInterface mApp;
  
  public avgr(QQAppInterface paramQQAppInterface)
  {
    super("common.get_qq_app_interface_data");
    this.mApp = paramQQAppInterface;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    switch (i)
    {
    default: 
      return paramOnInvokeFinishLinstener;
    case 1: 
      paramBundle = paramBundle.getString("param_uin");
      paramOnInvokeFinishLinstener.putString("result_key", aqgv.n(this.mApp, paramBundle));
      return paramOnInvokeFinishLinstener;
    }
    String str = paramBundle.getString("param_uin");
    boolean bool = paramBundle.getBoolean("param_fetch_if_not_exist", false);
    paramOnInvokeFinishLinstener.putString("result_key", aqgv.b(this.mApp, str, bool));
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgr
 * JD-Core Version:    0.7.0.1
 */