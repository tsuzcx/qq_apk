import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pyc
  extends pxe
  implements ppv.b<pzl, qas>
{
  private static ConcurrentHashMap<String, Long> ca = new ConcurrentHashMap();
  private final boolean aCz;
  public List<String> mVidList = new ArrayList();
  
  public pyc(List<String> paramList)
  {
    el(paramList);
    this.aCz = false;
  }
  
  public pyc(List<String> paramList, boolean paramBoolean)
  {
    el(paramList);
    this.aCz = paramBoolean;
  }
  
  private void el(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!StoryVideoItem.isFakeVid(str)) {
          this.mVidList.add(str);
        }
      }
    }
  }
  
  public void a(@NonNull pzl parampzl, @Nullable qas paramqas, @NonNull ErrorMessage paramErrorMessage)
  {
    pyc.a locala = new pyc.a();
    if ((paramqas == null) || (paramErrorMessage.isFail()))
    {
      notifyError();
      locala.b = paramErrorMessage;
      pmi.a().dispatch(locala);
      parampzl = parampzl.nv.iterator();
    }
    while (parampzl.hasNext())
    {
      paramqas = (String)parampzl.next();
      ca.remove(paramqas);
      continue;
      parampzl = (psu)psx.a(5);
      if (paramqas.mVideoItemList != null)
      {
        paramErrorMessage = paramqas.mVideoItemList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramqas.mVideoItemList = parampzl.al(paramqas.mVideoItemList);
      locala.mVideoList = paramqas.mVideoItemList;
      ((pmq)psx.a(28)).updateList(paramqas.nx);
      pmi.a().dispatch(locala);
      bnw();
    }
  }
  
  public void sendRequest()
  {
    Bosses.get().postLightWeightJob(new VidToBasicInfoHandler.1(this), 0);
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.mVidList + '}';
  }
  
  public static class a
    extends plt
  {
    public List<StoryVideoItem> mVideoList;
    
    public String toString()
    {
      return "GetVideoBasicInfoListEvent{, mVideoList=" + this.mVideoList + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyc
 * JD-Core Version:    0.7.0.1
 */