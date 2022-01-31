import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class wxi
  extends Handler
{
  private WeakReference<TribeVideoPlugin> a;
  
  public wxi(TribeVideoPlugin paramTribeVideoPlugin)
  {
    this.a = new WeakReference(paramTribeVideoPlugin);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.a.get();
    Object localObject = paramMessage.obj;
    if ((localTribeVideoPlugin == null) || (localObject == null) || (!(localObject instanceof String))) {}
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
              return;
              switch (paramMessage.what)
              {
              default: 
                return;
              case 1: 
                TribeVideoPlugin.a(localTribeVideoPlugin, (String)localObject, true);
                return;
              case 2: 
                TribeVideoPlugin.a(localTribeVideoPlugin, (String)localObject, false);
                return;
              case 3: 
                paramMessage = (wxl)TribeVideoPlugin.a(localTribeVideoPlugin).get((String)localObject);
              }
            } while ((paramMessage == null) || (wxl.c(paramMessage)));
            if (QLog.isColorLevel()) {
              QLog.d("TribeVideoPlugin", 2, "sdk player is not prepared");
            }
            TribeVideoPlugin.a(localTribeVideoPlugin, (String)localObject, 5);
            wxl.b(paramMessage, true);
            return;
            paramMessage = (wxl)TribeVideoPlugin.a(localTribeVideoPlugin).get((String)localObject);
          } while (paramMessage == null);
          if ((TribeVideoPlugin.a(localTribeVideoPlugin) == 0) && (!TribeVideoPlugin.a(localTribeVideoPlugin)))
          {
            QLog.d("TribeVideoPlugin", 2, "MSG_SHOW_PLAYER_LAYOUT plugin.mPlayMode == PARAM_RESULT_PLAY_FRONT videoWrapper.mPlayerID = " + wxl.a(paramMessage));
            TribeVideoPlugin.a(localTribeVideoPlugin).bringToFront();
            TribeVideoPlugin.a(localTribeVideoPlugin, true);
          }
          TribeVideoPlugin.a(localTribeVideoPlugin, wxl.a(paramMessage), 1);
          return;
          paramMessage = (wxl)TribeVideoPlugin.a(localTribeVideoPlugin).get((String)localObject);
        } while (paramMessage == null);
        TribeVideoPlugin.a(localTribeVideoPlugin, paramMessage);
        return;
        paramMessage = (wxl)TribeVideoPlugin.a(localTribeVideoPlugin).get((String)localObject);
      } while (paramMessage == null);
      TribeVideoPlugin.b(localTribeVideoPlugin, paramMessage);
      return;
      paramMessage = (wxl)TribeVideoPlugin.a(localTribeVideoPlugin).get((String)localObject);
    } while (paramMessage == null);
    TribeVideoPlugin.c(localTribeVideoPlugin, paramMessage);
    return;
    TribeVideoPlugin.a(localTribeVideoPlugin, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wxi
 * JD-Core Version:    0.7.0.1
 */