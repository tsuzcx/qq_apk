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

class utl
  extends QQUIEventReceiver<uth, tjm>
{
  public utl(uth paramuth)
  {
    super(paramuth);
  }
  
  public void a(uth paramuth, tjm paramtjm)
  {
    if (!TextUtils.equals(paramtjm.jdField_a_of_type_JavaLangString, paramuth.c)) {}
    do
    {
      do
      {
        return;
        paramuth.b(paramuth.b);
      } while ((paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramtjm.e));
      if (paramtjm.c) {
        paramuth.a.clear();
      }
      paramtjm = paramtjm.jdField_a_of_type_JavaUtilList;
    } while (paramtjm == null);
    paramtjm = paramtjm.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramtjm.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramtjm.next();
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
        localObject1 = new tje((List)localObject1);
        ((tje)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramuth.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramuth.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return tjm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utl
 * JD-Core Version:    0.7.0.1
 */