import android.os.Message;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher.a;

public class qex
  implements pno.a
{
  public qex(FollowCaptureLauncher paramFollowCaptureLauncher) {}
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    FollowCaptureLauncher.a(this.this$0).sendEmptyMessage(65544);
  }
  
  public void bj(String paramString, int paramInt)
  {
    FollowCaptureLauncher.a(this.this$0).sendEmptyMessage(65544);
  }
  
  public void onSuccess(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.obj = paramString;
    localMessage.what = 65543;
    FollowCaptureLauncher.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qex
 * JD-Core Version:    0.7.0.1
 */