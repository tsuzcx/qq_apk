import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class pke
  implements ppv.b<pkf, pkf.a>
{
  private ErrorMessage jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  private pke.a jdField_a_of_type_Pke$a;
  private HashMap<String, pkc> fc;
  private HashMap<String, AddressItem> fd = new HashMap();
  private List<pkf> lV = new ArrayList();
  private long mStartRequestTime;
  
  private void bln()
  {
    if (this.lV.size() == 0)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.mStartRequestTime), this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage });
      if (this.jdField_a_of_type_Pke$a != null) {
        this.jdField_a_of_type_Pke$a.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, this.fd);
      }
    }
  }
  
  public void a(pke.a parama)
  {
    this.jdField_a_of_type_Pke$a = parama;
  }
  
  public void a(@NonNull pkf parampkf, @Nullable pkf.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.lV.remove(parampkf);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        bln();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((parama == null) || (paramErrorMessage.isFail()))
      {
        bln();
        return;
      }
    }
    finally {}
    paramErrorMessage = new HashMap(this.fc.size());
    if (parama.lX.size() > 0)
    {
      Iterator localIterator1 = parama.lX.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label234;
        }
        AddressItem localAddressItem = (AddressItem)localIterator1.next();
        Iterator localIterator2 = this.fc.entrySet().iterator();
        if (localIterator2.hasNext())
        {
          pkc localpkc = (pkc)((Map.Entry)localIterator2.next()).getValue();
          if (localpkc.a == null) {
            break;
          }
          qqstory_struct.GpsMsg localGpsMsg = localpkc.a.a();
          if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
            break;
          }
          paramErrorMessage.put(localpkc.geohashString, localAddressItem);
        }
      }
    }
    label234:
    if (parama.lX.size() != parampkf.si()) {
      ram.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(parampkf.si()), Integer.valueOf(parama.lX.size()) });
    }
    this.fd.putAll(paramErrorMessage);
    bln();
  }
  
  public void sendRequest()
  {
    if ((this.fc == null) || (this.fc.size() == 0))
    {
      if (this.jdField_a_of_type_Pke$a != null) {
        this.jdField_a_of_type_Pke$a.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
      }
      return;
    }
    try
    {
      this.mStartRequestTime = SystemClock.uptimeMillis();
      List localList1 = pju.a(this.fc);
      if (localList1.size() == 0)
      {
        if (this.jdField_a_of_type_Pke$a != null) {
          this.jdField_a_of_type_Pke$a.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
        }
        return;
      }
    }
    finally {}
    int j = localObject.size() / 100;
    int i = j;
    if (localObject.size() % 100 > 0) {
      i = j + 1;
    }
    for (;;)
    {
      if (j < i)
      {
        int m = j * 100;
        if (m + 100 <= localObject.size()) {}
        for (int k = m + 100;; k = localObject.size())
        {
          ram.w("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
          List localList2 = localObject.subList(m, k);
          pkf localpkf = new pkf();
          localpkf.dO(localList2);
          this.lV.add(localpkf);
          ppv.a().a(localpkf, this);
          j += 1;
          break;
        }
      }
      ram.w("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(localObject.size()), Integer.valueOf(i) });
      return;
      j = 0;
    }
  }
  
  public void t(@NonNull HashMap<String, pkc> paramHashMap)
  {
    this.fc = paramHashMap;
  }
  
  public static abstract interface a
  {
    public abstract void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pke
 * JD-Core Version:    0.7.0.1
 */