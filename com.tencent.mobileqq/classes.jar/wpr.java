import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class wpr
  implements Runnable
{
  wpr(wpq paramwpq) {}
  
  public void run()
  {
    if (!VideoEnvironment.e(this.a.a.app)) {
      ShortVideoResDownload.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpr
 * JD-Core Version:    0.7.0.1
 */