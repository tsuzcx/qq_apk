import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
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

public class ubm
  extends ubk
{
  private MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tsa jdField_a_of_type_Tsa;
  private boolean jdField_a_of_type_Boolean;
  private final MutableLiveData<FeedCloudMeta.StFeed> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_b_of_type_JavaLangString;
  private MutableLiveData<QQCircleFeedBase.StFollowPageData> c = new MutableLiveData();
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Tsa == null)
    {
      QLog.e("QCircleFeedViewModel", 1, "requestData() tabInfo is null!");
      return;
    }
    paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Tsa, paramString, tqj.a().a());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      localStCommonExt.set(a(bool));
      paramString.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.b());
      a(paramString, new ubn(this, paramString, paramBoolean1));
      return;
      bool = false;
    }
  }
  
  private boolean a(List<FeedCloudMeta.StFeed> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localIterator.next();
      if (localStFeed.dittoFeed.dittoId.get() == 2)
      {
        this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.postValue(localStFeed);
        paramList.remove(localStFeed);
        return true;
      }
    }
    return false;
  }
  
  public MutableLiveData<FeedCloudMeta.StFeed> a()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public FeedCloudCommon.StCommonExt a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uae != null) {
      return this.jdField_a_of_type_Uae.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String a()
  {
    return "QCircleFeedViewModel";
  }
  
  public Collection<? extends FeedCloudMeta.StFeed> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public QQCircleFeedBase.StTabInfo a()
  {
    if (this.jdField_a_of_type_Tsa != null) {
      return this.jdField_a_of_type_Tsa.a;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    twl.a().a(this, paramInt1, paramInt2);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Uae != null) {
      this.jdField_a_of_type_Uae.a(paramStCommonExt);
    }
  }
  
  public void a(ArrayList<FeedCloudMeta.StFeed> paramArrayList, boolean paramBoolean, FeedCloudCommon.StCommonExt paramStCommonExt, String paramString, QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = paramStCommonExt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c.setValue(paramStFollowPageData);
  }
  
  public void a(List<FeedCloudMeta.StFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.getValue() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.getValue());
      }
    }
  }
  
  public void a(tsa paramtsa)
  {
    this.jdField_a_of_type_Tsa = paramtsa;
  }
  
  public void a(boolean paramBoolean)
  {
    a(null, false, paramBoolean);
  }
  
  public boolean a()
  {
    return twl.a().a(this);
  }
  
  public MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> b()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFeedViewModel", 1, "sendRspByCache feed size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " | isFinish:" + this.jdField_a_of_type_Boolean + " | feedAttachInfo:" + this.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt);
    if (localArrayList.size() > 0)
    {
      a(localArrayList);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(paramInt1, paramInt2).a(false, localArrayList).c(this.jdField_a_of_type_Boolean));
      return;
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a().b(false).c(this.jdField_a_of_type_Boolean));
  }
  
  public void b(String paramString)
  {
    if (QCircleBaseTabFragment.c.equals(paramString)) {
      this.jdField_a_of_type_Uae = uae.a(1);
    }
    while (!QCircleBaseTabFragment.h.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Uae = uae.a(3);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Tsa, null, tqj.a().a());
      paramString.mRequest.extInfo.set(a(true));
      if (VSBaseRequest.isCacheExist(paramString)) {
        VSBaseRequest.reMoveCache(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubm
 * JD-Core Version:    0.7.0.1
 */