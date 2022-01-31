import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.qphone.base.util.QLog;

public class vlv
  extends BroadcastReceiver
{
  public vlv(PhotoListPanel paramPhotoListPanel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "ACTION_SCREEN_OFF == >>");
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlv
 * JD-Core Version:    0.7.0.1
 */