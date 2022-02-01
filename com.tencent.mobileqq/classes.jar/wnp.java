import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class wnp
  implements wng
{
  public wnp(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(wnf paramwnf)
  {
    wnd localwnd = (wnd)paramwnf;
    ((wnm)this.a.a).g = localwnd.a.a;
    ((wnm)this.a.a).h = localwnd.a.c;
    ((wnm)this.a.a).a = localwnd.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localwnd.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramwnf = str;
        if (str == null) {
          paramwnf = "0";
        }
        int i = Integer.valueOf(paramwnf).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((wnm)this.a.a).d = k;
        ((wnm)this.a.a).e = j;
      }
      catch (Exception paramwnf)
      {
        int j;
        int k;
        long l;
        yuk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramwnf);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localwnd.b);
      if (l > 0L)
      {
        yuk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((wnm)this.a.a).b), Long.valueOf(l));
        ((wnm)this.a.a).b = l;
        yuk.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((wnm)this.a.a).a(), Long.valueOf(((wnm)this.a.a).b), ((wnm)this.a.a).a);
      }
      ((wnm)this.a.a).c = zom.a(localwnd.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((wnm)this.a.a).d = j;
      ((wnm)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */