import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class web
  implements wds
{
  public web(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(wdr paramwdr)
  {
    wdp localwdp = (wdp)paramwdr;
    ((wdy)this.a.a).g = localwdp.a.a;
    ((wdy)this.a.a).h = localwdp.a.c;
    ((wdy)this.a.a).a = localwdp.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localwdp.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramwdr = str;
        if (str == null) {
          paramwdr = "0";
        }
        int i = Integer.valueOf(paramwdr).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((wdy)this.a.a).d = k;
        ((wdy)this.a.a).e = j;
      }
      catch (Exception paramwdr)
      {
        int j;
        int k;
        long l;
        ykq.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramwdr);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localwdp.b);
      if (l > 0L)
      {
        ykq.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((wdy)this.a.a).b), Long.valueOf(l));
        ((wdy)this.a.a).b = l;
        ykq.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((wdy)this.a.a).a(), Long.valueOf(((wdy)this.a.a).b), ((wdy)this.a.a).a);
      }
      ((wdy)this.a.a).c = zeb.a(localwdp.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((wdy)this.a.a).d = j;
      ((wdy)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     web
 * JD-Core Version:    0.7.0.1
 */