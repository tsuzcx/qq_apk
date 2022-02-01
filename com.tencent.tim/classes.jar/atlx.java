import android.os.Handler;
import android.os.Message;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity.b;

public class atlx
  extends Handler
{
  public atlx(CloudPhotoListActivity paramCloudPhotoListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    CloudPhotoListActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlx
 * JD-Core Version:    0.7.0.1
 */