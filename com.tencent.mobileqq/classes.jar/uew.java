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

public class uew
  implements uni<uey, uez>
{
  private HashMap<String, uep> jdField_a_of_type_JavaUtilHashMap;
  private uex jdField_a_of_type_Uex;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Uex != null) {
        this.jdField_a_of_type_Uex.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = uef.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Uex == null);
    this.jdField_a_of_type_Uex.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    uey localuey = new uey();
    localuey.a(localList);
    ung.a().a(localuey, this);
  }
  
  public void a(@NonNull HashMap<String, uep> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(uex paramuex)
  {
    this.jdField_a_of_type_Uex = paramuex;
  }
  
  public void a(@NonNull uey paramuey, @Nullable uez paramuez, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramuez == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Uex != null) {
        this.jdField_a_of_type_Uex.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramuey = new ArrayList();
      if ((paramuez.a != null) && (paramuez.a.size() > 0))
      {
        paramuez = paramuez.a.iterator();
        for (;;)
        {
          if (!paramuez.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramuez.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            uep localuep = (uep)((Map.Entry)localIterator.next()).getValue();
            if (localuep.jdField_a_of_type_Ufv == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localuep.jdField_a_of_type_Ufv.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramuey.add(localuep.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Uex == null);
    this.jdField_a_of_type_Uex.a(paramErrorMessage, paramuey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uew
 * JD-Core Version:    0.7.0.1
 */