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

public class vxi
  implements wfk<vxk, vxl>
{
  private long jdField_a_of_type_Long;
  private ErrorMessage jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  private HashMap<String, vxf> jdField_a_of_type_JavaUtilHashMap;
  private List<vxk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vxj jdField_a_of_type_Vxj;
  private HashMap<String, AddressItem> b = new HashMap();
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      ykq.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handleResult. all request has finish timecost=%s, errorInfo=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage });
      if (this.jdField_a_of_type_Vxj != null) {
        this.jdField_a_of_type_Vxj.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage, this.b);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (this.jdField_a_of_type_Vxj != null) {
        this.jdField_a_of_type_Vxj.a(new ErrorMessage(-1, "BatchGetPoiListHandler no photo"), null);
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      List localList1 = vwv.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList1.size() == 0)
      {
        if (this.jdField_a_of_type_Vxj != null) {
          this.jdField_a_of_type_Vxj.a(new ErrorMessage(-1, "BatchGetPoiListHandler gps error"), null);
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
          ykq.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "send last batch length=%d", new Object[] { Integer.valueOf(k - m) });
          List localList2 = localObject.subList(m, k);
          vxk localvxk = new vxk();
          localvxk.a(localList2);
          this.jdField_a_of_type_JavaUtilList.add(localvxk);
          wfi.a().a(localvxk, this);
          j += 1;
          break;
        }
      }
      ykq.d("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "sendRequest total=%d, batch count=%d", new Object[] { Integer.valueOf(localObject.size()), Integer.valueOf(i) });
      return;
      j = 0;
    }
  }
  
  public void a(@NonNull HashMap<String, vxf> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(vxj paramvxj)
  {
    this.jdField_a_of_type_Vxj = paramvxj;
  }
  
  public void a(@NonNull vxk paramvxk, @Nullable vxl paramvxl, @NonNull ErrorMessage paramErrorMessage)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramvxk);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      if ((paramvxl == null) || (paramErrorMessage.isFail()))
      {
        b();
        return;
      }
    }
    finally {}
    paramErrorMessage = new HashMap(this.jdField_a_of_type_JavaUtilHashMap.size());
    if (paramvxl.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator1 = paramvxl.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label234;
        }
        AddressItem localAddressItem = (AddressItem)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator2.hasNext())
        {
          vxf localvxf = (vxf)((Map.Entry)localIterator2.next()).getValue();
          if (localvxf.jdField_a_of_type_Vyl == null) {
            break;
          }
          qqstory_struct.GpsMsg localGpsMsg = localvxf.jdField_a_of_type_Vyl.a();
          if ((localGpsMsg.lat.get() != localAddressItem.latitude) || (localGpsMsg.lng.get() != localAddressItem.longitude)) {
            break;
          }
          paramErrorMessage.put(localvxf.jdField_a_of_type_JavaLangString, localAddressItem);
        }
      }
    }
    label234:
    if (paramvxl.jdField_a_of_type_JavaUtilList.size() != paramvxk.a()) {
      ykq.e("Q.qqstory.recommendAlbum.logic.BatchGetPoiListHandler", "handle poi request. request length=%d, rsp length=%d", new Object[] { Integer.valueOf(paramvxk.a()), Integer.valueOf(paramvxl.jdField_a_of_type_JavaUtilList.size()) });
    }
    this.b.putAll(paramErrorMessage);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxi
 * JD-Core Version:    0.7.0.1
 */