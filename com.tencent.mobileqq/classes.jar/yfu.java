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

class yfu
  extends QQUIEventReceiver<yfq, wvw>
{
  public yfu(yfq paramyfq)
  {
    super(paramyfq);
  }
  
  public void a(yfq paramyfq, wvw paramwvw)
  {
    if (!TextUtils.equals(paramwvw.jdField_a_of_type_JavaLangString, paramyfq.c)) {}
    do
    {
      do
      {
        return;
        paramyfq.b(paramyfq.b);
      } while ((paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramwvw.e));
      if (paramwvw.c) {
        paramyfq.a.clear();
      }
      paramwvw = paramwvw.jdField_a_of_type_JavaUtilList;
    } while (paramwvw == null);
    paramwvw = paramwvw.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramwvw.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramwvw.next();
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
        localObject1 = new wvo((List)localObject1);
        ((wvo)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramyfq.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramyfq.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return wvw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfu
 * JD-Core Version:    0.7.0.1
 */