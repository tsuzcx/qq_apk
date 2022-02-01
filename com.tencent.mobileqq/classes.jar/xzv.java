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

class xzv
  extends QQUIEventReceiver<xzr, wqc>
{
  public xzv(xzr paramxzr)
  {
    super(paramxzr);
  }
  
  public void a(xzr paramxzr, wqc paramwqc)
  {
    if (!TextUtils.equals(paramwqc.jdField_a_of_type_JavaLangString, paramxzr.c)) {}
    do
    {
      do
      {
        return;
        paramxzr.b(paramxzr.b);
      } while ((paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramwqc.e));
      if (paramwqc.c) {
        paramxzr.a.clear();
      }
      paramwqc = paramwqc.jdField_a_of_type_JavaUtilList;
    } while (paramwqc == null);
    paramwqc = paramwqc.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramwqc.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramwqc.next();
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
        localObject1 = new wpu((List)localObject1);
        ((wpu)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramxzr.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramxzr.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return wqc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzv
 * JD-Core Version:    0.7.0.1
 */