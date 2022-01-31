import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class wsw
  implements Runnable
{
  wsw(wsv paramwsv) {}
  
  public void run()
  {
    if (!VideoEnvironment.e(this.a.a.app)) {
      ShortVideoResDownload.a(this.a.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsw
 * JD-Core Version:    0.7.0.1
 */