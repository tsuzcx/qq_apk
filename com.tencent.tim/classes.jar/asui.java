import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class asui
  implements DialogInterface.OnClickListener
{
  public asui(ColorNotePlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      this.a.val$finalColorNoteController.insertColorNote();
      if (asuh.a(this.a.this$0))
      {
        paramDialogInterface = new asuj(this);
        if ((asuh.b(this.a.this$0).getAttachedActivity() != null) && ((asuh.c(this.a.this$0).getAttachedActivity() instanceof GameActivity1))) {
          ((GameActivity1)asuh.d(this.a.this$0).getAttachedActivity()).setColorSignAddListener(paramDialogInterface);
        }
      }
      else
      {
        this.a.val$req.ok();
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ColorNotePlugin", 1, "show modalView error." + paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asui
 * JD-Core Version:    0.7.0.1
 */