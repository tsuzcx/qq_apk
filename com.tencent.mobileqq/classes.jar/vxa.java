import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;
import java.util.List;

public class vxa
  extends aabb
{
  public static String a;
  private MutableLiveData<vxq<List<FeedCloudMeta.StLightInteractInfo>>> a;
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleLightInteractViewModel";
  }
  
  public vxa()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public MutableLiveData<vxq<List<FeedCloudMeta.StLightInteractInfo>>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean1) {
      this.b = "";
    }
    paramStFeed = new QCircleGetLightInteractRequest(paramStFeed, this.b, paramInt, paramString);
    paramStFeed.setEnableCache(paramBoolean2);
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
    a(paramStFeed, new vxb(this, paramStFeed, paramBoolean1));
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetLightInteractListRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).b(paramBoolean2));
      return;
    }
    this.b = paramStGetLightInteractListRsp.attachInfo.get();
    Object localObject = paramStGetLightInteractListRsp.listInfo.get();
    if (((List)localObject).size() > 0)
    {
      paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localObject = vxq.a(bool2).a(paramBoolean2, localObject);
      if (paramStGetLightInteractListRsp.isFinish.get() == 1) {}
      for (paramBoolean1 = bool1;; paramBoolean1 = false)
      {
        paramString.setValue(((vxq)localObject).c(paramBoolean1));
        return;
      }
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a().b(paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */