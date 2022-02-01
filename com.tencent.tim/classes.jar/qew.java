import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher.1;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher.a;

public class qew
  implements ayzv.a
{
  public qew(FollowCaptureLauncher.1 param1) {}
  
  public void onDownloadError()
  {
    FollowCaptureLauncher.a(this.a.this$0).sendEmptyMessage(65542);
  }
  
  public void onDownloadSuccess()
  {
    FollowCaptureLauncher.a(this.a.this$0).sendEmptyMessage(65541);
  }
  
  public void onProgress(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qew
 * JD-Core Version:    0.7.0.1
 */