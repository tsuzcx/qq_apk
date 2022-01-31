import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class uti
  extends QQUIEventReceiver<ute, tjj>
{
  public uti(ute paramute)
  {
    super(paramute);
  }
  
  public void a(ute paramute, tjj paramtjj)
  {
    if (!TextUtils.equals(paramtjj.jdField_a_of_type_JavaLangString, paramute.c)) {}
    do
    {
      do
      {
        return;
        paramute.b(paramute.b);
      } while ((paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramtjj.e));
      if (paramtjj.c) {
        paramute.a.clear();
      }
      paramtjj = paramtjj.jdField_a_of_type_JavaUtilList;
    } while (paramtjj == null);
    paramtjj = paramtjj.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramtjj.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramtjj.next();
      localObject1 = new ArrayList();
      localArrayList = new ArrayList(localVideoCollectionItem.videoVidList);
      localObject2 = new ArrayList();
      Iterator localIterator = localVideoCollectionItem.videoItemList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject2).add(((StoryVideoItem)localIterator.next()).mVid);
      }
      localArrayList.removeAll((Collection)localObject2);
    }
    int j;
    for (int i = 0;; i = j)
    {
      if (i < localArrayList.size())
      {
        j = Math.min(localArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        localObject1 = new tjb((List)localObject1);
        ((tjb)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramute.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramute.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return tjj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uti
 * JD-Core Version:    0.7.0.1
 */