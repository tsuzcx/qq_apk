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

public class uyc
  implements uni<vas, vcq>
{
  public void a(String paramString)
  {
    paramString = new vas(paramString);
    ung.a().a(paramString, this);
  }
  
  public void a(@NonNull vas paramvas, @Nullable vcq paramvcq, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramvcq = (uro)urr.a(5);
    uqw localuqw = new uqw(paramErrorMessage, paramvas.a, false);
    StoryVideoItem localStoryVideoItem = paramvcq.a(paramvas.a);
    if (localStoryVideoItem != null)
    {
      localuqw.b = localStoryVideoItem.mOwnerUid;
      localuqw.a = localStoryVideoItem.mVideoIndex;
      if (localuqw.a == 0L) {
        localuqw.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      uht.a().dispatch(localuqw);
      return;
    }
    b(paramvas.a);
    paramvcq.a(paramvas.a);
    uht.a().dispatch(localuqw);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    uye localuye = new uye(0);
    ure localure = (ure)urr.a(19);
    Object localObject = ((uro)urr.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localure.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      uht.a().dispatch(localuye);
      return;
    }
    Collections.sort((List)localObject, new wit());
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
        uht.a().dispatch(localuye);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localure.a((VideoCollectionItem)localObject);
          localuye.a.add(new uyd(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new wiu(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localure.a(localVideoCollectionItem);
        localuye.a.add(new uyd(1, localVideoCollectionItem));
      }
      for (;;)
      {
        wsv.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localuye }));
        uht.a().dispatch(localuye);
        return;
        localure.a((VideoCollectionItem)localObject);
        localuye.a.add(new uyd(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localure.a(localVideoCollectionItem);
        localuye.a.add(new uyd(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyc
 * JD-Core Version:    0.7.0.1
 */