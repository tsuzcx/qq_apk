import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class wec
  implements wds
{
  public wec(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(wdr paramwdr)
  {
    ((wdy)this.a.a).j = ((wdm)paramwdr).b;
    ykq.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((wdy)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wec
 * JD-Core Version:    0.7.0.1
 */