import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class vpg
  implements vox
{
  public vpg(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(vow paramvow)
  {
    vou localvou = (vou)paramvow;
    ((vpd)this.a.a).g = localvou.a.a;
    ((vpd)this.a.a).h = localvou.a.c;
    ((vpd)this.a.a).a = localvou.b;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localvou.b);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramvow = str;
        if (str == null) {
          paramvow = "0";
        }
        int i = Integer.valueOf(paramvow).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((vpd)this.a.a).d = k;
        ((vpd)this.a.a).e = j;
      }
      catch (Exception paramvow)
      {
        int j;
        int k;
        long l;
        xvv.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", paramvow);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.a(localvou.b);
      if (l > 0L)
      {
        xvv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((vpd)this.a.a).b), Long.valueOf(l));
        ((vpd)this.a.a).b = l;
        xvv.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((vpd)this.a.a).a(), Long.valueOf(((vpd)this.a.a).b), ((vpd)this.a.a).a);
      }
      ((vpd)this.a.a).c = ypi.a(localvou.b);
      this.a.a(1, new ErrorMessage());
      return;
      ((vpd)this.a.a).d = j;
      ((vpd)this.a.a).e = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpg
 * JD-Core Version:    0.7.0.1
 */