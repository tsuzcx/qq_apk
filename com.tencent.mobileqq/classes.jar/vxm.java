import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StRewardData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vxm
  extends aabb
{
  private MutableLiveData<vxq<List<QQCircleFeedBase.StTabInfo>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private ArrayList<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<QQCircleFeedBase.StPolyLike> b = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> c = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public MutableLiveData<vxq<List<QQCircleFeedBase.StTabInfo>>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public String a()
  {
    return "QCircleTabViewModel";
  }
  
  public ArrayList<QQCircleFeedBase.StTabInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramStGPSV2 = new QCircleGetTabListRequest(paramStGPSV2);
    paramStGPSV2.setRetryCount(2);
    paramStGPSV2.setEnableCache(true);
    Object localObject = vtt.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
        localBytesEntry.key.set("circle_invite");
        localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
        localArrayList.add(localBytesEntry);
        localStCommonExt.mapBytesInfo.set(localArrayList);
        if (paramStGPSV2.mReq != null) {
          paramStGPSV2.mReq.extInfo.set(localStCommonExt);
        }
      }
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.b());
    a(paramStGPSV2, new vxn(this, paramStGPSV2));
  }
  
  public void a(List<QQCircleFeedBase.StTabInfo> paramList, List<QQCircleFeedBase.StPolyLike> paramList1, List<QQCircleBase.UserCircleInfo> paramList2, List<QQCircleBase.UserCircleInfo> paramList3)
  {
    b();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.b.addAll(paramList1);
    this.c.addAll(paramList2);
    this.d.addAll(paramList3);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetBusiInfoRsp == null))
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(paramString).a(paramLong));
      return;
    }
    QLog.d("QCircleTabViewModel", 1, "is use cache:" + bool);
    paramString = new QQCircleFeedBase.StBusiInfoData();
    paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
    try
    {
      paramString.mergeFrom(paramStGetBusiInfoRsp);
      uyk.a().a(paramStGetBusiInfoRsp);
      paramStGetBusiInfoRsp = paramString.tabInfos.get();
      if (paramString.defaultTabIndex.has()) {
        i = QzoneConfig.getQQCircleDefaultShowTabType();
      }
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      int i;
      int j;
      label159:
      paramString.printStackTrace();
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a("parse stBusiInfo data exception!"));
      return;
    }
    try
    {
      j = ((QQCircleFeedBase.StTabInfo)paramStGetBusiInfoRsp.get(paramString.defaultTabIndex.get())).tabType.get();
      i = j;
    }
    catch (Exception localException)
    {
      break label159;
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a());
      break label214;
    }
    uyn.a(i);
    if (!bool)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramStGetBusiInfoRsp);
    }
    if (paramStGetBusiInfoRsp.size() > 0)
    {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(bool).a(false, paramStGetBusiInfoRsp));
      label214:
      paramStGetBusiInfoRsp = paramString.allPolyInfo.get();
      if ((paramStGetBusiInfoRsp != null) && (!bool))
      {
        vry.a().a(paramStGetBusiInfoRsp);
        vry.a().a((float)paramString.rewardData.myMoney.get());
        this.b.clear();
        this.b.addAll(paramStGetBusiInfoRsp);
      }
      this.c.clear();
      this.c.addAll(paramString.schoolInfos.get());
      this.d.clear();
      this.d.addAll(paramString.companyInfos.get());
      uyn.a(paramString.schoolInfos.get(), paramString.companyInfos.get());
      return;
    }
  }
  
  public boolean a()
  {
    return vle.a().a(this);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      uyn.a(paramInt);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(vxq.a(false).a(false, this.jdField_a_of_type_JavaUtilArrayList));
      uyn.a(this.c, this.d);
      bool = true;
    }
    return bool;
  }
  
  public ArrayList<QQCircleFeedBase.StPolyLike> b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> c()
  {
    return this.c;
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxm
 * JD-Core Version:    0.7.0.1
 */