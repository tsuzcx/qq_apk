import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class ppb
  implements pos.a
{
  public ppb(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(pos parampos)
  {
    ((pox)this.a.a).videoThumbnailUrl = ((pon)parampos).aud;
    ram.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((pox)this.a.a).videoThumbnailUrl);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppb
 * JD-Core Version:    0.7.0.1
 */