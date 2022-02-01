import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.leba.QzoneFrame;

public class zjr
  extends BroadcastReceiver
{
  public zjr(QzoneFrame paramQzoneFrame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QzoneFrame.a(this.this$0) != null) {
      ((avsr)QzoneFrame.a(this.this$0)).updatePublishBox(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjr
 * JD-Core Version:    0.7.0.1
 */