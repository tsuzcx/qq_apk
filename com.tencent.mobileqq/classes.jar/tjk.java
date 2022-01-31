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

public class tjk
  implements syq<tma, tny>
{
  public void a(String paramString)
  {
    paramString = new tma(paramString);
    syo.a().a(paramString, this);
  }
  
  public void a(@NonNull tma paramtma, @Nullable tny paramtny, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramtny = (tcw)tcz.a(5);
    tce localtce = new tce(paramErrorMessage, paramtma.a, false);
    StoryVideoItem localStoryVideoItem = paramtny.a(paramtma.a);
    if (localStoryVideoItem != null)
    {
      localtce.b = localStoryVideoItem.mOwnerUid;
      localtce.a = localStoryVideoItem.mVideoIndex;
      if (localtce.a == 0L) {
        localtce.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      stb.a().dispatch(localtce);
      return;
    }
    b(paramtma.a);
    paramtny.a(paramtma.a);
    stb.a().dispatch(localtce);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    tjm localtjm = new tjm(0);
    tcm localtcm = (tcm)tcz.a(19);
    Object localObject = ((tcw)tcz.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localtcm.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      stb.a().dispatch(localtjm);
      return;
    }
    Collections.sort((List)localObject, new uub());
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
        stb.a().dispatch(localtjm);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localtcm.a((VideoCollectionItem)localObject);
          localtjm.a.add(new tjl(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new uuc(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localtcm.a(localVideoCollectionItem);
        localtjm.a.add(new tjl(1, localVideoCollectionItem));
      }
      for (;;)
      {
        ved.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localtjm }));
        stb.a().dispatch(localtjm);
        return;
        localtcm.a((VideoCollectionItem)localObject);
        localtjm.a.add(new tjl(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localtcm.a(localVideoCollectionItem);
        localtjm.a.add(new tjl(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjk
 * JD-Core Version:    0.7.0.1
 */