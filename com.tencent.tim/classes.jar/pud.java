import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.lbs.LbsManager.3.1;
import com.tencent.biz.qqstory.model.lbs.LbsManager.3.2;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class pud
  implements ppv.b<pyl<qqstory_service.ReqGetPOIList>, pzy>
{
  pud(pub parampub, WeakReference paramWeakReference, pub.d paramd) {}
  
  public void a(@NonNull pyl<qqstory_service.ReqGetPOIList> parampyl, @Nullable pzy parampzy, @NonNull ErrorMessage paramErrorMessage)
  {
    if (parampzy == null)
    {
      ram.w("LbsManager", "response is null");
      parampyl = (pub.c)this.I.get();
      if (parampyl != null) {
        ThreadManager.getUIHandler().post(new LbsManager.3.1(this, parampyl, paramErrorMessage));
      }
      return;
    }
    parampyl = new qqstory_service.RspGetPOIList();
    parampzy = parampzy.bytes;
    try
    {
      parampyl.mergeFrom(parampzy);
      parampzy = new ArrayList();
      if (parampyl.result.error_code.get() == 0)
      {
        paramErrorMessage = parampyl.poi_list.get();
        ram.d("LbsManager", "poiListSize = " + parampyl.poi_list.size());
        ram.d("LbsManager", "poiList isend = " + parampyl.is_end.get());
        if (paramErrorMessage.size() > 0) {
          if (parampyl.is_end.get() > 0)
          {
            i = 1;
            localObject = this.a;
            if (i != 0) {
              break label417;
            }
            bool = true;
            ((pub.d)localObject).ahL = bool;
            localObject = parampyl.next_cookie.get().toStringUtf8();
            if (this.a.ag.contains(localObject)) {
              break label457;
            }
            i = 0;
            for (;;)
            {
              if (i >= paramErrorMessage.size()) {
                break label435;
              }
              qqstory_struct.Address localAddress = (qqstory_struct.Address)paramErrorMessage.get(i);
              String str1 = localAddress.city.get().toStringUtf8();
              String str2 = localAddress.building.get().toStringUtf8();
              if (!localAddress.gps.has()) {
                break;
              }
              j = localAddress.gps.lng.get();
              String str3 = localAddress.street.get().toStringUtf8();
              if (!localAddress.gps.has()) {
                break label429;
              }
              k = localAddress.gps.lat.get();
              parampzy.add(new TroopBarPOI("", str1, str2, j, str3, k, localAddress.province.get().toString()));
              i += 1;
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException parampzy)
    {
      Object localObject;
      for (;;)
      {
        ram.e("LbsManager", "InvalidProtocolBufferMicroException: " + parampzy.getMessage());
        continue;
        int i = 0;
        continue;
        label417:
        boolean bool = false;
        continue;
        int j = 0;
        continue;
        label429:
        int k = 0;
      }
      label435:
      this.a.ag.add(localObject);
      this.a.avr = ((String)localObject);
      label457:
      paramErrorMessage = (pub.c)this.I.get();
      if (paramErrorMessage != null)
      {
        ThreadManager.getUIHandler().post(new LbsManager.3.2(this, paramErrorMessage, parampyl, parampzy));
        return;
      }
      ram.w("LbsManager", "POIListRequestCallback has been recycled.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pud
 * JD-Core Version:    0.7.0.1
 */