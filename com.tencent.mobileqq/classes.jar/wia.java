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

class wia
  extends QQUIEventReceiver<whw, uyb>
{
  public wia(whw paramwhw)
  {
    super(paramwhw);
  }
  
  public void a(whw paramwhw, uyb paramuyb)
  {
    if (!TextUtils.equals(paramuyb.jdField_a_of_type_JavaLangString, paramwhw.c)) {}
    do
    {
      do
      {
        return;
        paramwhw.b(paramwhw.b);
      } while ((paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (!paramuyb.e));
      if (paramuyb.c) {
        paramwhw.a.clear();
      }
      paramuyb = paramuyb.jdField_a_of_type_JavaUtilList;
    } while (paramuyb == null);
    paramuyb = paramuyb.iterator();
    label72:
    VideoCollectionItem localVideoCollectionItem;
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramuyb.hasNext())
    {
      localVideoCollectionItem = (VideoCollectionItem)paramuyb.next();
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
        localObject1 = new uxt((List)localObject1);
        ((uxt)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
        paramwhw.a.put(localVideoCollectionItem.collectionId, localObject1);
        break label72;
        break;
      }
      localObject2 = localArrayList.subList(i, j);
      ((List)localObject1).add(paramwhw.a(localVideoCollectionItem.collectionId, (List)localObject2));
    }
  }
  
  public Class acceptEventClass()
  {
    return uyb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wia
 * JD-Core Version:    0.7.0.1
 */