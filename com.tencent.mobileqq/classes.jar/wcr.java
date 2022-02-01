import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class wcr
  implements wld<wct, wcu>
{
  private HashMap<String, wck> jdField_a_of_type_JavaUtilHashMap;
  private wcs jdField_a_of_type_Wcs;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Wcs != null) {
        this.jdField_a_of_type_Wcs.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = wca.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Wcs == null);
    this.jdField_a_of_type_Wcs.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    wct localwct = new wct();
    localwct.a(localList);
    wlb.a().a(localwct, this);
  }
  
  public void a(@NonNull HashMap<String, wck> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(wcs paramwcs)
  {
    this.jdField_a_of_type_Wcs = paramwcs;
  }
  
  public void a(@NonNull wct paramwct, @Nullable wcu paramwcu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwcu == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Wcs != null) {
        this.jdField_a_of_type_Wcs.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramwct = new ArrayList();
      if ((paramwcu.a != null) && (paramwcu.a.size() > 0))
      {
        paramwcu = paramwcu.a.iterator();
        for (;;)
        {
          if (!paramwcu.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramwcu.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            wck localwck = (wck)((Map.Entry)localIterator.next()).getValue();
            if (localwck.jdField_a_of_type_Wdq == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localwck.jdField_a_of_type_Wdq.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramwct.add(localwck.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Wcs == null);
    this.jdField_a_of_type_Wcs.a(paramErrorMessage, paramwct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcr
 * JD-Core Version:    0.7.0.1
 */