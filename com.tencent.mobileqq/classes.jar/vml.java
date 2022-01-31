import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;

public class vml
  implements uoa
{
  public vml(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void a(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.obj = paramString;
    localMessage.what = 65543;
    FollowCaptureLauncher.a(this.a).sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    FollowCaptureLauncher.a(this.a).sendEmptyMessage(65544);
  }
  
  public void b(String paramString, int paramInt)
  {
    FollowCaptureLauncher.a(this.a).sendEmptyMessage(65544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vml
 * JD-Core Version:    0.7.0.1
 */