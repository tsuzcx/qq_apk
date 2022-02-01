import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class vtv
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
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QCircleAggregationFeedViewModel", 1, "requestFeedsData() troopUin is null!");
      return;
    }
    paramString1 = new QCircleGetGroupFeedListRequest(Long.parseLong(paramString1), this.jdField_a_of_type_Uzo, paramString2, paramString3, uxf.a().a());
    paramString1.setRetryCount(1);
    paramString2 = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vup.b());
      a(paramString1, new vtw(this, paramString1, paramBoolean1));
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
  
  public MutableLiveData<vup<List<FeedCloudMeta.StFeed>>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
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
    return "QCircleAggregationFeedViewModel";
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vrp != null) {
      this.jdField_a_of_type_Vrp.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, null, this.jdField_a_of_type_JavaLangString, false, paramBoolean);
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
  
  public boolean a()
  {
    return false;
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> b()
  {
    return this.jdField_c_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b(String paramString)
  {
    if (QCircleBaseTabFragment.jdField_b_of_type_JavaLangString.equals(paramString)) {
      this.jdField_a_of_type_Vrp = vrp.a(1);
    }
    while (!QCircleBaseTabFragment.g.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Vrp = vrp.a(3);
  }
  
  public void c(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtv
 * JD-Core Version:    0.7.0.1
 */