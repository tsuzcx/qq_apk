import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler.1;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pxk
  extends pxe
  implements ppv.b
{
  public static ConcurrentHashMap<String, Long> bZ = new ConcurrentHashMap();
  public qvf a;
  private final boolean aCz;
  public List<String> mM = new ArrayList();
  public List<String> mN = new ArrayList();
  
  public pxk(@NonNull List<String> paramList)
  {
    this.mM.addAll(paramList);
    this.a = ((qvf)psx.a(11));
    this.aCz = false;
  }
  
  public pxk(@NonNull List<String> paramList, boolean paramBoolean)
  {
    this.mM.addAll(paramList);
    this.a = ((qvf)psx.a(11));
    this.aCz = paramBoolean;
  }
  
  public static void ei(@NonNull List<String> paramList)
  {
    int j = paramList.size();
    int k = (int)Math.ceil(j / 5.0D);
    int i = 0;
    while (i < k)
    {
      new pxk(paramList.subList(i * 5, Math.min((i + 1) * 5, j))).sendRequest();
      i += 1;
    }
  }
  
  private void ej(List<ptp> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ptp localptp = (ptp)paramList.next();
      FeedItem localFeedItem = this.a.a(localptp.feedId);
      if (localFeedItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "null feedItem when saving feed feature...feedId=", localptp.feedId });
        }
      }
      else
      {
        localFeedItem.convertFromFeedFeature(localptp);
        localArrayList.add(localFeedItem);
      }
    }
    this.a.au(localArrayList);
  }
  
  public void a(@NonNull ppw paramppw, @Nullable ppu paramppu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (((paramppw instanceof pyu)) && ((paramppu instanceof qag)))
    {
      paramppw = (qag)paramppu;
      paramppu = new pxk.a();
      paramppu.b = paramErrorMessage;
      if ((paramErrorMessage.isSuccess()) && (!paramppw.nB.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedFeature: first=", ((ptp)paramppw.nB.get(0)).feedId });
        }
        ej(paramppw.nB);
        paramppu.mO = paramppw.nB;
        pmi.a().dispatch(paramppu);
        bnw();
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.GetFeedFeatureHandler", 2, "save feedFeature failed.", paramErrorMessage);
        }
        pmi.a().dispatch(paramppu);
        notifyError();
        return;
      } while ((!(paramppw instanceof pyk)) || (!(paramppu instanceof pyk.a)));
      paramppw = (pyk.a)paramppu;
      if (paramErrorMessage.isSuccess())
      {
        paramppu = new ArrayList(paramppw.nm.size());
        paramppw = paramppw.nm.iterator();
        while (paramppw.hasNext()) {
          paramppu.add(((qwa)paramppw.next()).a());
        }
        if (!paramppu.isEmpty())
        {
          this.a.au(paramppu);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "save feedItem: first=", ((FeedItem)paramppu.get(0)).feedId, ". request FeedFeature." });
          }
          paramppw = new pyu();
          paramppw.no = this.mM;
          ppv.a().a(paramppw, this);
          return;
        }
      }
    } while (this.mN.isEmpty());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.GetFeedFeatureHandler", 2, new Object[] { "request local FeedFeature after FeedItem. first=", this.mN.get(0) });
    }
    paramppw = new pyu();
    paramppw.no = this.mN;
    ppv.a().a(paramppw, this);
  }
  
  public void sendRequest()
  {
    ThreadManager.post(new GetFeedFeatureHandler.1(this), 8, null, true);
  }
  
  public static final class a
    extends plt
  {
    public List<ptp> mO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxk
 * JD-Core Version:    0.7.0.1
 */