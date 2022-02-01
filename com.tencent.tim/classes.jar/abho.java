import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class abho
  implements awms
{
  abho(abhh paramabhh) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "onGetAdvs isSucc:", Boolean.valueOf(paramBoolean) });
    }
    if ((!paramBoolean) || (paramGetAdsRsp == null)) {
      return;
    }
    if (paramGetAdsRsp.mapAds.has()) {}
    for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp == null; paramGetAdsRsp = null)
    {
      QLog.w("ApolloManager", 1, "rspEntries == null");
      return;
    }
    HashMap localHashMap = new HashMap();
    paramGetAdsRsp = paramGetAdsRsp.iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has())) {
        localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
      }
    }
    abhh.a(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(364)));
    abhh.b(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(367)));
    abhh.c(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(366)));
    abhh.d(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(365)));
    abhh.e(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(393)));
    abhh.f(this.this$0, (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(433)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abho
 * JD-Core Version:    0.7.0.1
 */