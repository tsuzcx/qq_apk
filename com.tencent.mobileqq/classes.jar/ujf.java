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

public class ujf
  implements urr<ujh, uji>
{
  private HashMap<String, uiy> jdField_a_of_type_JavaUtilHashMap;
  private ujg jdField_a_of_type_Ujg;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Ujg != null) {
        this.jdField_a_of_type_Ujg.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = uio.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Ujg == null);
    this.jdField_a_of_type_Ujg.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    ujh localujh = new ujh();
    localujh.a(localList);
    urp.a().a(localujh, this);
  }
  
  public void a(@NonNull HashMap<String, uiy> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(ujg paramujg)
  {
    this.jdField_a_of_type_Ujg = paramujg;
  }
  
  public void a(@NonNull ujh paramujh, @Nullable uji paramuji, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramuji == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Ujg != null) {
        this.jdField_a_of_type_Ujg.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramujh = new ArrayList();
      if ((paramuji.a != null) && (paramuji.a.size() > 0))
      {
        paramuji = paramuji.a.iterator();
        for (;;)
        {
          if (!paramuji.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramuji.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            uiy localuiy = (uiy)((Map.Entry)localIterator.next()).getValue();
            if (localuiy.jdField_a_of_type_Uke == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localuiy.jdField_a_of_type_Uke.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramujh.add(localuiy.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Ujg == null);
    this.jdField_a_of_type_Ujg.a(paramErrorMessage, paramujh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */