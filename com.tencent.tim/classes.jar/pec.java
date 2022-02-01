import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
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

public class pec
  extends rxi
{
  private String arO;
  private String asF;
  private MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> n = new MutableLiveData();
  private MutableLiveData<pel<FeedCloudRead.StGetMainPageRsp>> r = new MutableLiveData();
  private MutableLiveData<FeedCloudMeta.StUser> s = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StMainPageBusiRspData> t = new MutableLiveData();
  public MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> u = new MutableLiveData();
  
  public pec()
  {
    this.a = pcx.a(32);
  }
  
  public FeedCloudCommon.StCommonExt a(boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.b(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.a != null) {
      this.a.b(paramStCommonExt);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean1) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      this.u.setValue(pel.a(paramString).b(paramBoolean2));
      return;
    }
    Object localObject = paramStGetFeedListRsp.vecFeed.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramString = this.u;
      localObject = pel.a(bool3).a(paramBoolean2, localObject);
      if (paramStGetFeedListRsp.isFinish.get() > 0) {}
      for (paramBoolean1 = bool1;; paramBoolean1 = false)
      {
        paramString.setValue(((pel)localObject).c(paramBoolean1));
        this.asF = paramStGetFeedListRsp.feedAttchInfo.get();
        return;
      }
    }
    paramString = this.u;
    localObject = pel.a().b(paramBoolean2);
    if (paramStGetFeedListRsp.isFinish.get() > 0) {}
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      paramString.setValue(((pel)localObject).c(paramBoolean1));
      break;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, Boolean paramBoolean1)
  {
    boolean bool1 = false;
    boolean bool2 = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetMainPageRsp == null))
    {
      this.n.setValue(pel.a(paramString).b(paramBoolean1.booleanValue()));
      this.r.setValue(pel.a(paramString).b(paramBoolean1.booleanValue()));
      return;
    }
    if ((paramStGetMainPageRsp.user != null) && (!TextUtils.isEmpty(paramStGetMainPageRsp.user.id.get()))) {
      pbu.a().setUinFollowed(paramStGetMainPageRsp.user.id.get(), ovd.b(paramStGetMainPageRsp.user));
    }
    paramString = this.r;
    Object localObject = pel.a(bool2).a(paramBoolean1.booleanValue(), paramStGetMainPageRsp);
    if (paramStGetMainPageRsp.isFinish.get() > 0) {
      paramBoolean = true;
    }
    for (;;)
    {
      paramString.setValue(((pel)localObject).c(paramBoolean));
      paramString = paramStGetMainPageRsp.vecFeed.get();
      if (paramString.size() > 0)
      {
        localObject = this.n;
        paramBoolean1 = pel.a(bool2).a(paramBoolean1.booleanValue(), paramString);
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
        this.t.setValue(paramBoolean1);
        if (paramStGetMainPageRsp.extInfo.has()) {
          a((FeedCloudCommon.StCommonExt)paramStGetMainPageRsp.extInfo.get());
        }
        this.arO = paramStGetMainPageRsp.feedAttchInfo.get();
        paramString = new StringBuilder().append("feed size:").append(paramString.size()).append(" | isFinish:");
        paramBoolean = bool1;
        if (paramStGetMainPageRsp.isFinish.get() > 0) {
          paramBoolean = true;
        }
        QLog.d("QCirclePersonalDetailViewModel", 1, paramBoolean + " | feedAttachInfo:" + this.arO);
        return;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        break label219;
        localObject = this.n;
        paramBoolean1 = pel.a().b(paramBoolean1.booleanValue());
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
  
  public void at(String paramString, boolean paramBoolean)
  {
    d(paramString, null, false, paramBoolean);
  }
  
  public void au(String paramString, boolean paramBoolean)
  {
    d(paramString, false, paramBoolean);
  }
  
  public void d(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = new QCircleGetMainPageRequest(paramString1, paramString2);
    paramString2 = paramString1.mRequest.extInfo;
    if (!paramBoolean1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString2.set(a(bool));
      paramString1.setEnableCache(paramBoolean2);
      this.n.setValue(pel.b());
      this.r.setValue(pel.b());
      a(paramString1, new ped(this, paramString1, paramBoolean1));
      return;
    }
  }
  
  public void d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (String str = this.asF;; str = null)
    {
      paramString = new QCircleGetFeedListRequest(paramString, str);
      paramString.setEnableCache(paramBoolean2);
      this.u.setValue(pel.b());
      VSNetworkHelper.a().a(paramString, new pee(this, paramBoolean1));
      return;
    }
  }
  
  public String getLogTag()
  {
    return "QCirclePersonalDetailViewModel";
  }
  
  public MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> l()
  {
    return this.n;
  }
  
  public MutableLiveData<pel<FeedCloudRead.StGetMainPageRsp>> o()
  {
    return this.r;
  }
  
  public MutableLiveData<pel<List<FeedCloudMeta.StFeed>>> p()
  {
    return this.u;
  }
  
  public void qE(String paramString)
  {
    d(paramString, this.arO, true, false);
  }
  
  public void qF(String paramString)
  {
    d(paramString, true, false);
  }
  
  protected void t(Object[] paramArrayOfObject)
  {
    QLog.d("QCirclePersonalDetailViewModel", 1, "onPreloadComplete");
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 4))
    {
      QLog.d("QCirclePersonalDetailViewModel", 1, "preload requestData onReceive: dispatch Success:" + (Boolean)paramArrayOfObject[0] + " | retCode:" + (Long)paramArrayOfObject[1] + " | retMessage:" + (String)paramArrayOfObject[2]);
      a(((Boolean)paramArrayOfObject[0]).booleanValue(), ((Long)paramArrayOfObject[1]).longValue(), (String)paramArrayOfObject[2], (FeedCloudRead.StGetMainPageRsp)paramArrayOfObject[3], Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pec
 * JD-Core Version:    0.7.0.1
 */