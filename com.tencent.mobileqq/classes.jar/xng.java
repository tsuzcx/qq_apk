import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

class xng
  implements Runnable
{
  xng(xnf paramxnf) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.a(this.a.a) != null)
    {
      EditLocalVideoActivity.a(this.a.a).seekTo(0);
      EditLocalVideoActivity.a(this.a.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */