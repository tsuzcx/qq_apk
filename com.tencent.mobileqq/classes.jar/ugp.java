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

class ugp
  extends QQUIEventReceiver<ugl, swq>
{
  public ugp(ugl paramugl)
  {
    super(paramugl);
  }
  
  public void a(ugl paramugl, swq paramswq)
  {
    if (!TextUtils.equals(paramswq.jdField_a_of_type_JavaLangString, paramugl.c)) {}
    do
    {
      do
      {
        return;
        paramugl.b(paramugl.b);
      } while ((paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramswq.e));
      if (paramswq.c) {
        paramugl.a.clear();
      }
      paramswq = paramswq.jdField_a_of_type_JavaUtilList;
    } while (paramswq == null);
    paramswq = paramswq.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramswq.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramswq.next();
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
        localObject1 = new swi((List)localObject1);
        ((swi)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramugl.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramugl.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return swq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugp
 * JD-Core Version:    0.7.0.1
 */