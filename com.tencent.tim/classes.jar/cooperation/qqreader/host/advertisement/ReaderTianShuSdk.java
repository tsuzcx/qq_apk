package cooperation.qqreader.host.advertisement;

import awmr;
import awms;
import awmt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReaderTianShuSdk
{
  public static void requestAd(int paramInt1, int paramInt2, RequestListener paramRequestListener)
  {
    ArrayList localArrayList = new ArrayList();
    awmr localawmr = new awmr();
    localawmr.eBV = paramInt1;
    localawmr.eBW = paramInt2;
    localArrayList.add(localawmr);
    awmt.a().a(localArrayList, new ReaderTianShuGetAdvCallback(paramInt1, paramRequestListener));
  }
  
  static class ReaderTianShuGetAdvCallback
    implements awms
  {
    ReaderTianShuSdk.RequestListener a;
    int exz;
    
    ReaderTianShuGetAdvCallback(int paramInt, ReaderTianShuSdk.RequestListener paramRequestListener)
    {
      this.exz = paramInt;
      this.a = paramRequestListener;
    }
    
    public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
    {
      ArrayList localArrayList = new ArrayList();
      if ((!paramBoolean) || (paramGetAdsRsp == null)) {}
      label266:
      label271:
      for (;;)
      {
        if (this.a != null) {
          this.a.onResult(paramBoolean, localArrayList);
        }
        return;
        label53:
        Object localObject;
        if (paramGetAdsRsp.mapAds.has())
        {
          paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
          if (paramGetAdsRsp == null) {
            break label225;
          }
          localObject = paramGetAdsRsp.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramGetAdsRsp = (TianShuAccess.RspEntry)((Iterator)localObject).next();
          } while ((paramGetAdsRsp == null) || (paramGetAdsRsp.key.get() != this.exz));
        }
        for (;;)
        {
          if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null)) {
            break label271;
          }
          paramGetAdsRsp = paramGetAdsRsp.value.lst.get().iterator();
          for (;;)
          {
            if (!paramGetAdsRsp.hasNext()) {
              break label266;
            }
            localObject = (TianShuAccess.AdItem)paramGetAdsRsp.next();
            HashMap localHashMap = new HashMap();
            Iterator localIterator = ((TianShuAccess.AdItem)localObject).argList.get().iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
                localHashMap.put(localMapEntry.key.get(), localMapEntry.value.get());
                continue;
                paramGetAdsRsp = null;
                break label53;
                label225:
                break;
              }
            }
            if (!localHashMap.containsKey("iAdId")) {
              localHashMap.put("iAdId", String.valueOf(((TianShuAccess.AdItem)localObject).iAdId.get()));
            }
            localArrayList.add(localHashMap);
          }
          break;
          paramGetAdsRsp = null;
        }
      }
    }
  }
  
  public static abstract interface RequestListener
  {
    public abstract void onResult(boolean paramBoolean, List<Map<String, String>> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderTianShuSdk
 * JD-Core Version:    0.7.0.1
 */