import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pye
  extends pxe
  implements ppv.b<pzg, qap>
{
  protected String avR;
  protected List<String> mVidList = new ArrayList();
  
  public pye(String paramString, List<String> paramList)
  {
    this.avR = paramString;
    if (paramList != null) {
      this.mVidList.addAll(paramList);
    }
  }
  
  public void a(@NonNull pzg parampzg, @Nullable qap paramqap, @NonNull ErrorMessage paramErrorMessage)
  {
    parampzg = new pye.a();
    if ((paramqap == null) || (paramErrorMessage.isFail()))
    {
      notifyError();
      pmi.a().dispatch(parampzg);
      return;
    }
    bnw();
    paramqap.mVideoItemList = ((psu)psx.a(5)).al(paramqap.mVideoItemList);
    parampzg.collectionId = this.avR;
    paramqap = paramqap.mVideoItemList.iterator();
    while (paramqap.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramqap.next();
      paramErrorMessage = new VideoCollectionItem.b(paramErrorMessage.mVid, paramErrorMessage);
      parampzg.nb.add(paramErrorMessage);
    }
    pmi.a().dispatch(parampzg);
  }
  
  public void sendRequest()
  {
    pzg localpzg = new pzg();
    localpzg.nv = this.mVidList;
    ppv.a().a(localpzg, this);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.mVidList + ", mCollectionId=" + this.avR + '}';
  }
  
  public static class a
    extends plt
  {
    public String collectionId;
    public List<VideoCollectionItem.b> nb = new ArrayList();
    
    public String toString()
    {
      return super.toString() + " collectionId=" + this.collectionId + "mSimpleInfoList.size=" + this.nb.size() + "mSimpleInfoList=" + this.nb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pye
 * JD-Core Version:    0.7.0.1
 */