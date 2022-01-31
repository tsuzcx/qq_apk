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

public class tjn
  implements syt<tmd, tob>
{
  public void a(String paramString)
  {
    paramString = new tmd(paramString);
    syr.a().a(paramString, this);
  }
  
  public void a(@NonNull tmd paramtmd, @Nullable tob paramtob, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramtob = (tcz)tdc.a(5);
    tch localtch = new tch(paramErrorMessage, paramtmd.a, false);
    StoryVideoItem localStoryVideoItem = paramtob.a(paramtmd.a);
    if (localStoryVideoItem != null)
    {
      localtch.b = localStoryVideoItem.mOwnerUid;
      localtch.a = localStoryVideoItem.mVideoIndex;
      if (localtch.a == 0L) {
        localtch.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      ste.a().dispatch(localtch);
      return;
    }
    b(paramtmd.a);
    paramtob.a(paramtmd.a);
    ste.a().dispatch(localtch);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    tjp localtjp = new tjp(0);
    tcp localtcp = (tcp)tdc.a(19);
    Object localObject = ((tcz)tdc.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localtcp.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ste.a().dispatch(localtjp);
      return;
    }
    Collections.sort((List)localObject, new uue());
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
        ste.a().dispatch(localtjp);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localtcp.a((VideoCollectionItem)localObject);
          localtjp.a.add(new tjo(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new uuf(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localtcp.a(localVideoCollectionItem);
        localtjp.a.add(new tjo(1, localVideoCollectionItem));
      }
      for (;;)
      {
        veg.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localtjp }));
        ste.a().dispatch(localtjp);
        return;
        localtcp.a((VideoCollectionItem)localObject);
        localtjp.a.add(new tjo(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localtcp.a(localVideoCollectionItem);
        localtjp.a.add(new tjo(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjn
 * JD-Core Version:    0.7.0.1
 */