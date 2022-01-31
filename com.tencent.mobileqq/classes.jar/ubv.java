import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
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
import qqcircle.QQCircleFeedBase.StTabInfo;

public class ubv
  extends ubk
{
  private MutableLiveData<ubz<List<QQCircleFeedBase.StTabInfo>>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  private ArrayList<QQCircleFeedBase.StTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<QQCircleFeedBase.StPolyLike> b = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> c = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> d = new ArrayList();
  
  public MutableLiveData<ubz<List<QQCircleFeedBase.StTabInfo>>> a()
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
    paramStGPSV2.setEnableCache(true);
    Object localObject = tzy.a().a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      tzy.a().a(null);
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
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.b());
    a(paramStGPSV2, new ubw(this, paramStGPSV2));
  }
  
  public void a(List<QQCircleFeedBase.StTabInfo> paramList, List<QQCircleFeedBase.StPolyLike> paramList1, List<QQCircleBase.UserCircleInfo> paramList2, List<QQCircleBase.UserCircleInfo> paramList3)
  {
    c();
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
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(paramString));
      return;
    }
    QLog.d("QCircleTabViewModel", 1, "is use cache:" + bool);
    paramString = new QQCircleFeedBase.StBusiInfoData();
    paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
    for (;;)
    {
      try
      {
        paramString.mergeFrom(paramStGetBusiInfoRsp);
        tpz.a().a(paramStGetBusiInfoRsp);
        paramStGetBusiInfoRsp = paramString.tabInfos.get();
        if (!bool)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramStGetBusiInfoRsp);
        }
        if (paramStGetBusiInfoRsp.size() > 0)
        {
          this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(bool).a(false, paramStGetBusiInfoRsp));
          paramStGetBusiInfoRsp = paramString.allPolyInfo.get();
          if ((paramStGetBusiInfoRsp != null) && (!bool))
          {
            tqg.a(paramStGetBusiInfoRsp);
            this.b.clear();
            this.b.addAll(paramStGetBusiInfoRsp);
          }
          this.c.clear();
          this.c.addAll(paramString.schoolInfos.get());
          this.d.clear();
          this.d.addAll(paramString.companyInfos.get());
          tqg.a(paramString.schoolInfos.get(), paramString.companyInfos.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a("parse stBusiInfo data exception!"));
        return;
      }
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a());
    }
  }
  
  public boolean a()
  {
    return twl.a().a(this);
  }
  
  public ArrayList<QQCircleFeedBase.StPolyLike> b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a(false).a(false, this.jdField_a_of_type_JavaUtilArrayList));
    }
    for (;;)
    {
      tqg.a(this.b);
      tqg.a(this.c, this.d);
      return;
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(ubz.a());
    }
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> c()
  {
    return this.c;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubv
 * JD-Core Version:    0.7.0.1
 */