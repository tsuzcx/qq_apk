import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollectionID;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyb
  extends pxe
  implements ppv.b<pzt, qaz>
{
  protected List<pyb.a> gJ = new ArrayList();
  protected String mUin;
  
  public pyb(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void a(@NonNull pzt parampzt, @Nullable qaz paramqaz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramqaz != null))
    {
      parampzt = new pxj.b(1);
      paramErrorMessage = (psn)psx.a(19);
      paramqaz = paramqaz.nH;
      Object localObject1 = paramqaz.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new pxj.a(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        parampzt.mM.add(localObject2);
      }
      paramErrorMessage = (qvf)psx.a(11);
      localObject1 = new ArrayList(paramqaz.size());
      paramqaz = paramqaz.iterator();
      while (paramqaz.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramqaz.next();
        if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
        {
          VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramErrorMessage.a(((VideoCollectionItem)localObject2).feedId);
          if (localVideoListFeedItem != null)
          {
            localVideoListFeedItem.mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
            ((ArrayList)localObject1).add(localVideoListFeedItem);
          }
        }
      }
      paramErrorMessage.au((List)localObject1);
      pmi.a().dispatch(parampzt);
    }
  }
  
  public void ek(List<pyb.a> paramList)
  {
    this.gJ.clear();
    this.gJ.addAll(paramList);
  }
  
  public void sendRequest()
  {
    pzt localpzt = new pzt();
    localpzt.gJ = this.gJ;
    localpzt.mUin = this.mUin;
    ppv.a().a(localpzt, this);
  }
  
  public static class a
  {
    public int bln;
    public int collectionType;
    
    public qqstory_struct.DateVideoCollectionID a()
    {
      qqstory_struct.DateVideoCollectionID localDateVideoCollectionID = new qqstory_struct.DateVideoCollectionID();
      localDateVideoCollectionID.collection_id.set(this.bln);
      localDateVideoCollectionID.collection_type.set(this.collectionType);
      return localDateVideoCollectionID;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyb
 * JD-Core Version:    0.7.0.1
 */