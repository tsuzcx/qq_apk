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

public class vtz
  extends zxg
{
  private MutableLiveData<vup<List<FeedCloudMeta.StFeed>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uzo jdField_a_of_type_Uzo;
  private boolean jdField_a_of_type_Boolean;
  private final MutableLiveData<FeedCloudMeta.StFeed> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_b_of_type_JavaLangString;
  private MutableLiveData<QQCircleFeedBase.StFollowPageData> jdField_c_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_c_of_type_JavaLangString;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Uzo == null)
    {
      QLog.e("QCircleFeedViewModel", 1, "requestData() tabInfo is null!");
      return;
    }
    paramString1 = new QCircleGetFeedListRequest(this.jdField_a_of_type_Uzo, paramString1, paramString2, uxf.a().a());
    paramString1.setRetryCount(1);
    paramString2 = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.b());
      a(paramString1, new vua(this, paramString1, paramBoolean1));
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
    if (this.jdField_a_of_type_Vrp != null) {
      return this.jdField_a_of_type_Vrp.a(paramBoolean);
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
    if (this.jdField_a_of_type_Uzo != null) {
      return this.jdField_a_of_type_Uzo.a;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    vja.a().a(this, paramInt1, paramInt2);
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vrp != null) {
      this.jdField_a_of_type_Vrp.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString)
  {
    if (QCircleBaseTabFragment.jdField_b_of_type_JavaLangString.equals(paramString)) {
      this.jdField_a_of_type_Vrp = vrp.a(1);
    }
    while (!QCircleBaseTabFragment.g.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Vrp = vrp.a(3);
  }
  
  public void a(ArrayList<FeedCloudMeta.StFeed> paramArrayList, boolean paramBoolean, FeedCloudCommon.StCommonExt paramStCommonExt, String paramString1, String paramString2, QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = paramStCommonExt;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData.setValue(paramStFollowPageData);
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
  
  public void a(uzo paramuzo)
  {
    this.jdField_a_of_type_Uzo = paramuzo;
  }
  
  public void a(boolean paramBoolean)
  {
    a(null, this.jdField_a_of_type_JavaLangString, false, paramBoolean);
  }
  
  public boolean a()
  {
    return vja.a().a(this);
  }
  
  public MutableLiveData<vup<List<FeedCloudMeta.StFeed>>> b()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFeedViewModel", 1, "sendRspByCache feed size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " | isFinish:" + this.jdField_a_of_type_Boolean + " | feedAttachInfo:" + this.jdField_b_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt);
    if (localArrayList.size() > 0)
    {
      a(localArrayList);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a(paramInt1, paramInt2).a(false, localArrayList).c(this.jdField_a_of_type_Boolean));
      return;
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.a().b(false).c(this.jdField_a_of_type_Boolean));
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Uzo, null, null, uxf.a().a());
      paramString.mRequest.extInfo.set(a(true));
      if (VSBaseRequest.isCacheExist(paramString)) {
        VSBaseRequest.reMoveCache(paramString);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> c()
  {
    return this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtz
 * JD-Core Version:    0.7.0.1
 */