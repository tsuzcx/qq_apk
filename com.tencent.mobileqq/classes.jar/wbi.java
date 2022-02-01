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

public class wbi
  implements vqp<wdy, wfw>
{
  public void a(String paramString)
  {
    paramString = new wdy(paramString);
    vqn.a().a(paramString, this);
  }
  
  public void a(@NonNull wdy paramwdy, @Nullable wfw paramwfw, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramwfw = (vuu)vux.a(5);
    vuc localvuc = new vuc(paramErrorMessage, paramwdy.a, false);
    StoryVideoItem localStoryVideoItem = paramwfw.a(paramwdy.a);
    if (localStoryVideoItem != null)
    {
      localvuc.b = localStoryVideoItem.mOwnerUid;
      localvuc.a = localStoryVideoItem.mVideoIndex;
      if (localvuc.a == 0L) {
        localvuc.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      vli.a().dispatch(localvuc);
      return;
    }
    b(paramwdy.a);
    paramwfw.a(paramwdy.a);
    vli.a().dispatch(localvuc);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    wbk localwbk = new wbk(0);
    vuk localvuk = (vuk)vux.a(19);
    Object localObject = ((vuu)vux.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localvuk.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      vli.a().dispatch(localwbk);
      return;
    }
    Collections.sort((List)localObject, new xlt());
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
        vli.a().dispatch(localwbk);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localvuk.a((VideoCollectionItem)localObject);
          localwbk.a.add(new wbj(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new xlu(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localvuk.a(localVideoCollectionItem);
        localwbk.a.add(new wbj(1, localVideoCollectionItem));
      }
      for (;;)
      {
        xvv.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localwbk }));
        vli.a().dispatch(localwbk);
        return;
        localvuk.a((VideoCollectionItem)localObject);
        localwbk.a.add(new wbj(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localvuk.a(localVideoCollectionItem);
        localwbk.a.add(new wbj(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbi
 * JD-Core Version:    0.7.0.1
 */