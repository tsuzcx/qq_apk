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

public class vxm
  implements wfk<vxo, vxp>
{
  private HashMap<String, vxf> jdField_a_of_type_JavaUtilHashMap;
  private vxn jdField_a_of_type_Vxn;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Vxn != null) {
        this.jdField_a_of_type_Vxn.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = vwv.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Vxn == null);
    this.jdField_a_of_type_Vxn.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    vxo localvxo = new vxo();
    localvxo.a(localList);
    wfi.a().a(localvxo, this);
  }
  
  public void a(@NonNull HashMap<String, vxf> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(vxn paramvxn)
  {
    this.jdField_a_of_type_Vxn = paramvxn;
  }
  
  public void a(@NonNull vxo paramvxo, @Nullable vxp paramvxp, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvxp == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Vxn != null) {
        this.jdField_a_of_type_Vxn.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramvxo = new ArrayList();
      if ((paramvxp.a != null) && (paramvxp.a.size() > 0))
      {
        paramvxp = paramvxp.a.iterator();
        for (;;)
        {
          if (!paramvxp.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramvxp.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            vxf localvxf = (vxf)((Map.Entry)localIterator.next()).getValue();
            if (localvxf.jdField_a_of_type_Vyl == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localvxf.jdField_a_of_type_Vyl.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramvxo.add(localvxf.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Vxn == null);
    this.jdField_a_of_type_Vxn.a(paramErrorMessage, paramvxo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxm
 * JD-Core Version:    0.7.0.1
 */