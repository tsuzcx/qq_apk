import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class ulz
  implements ulq
{
  public ulz(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(ulp paramulp)
  {
    uln localuln = (uln)paramulp;
    ((ulw)this.a.a).g = localuln.a.a;
    ((ulw)this.a.a).h = localuln.a.c;
    ((ulw)this.a.a).a = localuln.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localuln.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramulp = str;
        if (str == null) {
          paramulp = "0";
        }
        int i = Integer.valueOf(paramulp).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((ulw)this.a.a).d = k;
        ((ulw)this.a.a).e = j;
      }
      catch (Exception paramulp)
      {
        int j;
        int k;
        long l;
        wsv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramulp);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localuln.b);
      if (l > 0L)
      {
        wsv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((ulw)this.a.a).b), Long.valueOf(l));
        ((ulw)this.a.a).b = l;
        wsv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((ulw)this.a.a).a(), Long.valueOf(((ulw)this.a.a).b), ((ulw)this.a.a).a);
      }
      ((ulw)this.a.a).c = xmx.a(localuln.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((ulw)this.a.a).d = j;
      ((ulw)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ulz
 * JD-Core Version:    0.7.0.1
 */