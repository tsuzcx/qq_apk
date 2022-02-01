import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vwy
  extends aabb
{
  private MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private FeedCloudCommon.StCommonExt jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private vbe jdField_a_of_type_Vbe;
  private boolean jdField_a_of_type_Boolean;
  private MutableLiveData<QQCircleFeedBase.StFollowPageData> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_Vbe == null)
    {
      QLog.e("QCircleFeedViewModel", 1, "requestData() tabInfo is null!");
      return;
    }
    paramString1 = new QCircleGetFeedListRequest(this.jdField_a_of_type_Vbe, paramString1, paramString2, uyq.a().a(), paramInt);
    paramString2 = this.jdField_a_of_type_Vbe;
    paramString1.setRetryCount(1);
    FeedCloudCommon.StCommonExt localStCommonExt = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (boolean bool = true;; bool = false)
    {
      localStCommonExt.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
      a(paramString1, new vwz(this, paramString2, paramString1, paramBoolean1, paramInt));
      return;
    }
  }
  
  public MutableLiveData<vxq<List<FeedCloudMeta.StFeed>>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public FeedCloudCommon.StCommonExt a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt;
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vua != null) {
      return this.jdField_a_of_type_Vua.a(paramBoolean);
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
    if (this.jdField_a_of_type_Vbe != null) {
      return this.jdField_a_of_type_Vbe.a;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    vle.a().a(this, paramInt1, paramInt2);
  }
  
  public void a(FeedCloudCommon.BytesEntry paramBytesEntry)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramBytesEntry);
    }
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString)
  {
    if (QCircleBaseTabFragment.jdField_b_of_type_JavaLangString.equals(paramString)) {
      this.jdField_a_of_type_Vua = vua.a(1);
    }
    while (!QCircleBaseTabFragment.c.equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_Vua = vua.a(3);
  }
  
  public void a(ArrayList<FeedCloudMeta.StFeed> paramArrayList, boolean paramBoolean, FeedCloudCommon.StCommonExt paramStCommonExt, String paramString1, String paramString2, QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt = paramStCommonExt;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(paramStFollowPageData);
  }
  
  public void a(List<FeedCloudMeta.StFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public void a(vbe paramvbe)
  {
    this.jdField_a_of_type_Vbe = paramvbe;
  }
  
  public void a(boolean paramBoolean)
  {
    a(null, this.jdField_a_of_type_JavaLangString, false, paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(null, this.jdField_a_of_type_JavaLangString, false, paramBoolean, paramInt);
  }
  
  public boolean a()
  {
    return vle.a().a(this);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFeedViewModel", 1, "sendRspByCache feed size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " | isFinish:" + this.jdField_a_of_type_Boolean + " | feedAttachInfo:" + this.jdField_b_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    if (localArrayList.size() > 0)
    {
      a(this.jdField_a_of_type_FeedcloudFeedCloudCommon$StCommonExt);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramInt1, paramInt2).a(false, localArrayList).c(this.jdField_a_of_type_Boolean));
      return true;
    }
    return false;
  }
  
  public MutableLiveData<QQCircleFeedBase.StFollowPageData> b()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Vua != null) {
      this.jdField_a_of_type_Vua.a(paramString);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleGetFeedListRequest(this.jdField_a_of_type_Vbe, null, null, uyq.a().a());
      paramString.mRequest.extInfo.set(a(true));
      if (VSBaseRequest.isCacheExist(paramString)) {
        VSBaseRequest.reMoveCache(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwy
 * JD-Core Version:    0.7.0.1
 */