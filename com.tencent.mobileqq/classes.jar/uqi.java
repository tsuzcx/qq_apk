import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class uqi
  implements upz
{
  public uqi(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(upy paramupy)
  {
    upw localupw = (upw)paramupy;
    ((uqf)this.a.a).g = localupw.a.a;
    ((uqf)this.a.a).h = localupw.a.c;
    ((uqf)this.a.a).a = localupw.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localupw.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramupy = str;
        if (str == null) {
          paramupy = "0";
        }
        int i = Integer.valueOf(paramupy).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((uqf)this.a.a).d = k;
        ((uqf)this.a.a).e = j;
      }
      catch (Exception paramupy)
      {
        int j;
        int k;
        long l;
        wxe.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramupy);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localupw.b);
      if (l > 0L)
      {
        wxe.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((uqf)this.a.a).b), Long.valueOf(l));
        ((uqf)this.a.a).b = l;
        wxe.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((uqf)this.a.a).a(), Long.valueOf(((uqf)this.a.a).b), ((uqf)this.a.a).a);
      }
      ((uqf)this.a.a).c = xrg.a(localupw.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((uqf)this.a.a).d = j;
      ((uqf)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqi
 * JD-Core Version:    0.7.0.1
 */