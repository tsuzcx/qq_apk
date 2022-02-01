import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class asvk
  implements IActivityResultListener
{
  asvk(asuz paramasuz) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    asuz.a(this.this$0, false);
    if (paramInt2 != -1)
    {
      QLog.w("MiniAppProxyImpl", 1, "onShareActivityResult, resultCode not Activity.RESULT_OK, but " + paramInt2);
      return true;
    }
    paramInt1 = paramIntent.getIntExtra("clickID", -1);
    String str = "";
    switch (paramInt1)
    {
    default: 
      paramIntent = str;
    }
    for (;;)
    {
      asuz.a(this.this$0, asuz.a(this.this$0), paramIntent);
      ActionBridge.UpdateUIActionBridge.updateRedDot(asuz.a(this.this$0));
      return true;
      asuz.a(this.this$0).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      asuz.a(this.this$0).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      asuz.a(this.this$0).sendMessage(localMessage);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      asuz.a(this.this$0).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      asuz.a(this.this$0).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      asuz.a(this.this$0).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(14);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(15);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(16);
      paramIntent = str;
      continue;
      asuz.a(this.this$0).sendEmptyMessage(17);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */