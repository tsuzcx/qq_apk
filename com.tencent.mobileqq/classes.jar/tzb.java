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
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class tzb
  extends tyz
{
  private MutableLiveData<tzm<List<FeedCloudMeta.StFeed>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_a_of_type_JavaLangString;
  private trv jdField_a_of_type_Trv;
  private final MutableLiveData<FeedCloudMeta.StFeed> b = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StFollowPageData> c = new MutableLiveData();
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Trv == null)
    {
      QLog.e("QCircleFeedViewModel", 1, "requestData() tabInfo is null!");
      return;
    }
    paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Trv, paramString, tqj.a().a());
    FeedCloudCommon.StCommonExt localStCommonExt = paramString.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (;;)
    {
      localStCommonExt.set(a(bool));
      paramString.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(tzm.b());
      a(paramString, new tzc(this, paramString, paramBoolean1));
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
        this.b.postValue(localStFeed);
        paramList.remove(localStFeed);
        return true;
      }
    }
    return false;
  }
  
  public MutableLiveData<FeedCloudMeta.StFeed> a()
  {
    return this.b;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tys != null) {
      return this.jdField_a_of_type_Tys.a(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Tys != null) {
      this.jdField_a_of_type_Tys.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString)
  {
    if (QCircleBaseTabFragment.d.equals(paramString)) {
      this.jdField_a_of_type_Tys = tys.a(1);
    }
    while (!QCircleBaseTabFragment.i.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Tys = tys.a(3);
  }
  
  public void a(trv paramtrv)
  {
    this.jdField_a_of_type_Trv = paramtrv;
  }
  
  public void a(boolean paramBoolean)
  {
    a(null, false, paramBoolean);
  }
  
  public MutableLiveData<tzm<List<FeedCloudMeta.StFeed>>> b()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Trv, null, tqj.a().a());
      paramString.mRequest.extInfo.set(a(true));
      if (VSBaseRequest.isCacheExist(paramString)) {
        VSBaseRequest.reMoveCache(paramString);
      }
    }
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzb
 * JD-Core Version:    0.7.0.1
 */