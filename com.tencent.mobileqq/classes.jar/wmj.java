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

class wmj
  extends QQUIEventReceiver<wmf, vck>
{
  public wmj(wmf paramwmf)
  {
    super(paramwmf);
  }
  
  public void a(wmf paramwmf, vck paramvck)
  {
    if (!TextUtils.equals(paramvck.jdField_a_of_type_JavaLangString, paramwmf.c)) {}
    do
    {
      do
      {
        return;
        paramwmf.b(paramwmf.b);
      } while ((paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramvck.e));
      if (paramvck.c) {
        paramwmf.a.clear();
      }
      paramvck = paramvck.jdField_a_of_type_JavaUtilList;
    } while (paramvck == null);
    paramvck = paramvck.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramvck.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramvck.next();
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
        localObject1 = new vcc((List)localObject1);
        ((vcc)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramwmf.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramwmf.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return vck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmj
 * JD-Core Version:    0.7.0.1
 */