import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.util.Comparator;

public class uub
  implements Comparator<VideoCollectionItem>
{
  public int a(VideoCollectionItem paramVideoCollectionItem1, VideoCollectionItem paramVideoCollectionItem2)
  {
    if ((paramVideoCollectionItem1.collectionType != paramVideoCollectionItem2.collectionType) && (vxy.a(paramVideoCollectionItem1.collectionTime, paramVideoCollectionItem2.collectionTime))) {
      if (VideoCollectionItem.TYPE_ORDER[paramVideoCollectionItem1.collectionType] >= VideoCollectionItem.TYPE_ORDER[paramVideoCollectionItem2.collectionType]) {}
    }
    do
    {
      return -1;
      return 1;
      if (paramVideoCollectionItem1.collectionTime < paramVideoCollectionItem2.collectionTime) {
        return 1;
      }
    } while (paramVideoCollectionItem1.collectionTime > paramVideoCollectionItem2.collectionTime);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uub
 * JD-Core Version:    0.7.0.1
 */