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

public class vcl
  implements urr<vfb, vgz>
{
  public void a(String paramString)
  {
    paramString = new vfb(paramString);
    urp.a().a(paramString, this);
  }
  
  public void a(@NonNull vfb paramvfb, @Nullable vgz paramvgz, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramvgz = (uvx)uwa.a(5);
    uvf localuvf = new uvf(paramErrorMessage, paramvfb.a, false);
    StoryVideoItem localStoryVideoItem = paramvgz.a(paramvfb.a);
    if (localStoryVideoItem != null)
    {
      localuvf.b = localStoryVideoItem.mOwnerUid;
      localuvf.a = localStoryVideoItem.mVideoIndex;
      if (localuvf.a == 0L) {
        localuvf.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      umc.a().dispatch(localuvf);
      return;
    }
    b(paramvfb.a);
    paramvgz.a(paramvfb.a);
    umc.a().dispatch(localuvf);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    vcn localvcn = new vcn(0);
    uvn localuvn = (uvn)uwa.a(19);
    Object localObject = ((uvx)uwa.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localuvn.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      umc.a().dispatch(localvcn);
      return;
    }
    Collections.sort((List)localObject, new wnc());
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
        umc.a().dispatch(localvcn);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localuvn.a((VideoCollectionItem)localObject);
          localvcn.a.add(new vcm(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new wnd(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localuvn.a(localVideoCollectionItem);
        localvcn.a.add(new vcm(1, localVideoCollectionItem));
      }
      for (;;)
      {
        wxe.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localvcn }));
        umc.a().dispatch(localvcn);
        return;
        localuvn.a((VideoCollectionItem)localObject);
        localvcn.a.add(new vcm(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localuvn.a(localVideoCollectionItem);
        localvcn.a.add(new vcm(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcl
 * JD-Core Version:    0.7.0.1
 */