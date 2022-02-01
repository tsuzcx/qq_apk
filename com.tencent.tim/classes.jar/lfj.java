import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;

public class lfj
  implements lfh.a
{
  public lfj(VideoView paramVideoView) {}
  
  public void ns(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d("gifvideo.VideoView", 1, "install success");
      VideoView.a(this.this$0, 2);
      VideoView.a(this.this$0);
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "install fail");
    VideoView.a(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfj
 * JD-Core Version:    0.7.0.1
 */