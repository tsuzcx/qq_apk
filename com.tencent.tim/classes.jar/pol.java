import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.1.1.1;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;

public class pol
  implements pog.e
{
  pol(pok parampok, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void g(int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.postImmediately(new VideoCompositeManager.1.1.1(this, paramInt, paramString1, paramString2), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pol
 * JD-Core Version:    0.7.0.1
 */