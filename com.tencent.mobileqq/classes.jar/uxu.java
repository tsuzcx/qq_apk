import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Comparator;

public class uxu
  implements Comparator<StoryVideoItem>
{
  private boolean a;
  
  public uxu(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    int j = 1;
    int i = -1;
    if (paramStoryVideoItem1.isUploadFail() == paramStoryVideoItem2.isUploadFail()) {
      if (paramStoryVideoItem1.mCreateTime == paramStoryVideoItem2.mCreateTime) {
        i = 0;
      }
    }
    do
    {
      do
      {
        return i;
        if (paramStoryVideoItem1.mCreateTime <= paramStoryVideoItem2.mCreateTime) {
          break;
        }
        i = j;
      } while (this.a);
      return -1;
      if (this.a) {}
      for (;;)
      {
        return i;
        i = 1;
      }
      if (!paramStoryVideoItem1.isUploadFail()) {
        break;
      }
      i = j;
    } while (this.a);
    return -1;
    if (paramStoryVideoItem2.isUploadFail())
    {
      if (this.a) {}
      for (;;)
      {
        return i;
        i = 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxu
 * JD-Core Version:    0.7.0.1
 */