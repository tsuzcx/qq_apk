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

class yjp
  extends QQUIEventReceiver<yjl, wzr>
{
  public yjp(yjl paramyjl)
  {
    super(paramyjl);
  }
  
  public void a(yjl paramyjl, wzr paramwzr)
  {
    if (!TextUtils.equals(paramwzr.jdField_a_of_type_JavaLangString, paramyjl.c)) {}
    do
    {
      do
      {
        return;
        paramyjl.b(paramyjl.b);
      } while ((paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramwzr.e));
      if (paramwzr.c) {
        paramyjl.a.clear();
      }
      paramwzr = paramwzr.jdField_a_of_type_JavaUtilList;
    } while (paramwzr == null);
    paramwzr = paramwzr.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramwzr.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramwzr.next();
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
        localObject1 = new wzj((List)localObject1);
        ((wzj)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramyjl.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramyjl.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return wzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */