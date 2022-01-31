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

public class ues
  implements uni<ueu, uev>
{
  private long jdField_a_of_type_Long;
  private ErrorMessage jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  private HashMap<String, uep> jdField_a_of_type_JavaUtilHashMap;
  private List<ueu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uet jdField_a_of_type_Uet;
  private HashMap<String, AddressItem> b = new HashMap();
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage });
      if (this.jdField_a_of_type_Uet != null) {
        this.jdField_a_of_type_Uet.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, this.b);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_Uet != null) {
        this.jdField_a_of_type_Uet.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      List localList1 = uef.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList1.size() == 0)
      {
        if (this.jdField_a_of_type_Uet != null) {
          this.jdField_a_of_type_Uet.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
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
          wsv.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
          List localList2 = localObject.subList(m, k);
          ueu localueu = new ueu();
          localueu.a(localList2);
          this.jdField_a_of_type_JavaUtilList.add(localueu);
          ung.a().a(localueu, this);
          j += 1;
          break;
        }
      }
      wsv.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(localObject.size()), Integer.valueOf(i) });
      return;
      j = 0;
    }
  }
  
  public void a(@NonNull HashMap<String, uep> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(uet paramuet)
  {
    this.jdField_a_of_type_Uet = paramuet;
  }
  
  public void a(@NonNull ueu paramueu, @Nullable uev paramuev, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramueu);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramuev == null) || (paramErrorMessage.isFail()))
      {
        b();
        return;
      }
    }
    finally {}
    paramErrorMessage = new HashMap(this.jdField_a_of_type_JavaUtilHashMap.size());
    if (paramuev.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator1 = paramuev.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label234;
        }
        AddressItem localAddressItem = (AddressItem)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator2.hasNext())
        {
          uep localuep = (uep)((Map.Entry)localIterator2.next()).getValue();
          if (localuep.jdField_a_of_type_Ufv == null) {
            break;
          }
          qqstory_struct.GpsMsg localGpsMsg = localuep.jdField_a_of_type_Ufv.a();
          if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
            break;
          }
          paramErrorMessage.put(localuep.jdField_a_of_type_JavaLangString, localAddressItem);
        }
      }
    }
    label234:
    if (paramuev.jdField_a_of_type_JavaUtilList.size() != paramueu.a()) {
      wsv.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(paramueu.a()), Integer.valueOf(paramuev.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.b.putAll(paramErrorMessage);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ues
 * JD-Core Version:    0.7.0.1
 */