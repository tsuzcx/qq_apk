import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class xsd
  extends BroadcastReceiver
{
  public xsd(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "receive videochat in aiogallery");
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsd
 * JD-Core Version:    0.7.0.1
 */