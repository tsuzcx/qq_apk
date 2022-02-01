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

public class wqd
  implements wfk<wst, wur>
{
  public void a(String paramString)
  {
    paramString = new wst(paramString);
    wfi.a().a(paramString, this);
  }
  
  public void a(@NonNull wst paramwst, @Nullable wur paramwur, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramwur = (wjp)wjs.a(5);
    wix localwix = new wix(paramErrorMessage, paramwst.a, false);
    StoryVideoItem localStoryVideoItem = paramwur.a(paramwst.a);
    if (localStoryVideoItem != null)
    {
      localwix.b = localStoryVideoItem.mOwnerUid;
      localwix.a = localStoryVideoItem.mVideoIndex;
      if (localwix.a == 0L) {
        localwix.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      wad.a().dispatch(localwix);
      return;
    }
    b(paramwst.a);
    paramwur.a(paramwst.a);
    wad.a().dispatch(localwix);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    wqf localwqf = new wqf(0);
    wjf localwjf = (wjf)wjs.a(19);
    Object localObject = ((wjp)wjs.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localwjf.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      wad.a().dispatch(localwqf);
      return;
    }
    Collections.sort((List)localObject, new yao());
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
        wad.a().dispatch(localwqf);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localwjf.a((VideoCollectionItem)localObject);
          localwqf.a.add(new wqe(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new yap(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localwjf.a(localVideoCollectionItem);
        localwqf.a.add(new wqe(1, localVideoCollectionItem));
      }
      for (;;)
      {
        ykq.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localwqf }));
        wad.a().dispatch(localwqf);
        return;
        localwjf.a((VideoCollectionItem)localObject);
        localwqf.a.add(new wqe(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localwjf.a(localVideoCollectionItem);
        localwqf.a.add(new wqe(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */