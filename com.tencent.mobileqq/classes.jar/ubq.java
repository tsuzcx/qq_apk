import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class ubq
  extends ubk
{
  public MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> a;
  private String a;
  private MutableLiveData<ubz<FeedCloudRead.StGetMainPageRsp>> jdField_b_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private String jdField_b_of_type_JavaLangString;
  private MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> c = new MutableLiveData();
  private MutableLiveData<FeedCloudMeta.StUser> d = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StMainPageBusiRspData> e = new MutableLiveData();
  
  public ubq()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_Uae = uae.a(32);
  }
  
  public MutableLiveData<ubz<FeedCloudRead.StGetMainPageRsp>> a()
  {
    return this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
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
    return "QCirclePersonalDetailViewModel";
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.jdField_a_of_type_Uae != null) {
      this.jdField_a_of_type_Uae.a(paramStCommonExt);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = new QCircleGetMainPageRequest(paramString1, paramString2);
    paramString2 = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.c.setValue(ubz.b());
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.b());
      a(paramString1, new ubr(this, paramString1, paramBoolean1));
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, null, false, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (String str = this.jdField_b_of_type_JavaLangString;; str = null)
    {
      paramString = new QCircleGetFeedListRequest(paramString, str);
      paramString.setEnableCache(paramBoolean2);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.b());
      VSNetworkHelper.a().a(paramString, new ubs(this, paramBoolean1));
      return;
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(paramString).b(paramBoolean2));
      return;
    }
    Object localObject = paramStGetFeedListRsp.vecFeed.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
      localObject = ubz.a(bool3).a(paramBoolean2, localObject);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {}
      for (paramBoolean1 = bool1;; paramBoolean1 = false)
      {
        paramString.setValue(((ubz)localObject).c(paramBoolean1));
        this.jdField_b_of_type_JavaLangString = paramStGetFeedListRsp.feedAttchInfo.get();
        return;
      }
    }
    paramString = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
    localObject = ubz.a().b(paramBoolean2);
    if (paramStGetFeedListRsp.isFinish.get() > 0) {}
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      paramString.setValue(((ubz)localObject).c(paramBoolean1));
      break;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, Boolean paramBoolean1)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetMainPageRsp == null))
    {
      this.c.setValue(ubz.a(paramString).b(paramBoolean1.booleanValue()));
      this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(paramString).b(paramBoolean1.booleanValue()));
      return;
    }
    if ((paramStGetMainPageRsp.user != null) && (!TextUtils.isEmpty(paramStGetMainPageRsp.user.id.get()))) {
      tyy.a().a(paramStGetMainPageRsp.user.id.get(), tra.b(paramStGetMainPageRsp.user));
    }
    paramString = this.jdField_b_of_type_AndroidArchLifecycleMutableLiveData;
    Object localObject = ubz.a(bool2).a(paramBoolean1.booleanValue(), paramStGetMainPageRsp);
    if (paramStGetMainPageRsp.isFinish.get() > 0) {
      paramBoolean = true;
    }
    for (;;)
    {
      paramString.setValue(((ubz)localObject).c(paramBoolean));
      paramString = paramStGetMainPageRsp.vecFeed.get();
      if (paramString.size() > 0)
      {
        localObject = this.c;
        paramBoolean1 = ubz.a(bool2).a(paramBoolean1.booleanValue(), paramString);
        if (paramStGetMainPageRsp.isFinish.get() > 0)
        {
          paramBoolean = true;
          label219:
          ((MutableLiveData)localObject).setValue(paramBoolean1.c(paramBoolean));
          if (paramStGetMainPageRsp.busiRspData.get() != null) {
            paramBoolean1 = new QQCircleFeedBase.StMainPageBusiRspData();
          }
        }
      }
      try
      {
        paramBoolean1.mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
        this.e.setValue(paramBoolean1);
        if (paramStGetMainPageRsp.extInfo.has()) {
          a((FeedCloudCommon.StCommonExt)paramStGetMainPageRsp.extInfo.get());
        }
        this.jdField_a_of_type_JavaLangString = paramStGetMainPageRsp.feedAttchInfo.get();
        paramString = new StringBuilder().append("feed size:").append(paramString.size()).append(" | isFinish:");
        paramBoolean = bool1;
        if (paramStGetMainPageRsp.isFinish.get() > 0) {
          paramBoolean = true;
        }
        QLog.d("QCirclePersonalDetailViewModel", 1, paramBoolean + " | feedAttachInfo:" + this.jdField_a_of_type_JavaLangString);
        return;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        break label219;
        localObject = this.c;
        paramBoolean1 = ubz.a().b(paramBoolean1.booleanValue());
        if (paramStGetMainPageRsp.isFinish.get() > 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ((MutableLiveData)localObject).setValue(paramBoolean1.c(paramBoolean));
          break;
        }
      }
      catch (Exception paramBoolean1)
      {
        for (;;)
        {
          QLog.e("QCirclePersonalDetailViewModel", 1, "mergeFrom stMainPageBusiRspData error");
        }
      }
    }
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    QLog.d("QCirclePersonalDetailViewModel", 1, "onPreloadComplete");
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 4))
    {
      QLog.d("QCirclePersonalDetailViewModel", 1, "preload requestData onReceive: dispatch Success:" + (Boolean)paramArrayOfObject[0] + " | retCode:" + (Long)paramArrayOfObject[1] + " | retMessage:" + (String)paramArrayOfObject[2]);
      a(((Boolean)paramArrayOfObject[0]).booleanValue(), ((Long)paramArrayOfObject[1]).longValue(), (String)paramArrayOfObject[2], (FeedCloudRead.StGetMainPageRsp)paramArrayOfObject[3], Boolean.valueOf(false));
    }
  }
  
  public MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    a(paramString, this.jdField_a_of_type_JavaLangString, true, false);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    a(paramString, false, paramBoolean);
  }
  
  public MutableLiveData<ubz<List<FeedCloudMeta.StFeed>>> c()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void c(String paramString)
  {
    a(paramString, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubq
 * JD-Core Version:    0.7.0.1
 */