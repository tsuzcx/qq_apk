import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.RestartActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class asve
  implements Handler.Callback
{
  asve(asuz paramasuz) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
      }
    }
    label452:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (asuz.a(this.this$0) == null)
              {
                QLog.e("MiniAppProxyImpl", 1, "handleMessage error, MiniAppContext is null.");
                return false;
              }
              switch (paramMessage.what)
              {
              case 4: 
              case 10: 
              default: 
                return false;
              case 2: 
                asuz.a(this.this$0).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                return false;
              case 1000: 
                this.this$0.esj();
                return false;
              case 6: 
                asuz.a(this.this$0).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                return false;
              case 7: 
                asuz.a(this.this$0).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                return false;
              case 8: 
                asuz.a(this.this$0).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                return false;
              case 13: 
                asuz.a(this.this$0).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
                return false;
              case 3: 
                paramMessage = asuz.a(this.this$0).getMiniAppInfo();
              }
            } while (paramMessage == null);
            if (DebugUtil.getDebugEnabled(paramMessage)) {
              DebugUtil.setDebugEnabled(paramMessage, false);
            }
            for (;;)
            {
              asuz.exitProcess(asuz.a(this.this$0));
              return false;
              DebugUtil.setDebugEnabled(paramMessage, true);
            }
            asuz.access$102(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(asuz.a(this.this$0)).booleanValue());
            return false;
            paramMessage = asuz.a(this.this$0).getMiniAppInfo();
          } while (paramMessage == null);
          int i;
          asuz localasuz;
          IMiniAppContext localIMiniAppContext;
          if (paramMessage.topType == 0)
          {
            i = 1;
            paramMessage.topType = i;
            asuz.a(this.this$0, paramMessage);
            localasuz = this.this$0;
            localIMiniAppContext = asuz.a(this.this$0);
            if (paramMessage.topType != 1) {
              break label452;
            }
          }
          for (paramMessage = "settop_on";; paramMessage = "settop_off")
          {
            asuz.a(localasuz, localIMiniAppContext, paramMessage);
            return false;
            i = 0;
            break;
          }
          paramMessage = asuz.a(this.this$0).getAttachedActivity();
        } while ((paramMessage == null) || (asuz.a(this.this$0).getMiniAppInfo() == null));
        aswu.a(paramMessage, asuz.a(this.this$0).getMiniAppInfo());
        asuz.a(this.this$0, asuz.a(this.this$0), "add_desktop");
        return false;
        asuz.a(this.this$0, asuz.a(this.this$0));
        return false;
        paramMessage = asuz.a(this.this$0).getMiniAppInfo();
        if ((paramMessage == null) || (!paramMessage.isEngineTypeMiniApp())) {
          break;
        }
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      } while (!(paramMessage instanceof aswg));
      paramMessage = (aswg)paramMessage;
      asuz.a(this.this$0, paramMessage.getColorNoteController());
      return false;
    } while (!(asuz.a(this.this$0).getAttachedActivity() instanceof GameActivity1));
    paramMessage = ((GameActivity1)asuz.a(this.this$0).getAttachedActivity()).getColorNoteController();
    asuz.a(this.this$0, paramMessage);
    return false;
    asuz.a(this.this$0).performAction(ActionBridge.RestartActionBridge.obtain());
    return false;
    asuz.b(this.this$0, asuz.a(this.this$0));
    return false;
    asuz.c(this.this$0, asuz.a(this.this$0));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asve
 * JD-Core Version:    0.7.0.1
 */