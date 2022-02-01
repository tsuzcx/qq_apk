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

public class wvx
  implements wld<wyn, xal>
{
  public void a(String paramString)
  {
    paramString = new wyn(paramString);
    wlb.a().a(paramString, this);
  }
  
  public void a(@NonNull wyn paramwyn, @Nullable xal paramxal, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramxal = (wpj)wpm.a(5);
    wor localwor = new wor(paramErrorMessage, paramwyn.a, false);
    StoryVideoItem localStoryVideoItem = paramxal.a(paramwyn.a);
    if (localStoryVideoItem != null)
    {
      localwor.b = localStoryVideoItem.mOwnerUid;
      localwor.a = localStoryVideoItem.mVideoIndex;
      if (localwor.a == 0L) {
        localwor.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      wfo.a().dispatch(localwor);
      return;
    }
    b(paramwyn.a);
    paramxal.a(paramwyn.a);
    wfo.a().dispatch(localwor);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    wvz localwvz = new wvz(0);
    woz localwoz = (woz)wpm.a(19);
    Object localObject = ((wpj)wpm.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localwoz.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      wfo.a().dispatch(localwvz);
      return;
    }
    Collections.sort((List)localObject, new ygn());
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
        wfo.a().dispatch(localwvz);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localwoz.a((VideoCollectionItem)localObject);
          localwvz.a.add(new wvy(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new ygo(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localwoz.a(localVideoCollectionItem);
        localwvz.a.add(new wvy(1, localVideoCollectionItem));
      }
      for (;;)
      {
        yqp.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localwvz }));
        wfo.a().dispatch(localwvz);
        return;
        localwoz.a((VideoCollectionItem)localObject);
        localwvz.a.add(new wvy(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localwoz.a(localVideoCollectionItem);
        localwvz.a.add(new wvy(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvx
 * JD-Core Version:    0.7.0.1
 */