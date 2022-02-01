import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class pdy
  extends rxi
{
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private owa jdField_a_of_type_Owa;
  private String arO;
  private String asE;
  private boolean fV;
  private ArrayList<FeedCloudMeta.StFeed> mq = new ArrayList();
  private MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> n = new MutableLiveData();
  private final MutableLiveData<FeedCloudMeta.StFeed> o = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StFollowPageData> p = new MutableLiveData();
  
  private void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Owa == null)
    {
      QLog.e("QCircleFeedViewModel", 1, "requestData() tabInfo is null!");
      return;
    }
    paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Owa, paramString, ouq.a().a());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      localStCommonExt.set(a(bool));
      paramString.setEnableCache(paramBoolean2);
      this.n.setValue(pel.b());
      a(paramString, new pdz(this, paramString, paramBoolean1));
      return;
      bool = false;
    }
  }
  
  private boolean z(List<FeedCloudMeta.StFeed> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localIterator.next();
      if (localStFeed.dittoFeed.dittoId.get() == 2)
      {
        this.o.postValue(localStFeed);
        paramList.remove(localStFeed);
        return true;
      }
    }
    return false;
  }
  
  public boolean HT()
  {
    return ozu.a().a(this);
  }
  
  public boolean HU()
  {
    return this.fV;
  }
  
  public FeedCloudCommon.StCommonExt a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pcx != null) {
      return this.jdField_a_of_type_Pcx.b(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public Collection<? extends FeedCloudMeta.StFeed> a()
  {
    return this.mq;
  }
  
  public QQCircleFeedBase.StTabInfo a()
  {
    if (this.jdField_a_of_type_Owa != null) {
      return this.jdField_a_of_type_Owa.a;
    }
    return null;
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Pcx != null) {
      this.jdField_a_of_type_Pcx.b(paramStCommonExt);
    }
  }
  
  public void a(ArrayList<FeedCloudMeta.StFeed> paramArrayList, boolean paramBoolean, FeedCloudCommon.StCommonExt paramStCommonExt, String paramString, QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    this.mq.clear();
    this.mq.addAll(paramArrayList);
    this.fV = paramBoolean;
    this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = paramStCommonExt;
    this.arO = paramString;
    this.p.setValue(paramStFollowPageData);
  }
  
  public void b(owa paramowa)
  {
    this.jdField_a_of_type_Owa = paramowa;
  }
  
  public void dG(List<FeedCloudMeta.StFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mq.clear();
      this.mq.addAll(paramList);
      if (this.o.getValue() != null) {
        this.mq.add(0, this.o.getValue());
      }
    }
  }
  
  public void dJ(int paramInt1, int paramInt2)
  {
    ozu.a().a(this, paramInt1, paramInt2);
  }
  
  public void dK(int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFeedViewModel", 1, "sendRspByCache feed size:" + this.mq.size() + " | isFinish:" + this.fV + " | feedAttachInfo:" + this.arO);
    ArrayList localArrayList = new ArrayList(this.mq);
    a(this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt);
    if (localArrayList.size() > 0)
    {
      z(localArrayList);
      this.n.setValue(pel.a(paramInt1, paramInt2).a(false, localArrayList).c(this.fV));
      return;
    }
    this.n.setValue(pel.a().b(false).c(this.fV));
  }
  
  public String getLogTag()
  {
    return "QCircleFeedViewModel";
  }
  
  public MutableLiveData<FeedCloudMeta.StFeed> k()
  {
    return this.o;
  }
  
  public MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> l()
  {
    return this.n;
  }
  
  public void loadMore()
  {
    c(this.arO, true, false);
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> m()
  {
    return this.p;
  }
  
  public String mc()
  {
    return this.arO;
  }
  
  public void qC(String paramString)
  {
    if (QCircleBaseTabFragment.arP.equals(paramString)) {
      this.jdField_a_of_type_Pcx = pcx.a(1);
    }
    while (!QCircleBaseTabFragment.arU.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Pcx = pcx.a(3);
  }
  
  public void qD(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Owa, null, ouq.a().a());
      paramString.mRequest.extInfo.set(a(true));
      if (VSBaseRequest.isCacheExist(paramString)) {
        VSBaseRequest.reMoveCache(paramString);
      }
    }
  }
  
  public void refreshData(boolean paramBoolean)
  {
    c(null, false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdy
 * JD-Core Version:    0.7.0.1
 */