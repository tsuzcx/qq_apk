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

class xla
  extends QQUIEventReceiver<xkw, wbh>
{
  public xla(xkw paramxkw)
  {
    super(paramxkw);
  }
  
  public void a(xkw paramxkw, wbh paramwbh)
  {
    if (!TextUtils.equals(paramwbh.jdField_a_of_type_JavaLangString, paramxkw.c)) {}
    do
    {
      do
      {
        return;
        paramxkw.b(paramxkw.b);
      } while ((paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramwbh.e));
      if (paramwbh.c) {
        paramxkw.a.clear();
      }
      paramwbh = paramwbh.jdField_a_of_type_JavaUtilList;
    } while (paramwbh == null);
    paramwbh = paramwbh.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramwbh.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramwbh.next();
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
        localObject1 = new waz((List)localObject1);
        ((waz)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramxkw.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramxkw.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return wbh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xla
 * JD-Core Version:    0.7.0.1
 */