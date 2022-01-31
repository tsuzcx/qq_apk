import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;
import com.tencent.mobileqq.widget.QQToast;

public class enm
  implements MediaRecorder.OnInfoListener
{
  public enm(VideoRecordActivity paramVideoRecordActivity) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 801: 
      QQToast.a(this.a, "录制视频大小达到上限", 1).a();
      VideoRecordActivity.c(this.a);
      return;
    }
    QQToast.a(this.a, "录制时长达到上限", 1).a();
    VideoRecordActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     enm
 * JD-Core Version:    0.7.0.1
 */