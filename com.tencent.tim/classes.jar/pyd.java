import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyd
  extends pxe
  implements ppv.b<pzf, qao>
{
  protected String avR;
  protected List<String> na = new ArrayList();
  
  public pyd(String paramString, List<String> paramList)
  {
    this.avR = paramString;
    if (paramList != null) {
      this.na.addAll(paramList);
    }
  }
  
  public void a(@NonNull pzf parampzf, @Nullable qao paramqao, @NonNull ErrorMessage paramErrorMessage)
  {
    pye.a locala = new pye.a();
    if ((paramqao == null) || (paramErrorMessage.isFail()))
    {
      notifyError();
      pmi.a().dispatch(locala);
      return;
    }
    ram.d("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + parampzf.nu.size() + ",content=" + parampzf.nu.toString());
    ram.d("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramqao.mVideoItemList.size() + ",content=" + paramqao.toString());
    bnw();
    paramqao.mVideoItemList = ((psu)psx.a(5)).al(paramqao.mVideoItemList);
    locala.collectionId = this.avR;
    parampzf = paramqao.mVideoItemList.iterator();
    while (parampzf.hasNext())
    {
      paramqao = (StoryVideoItem)parampzf.next();
      paramqao = new VideoCollectionItem.b(paramqao.mVid, paramqao);
      locala.nb.add(paramqao);
    }
    pmi.a().dispatch(locala);
  }
  
  public void sendRequest()
  {
    pzf localpzf = new pzf();
    localpzf.nu = this.na;
    ppv.a().a(localpzf, this);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.na + ", mCollectionId='" + this.avR + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyd
 * JD-Core Version:    0.7.0.1
 */