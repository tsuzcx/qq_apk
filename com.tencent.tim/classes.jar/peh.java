import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
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

public class peh
  extends rxi
{
  private ArrayList<QQCircleFeedBase.StTabInfo> mg = new ArrayList();
  private ArrayList<QQCircleFeedBase.StPolyLike> mu = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> mv = new ArrayList();
  private ArrayList<QQCircleBase.UserCircleInfo> mw = new ArrayList();
  private MutableLiveData<pel<List<QQCircleFeedBase.StTabInfo>>> w = new MutableLiveData();
  
  public boolean HT()
  {
    return ozu.a().a(this);
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    paramStGPSV2 = new QCircleGetTabListRequest(paramStGPSV2);
    paramStGPSV2.setEnableCache(true);
    Object localObject = pcr.a().ma();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).getBytes();
      pcr.a().qz(null);
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
    this.w.setValue(pel.b());
    a(paramStGPSV2, new pei(this, paramStGPSV2));
  }
  
  public void a(List<QQCircleFeedBase.StTabInfo> paramList, List<QQCircleFeedBase.StPolyLike> paramList1, List<QQCircleBase.UserCircleInfo> paramList2, List<QQCircleBase.UserCircleInfo> paramList3)
  {
    clearCacheData();
    this.mg.addAll(paramList);
    this.mu.addAll(paramList1);
    this.mv.addAll(paramList2);
    this.mw.addAll(paramList3);
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetBusiInfoRsp == null))
    {
      this.w.setValue(pel.a(paramString));
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
        oue.a().L(paramStGetBusiInfoRsp);
        paramStGetBusiInfoRsp = paramString.tabInfos.get();
        if (!bool)
        {
          this.mg.clear();
          this.mg.addAll(paramStGetBusiInfoRsp);
        }
        if (paramStGetBusiInfoRsp.size() > 0)
        {
          this.w.setValue(pel.a(bool).a(false, paramStGetBusiInfoRsp));
          paramStGetBusiInfoRsp = paramString.allPolyInfo.get();
          if ((paramStGetBusiInfoRsp != null) && (!bool))
          {
            oum.dD(paramStGetBusiInfoRsp);
            this.mu.clear();
            this.mu.addAll(paramStGetBusiInfoRsp);
          }
          this.mv.clear();
          this.mv.addAll(paramString.schoolInfos.get());
          this.mw.clear();
          this.mw.addAll(paramString.companyInfos.get());
          oum.r(paramString.schoolInfos.get(), paramString.companyInfos.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        this.w.setValue(pel.a("parse stBusiInfo data exception!"));
        return;
      }
      this.w.setValue(pel.a());
    }
  }
  
  public void bkk()
  {
    if (this.mg.size() > 0) {
      this.w.setValue(pel.a(false).a(false, this.mg));
    }
    for (;;)
    {
      oum.dD(this.mu);
      oum.r(this.mv, this.mw);
      return;
      this.w.setValue(pel.a());
    }
  }
  
  public ArrayList<QQCircleFeedBase.StTabInfo> bm()
  {
    return this.mg;
  }
  
  public ArrayList<QQCircleFeedBase.StPolyLike> bn()
  {
    return this.mu;
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> bo()
  {
    return this.mv;
  }
  
  public ArrayList<QQCircleBase.UserCircleInfo> bp()
  {
    return this.mw;
  }
  
  public void clearCacheData()
  {
    this.mg.clear();
    this.mu.clear();
    this.mv.clear();
    this.mw.clear();
  }
  
  public String getLogTag()
  {
    return "QCircleTabViewModel";
  }
  
  public MutableLiveData<pel<List<QQCircleFeedBase.StTabInfo>>> r()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */