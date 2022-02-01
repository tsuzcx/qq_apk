import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class wju
  implements wjl
{
  public wju(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(wjk paramwjk)
  {
    wji localwji = (wji)paramwjk;
    ((wjr)this.a.a).g = localwji.a.a;
    ((wjr)this.a.a).h = localwji.a.c;
    ((wjr)this.a.a).a = localwji.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localwji.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramwjk = str;
        if (str == null) {
          paramwjk = "0";
        }
        int i = Integer.valueOf(paramwjk).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((wjr)this.a.a).d = k;
        ((wjr)this.a.a).e = j;
      }
      catch (Exception paramwjk)
      {
        int j;
        int k;
        long l;
        yqp.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramwjk);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localwji.b);
      if (l > 0L)
      {
        yqp.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((wjr)this.a.a).b), Long.valueOf(l));
        ((wjr)this.a.a).b = l;
        yqp.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((wjr)this.a.a).a(), Long.valueOf(((wjr)this.a.a).b), ((wjr)this.a.a).a);
      }
      ((wjr)this.a.a).c = zkr.a(localwji.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((wjr)this.a.a).d = j;
      ((wjr)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wju
 * JD-Core Version:    0.7.0.1
 */