import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class wjv
  implements wjl
{
  public wjv(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(wjk paramwjk)
  {
    ((wjr)this.a.a).j = ((wjf)paramwjk).b;
    yqp.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((wjr)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjv
 * JD-Core Version:    0.7.0.1
 */