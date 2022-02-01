import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wzs
  implements woy<xci, xeg>
{
  public void a(String paramString)
  {
    paramString = new xci(paramString);
    wow.a().a(paramString, this);
  }
  
  public void a(@NonNull xci paramxci, @Nullable xeg paramxeg, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramxeg = (wte)wth.a(5);
    wsm localwsm = new wsm(paramErrorMessage, paramxci.a, false);
    StoryVideoItem localStoryVideoItem = paramxeg.a(paramxci.a);
    if (localStoryVideoItem != null)
    {
      localwsm.b = localStoryVideoItem.mOwnerUid;
      localwsm.a = localStoryVideoItem.mVideoIndex;
      if (localwsm.a == 0L) {
        localwsm.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      wjj.a().dispatch(localwsm);
      return;
    }
    b(paramxci.a);
    paramxeg.a(paramxci.a);
    wjj.a().dispatch(localwsm);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    wzu localwzu = new wzu(0);
    wsu localwsu = (wsu)wth.a(19);
    Object localObject = ((wte)wth.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localwsu.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      wjj.a().dispatch(localwzu);
      return;
    }
    Collections.sort((List)localObject, new yki());
    Iterator localIterator = ((List)localObject).iterator();
    localObject = null;
    VideoCollectionItem localVideoCollectionItem;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        if (localVideoCollectionItem.collectionType == 0) {
          localObject = localVideoCollectionItem;
        } else {
          if (!localVideoCollectionItem.videoVidList.contains(paramString)) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        wjj.a().dispatch(localwzu);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localwsu.a((VideoCollectionItem)localObject);
          localwzu.a.add(new wzt(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new ykj(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localwsu.a(localVideoCollectionItem);
        localwzu.a.add(new wzt(1, localVideoCollectionItem));
      }
      for (;;)
      {
        yuk.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localwzu }));
        wjj.a().dispatch(localwzu);
        return;
        localwsu.a((VideoCollectionItem)localObject);
        localwzu.a.add(new wzt(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localwsu.a(localVideoCollectionItem);
        localwzu.a.add(new wzt(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzs
 * JD-Core Version:    0.7.0.1
 */