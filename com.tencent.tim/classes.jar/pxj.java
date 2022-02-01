import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.a;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class pxj
  implements ppv.b<pyn, qaa>
{
  public void a(@NonNull pyn parampyn, @Nullable qaa paramqaa, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.i("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramqaa = (psu)psx.a(5);
    psg localpsg = new psg(paramErrorMessage, parampyn.vid, false);
    StoryVideoItem localStoryVideoItem = paramqaa.a(parampyn.vid);
    if (localStoryVideoItem != null)
    {
      localpsg.uid = localStoryVideoItem.mOwnerUid;
      localpsg.Ak = localStoryVideoItem.mVideoIndex;
      if (localpsg.Ak == 0L) {
        localpsg.Ak = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      pmi.a().dispatch(localpsg);
      return;
    }
    rx(parampyn.vid);
    paramqaa.qV(parampyn.vid);
    pmi.a().dispatch(localpsg);
  }
  
  public void qV(String paramString)
  {
    paramString = new pyn(paramString);
    ppv.a().a(paramString, this);
  }
  
  protected void rx(String paramString)
  {
    long l = System.currentTimeMillis();
    pxj.b localb = new pxj.b(0);
    psn localpsn = (psn)psx.a(19);
    Object localObject = ((psu)psx.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localpsn.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      pmi.a().dispatch(localb);
      return;
    }
    Collections.sort((List)localObject, new VideoCollectionItem.a());
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
        pmi.a().dispatch(localb);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localpsn.a((VideoCollectionItem)localObject);
          localb.mM.add(new pxj.a(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new VideoCollectionItem.b(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localpsn.a(localVideoCollectionItem);
        localb.mM.add(new pxj.a(1, localVideoCollectionItem));
      }
      for (;;)
      {
        ram.w("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localb }));
        pmi.a().dispatch(localb);
        return;
        localpsn.a((VideoCollectionItem)localObject);
        localb.mM.add(new pxj.a(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localpsn.a(localVideoCollectionItem);
        localb.mM.add(new pxj.a(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
  
  public static class a
  {
    public VideoCollectionItem a;
    public int operation;
    
    public a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
    {
      this.operation = paramInt;
      this.a = paramVideoCollectionItem;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("StateVideoCollectionItem{itemKey=").append(this.a.key).append(", operation=");
      if (this.operation == 1) {}
      for (String str = "delete";; str = "update") {
        return str + '}';
      }
    }
  }
  
  public static class b
    extends plt
  {
    public ArrayList<pxj.a> mM = new ArrayList();
    public final int source;
    
    public b(int paramInt)
    {
      this.source = paramInt;
    }
    
    public String toString()
    {
      return "UpdateMemoriesEvent{dateList=" + this.mM + ", source=" + this.source + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxj
 * JD-Core Version:    0.7.0.1
 */