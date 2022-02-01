import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class ppa
  implements pos.a
{
  public ppa(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(pos parampos)
  {
    poq localpoq = (poq)parampos;
    ((pox)this.a.a).vid = localpoq.a.fileKey;
    ((pox)this.a.a).videoUrl = localpoq.a.cdnUrl;
    ((pox)this.a.a).videoLocalPath = localpoq.path;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(localpoq.path);
        String str = localMediaMetadataRetriever.extractMetadata(24);
        parampos = str;
        if (str == null) {
          parampos = "0";
        }
        int i = Integer.valueOf(parampos).intValue();
        j = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        k = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        if (i % 180 <= 0) {
          continue;
        }
        ((pox)this.a.a).videoWidth = k;
        ((pox)this.a.a).videoHeight = j;
      }
      catch (Exception parampos)
      {
        int j;
        int k;
        long l;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "format fail", parampos);
        localMediaMetadataRetriever.release();
        continue;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      l = StoryVideoUploadTask.getDurationOfVideo(localpoq.path);
      if (l > 0L)
      {
        ram.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "video old duration=%d, new duration=%d", Long.valueOf(((pox)this.a.a).videoDuration), Long.valueOf(l));
        ((pox)this.a.a).videoDuration = l;
        ram.a("Q.qqstory.publish.upload:StoryVideoUploadTask", "generate vid=%s, duration=%d mp4=%s", ((pox)this.a.a).mp(), Long.valueOf(((pox)this.a.a).videoDuration), ((pox)this.a.a).videoLocalPath);
      }
      ((pox)this.a.a).videoBytes = rox.getFileSize(localpoq.path);
      this.a.a(1, new ErrorMessage());
      return;
      ((pox)this.a.a).videoWidth = j;
      ((pox)this.a.a).videoHeight = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppa
 * JD-Core Version:    0.7.0.1
 */