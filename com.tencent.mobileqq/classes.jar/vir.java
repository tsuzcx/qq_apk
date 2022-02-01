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

public class vir
  implements vqp<vit, viu>
{
  private HashMap<String, vik> jdField_a_of_type_JavaUtilHashMap;
  private vis jdField_a_of_type_Vis;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Vis != null) {
        this.jdField_a_of_type_Vis.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = via.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Vis == null);
    this.jdField_a_of_type_Vis.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    vit localvit = new vit();
    localvit.a(localList);
    vqn.a().a(localvit, this);
  }
  
  public void a(@NonNull HashMap<String, vik> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(vis paramvis)
  {
    this.jdField_a_of_type_Vis = paramvis;
  }
  
  public void a(@NonNull vit paramvit, @Nullable viu paramviu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramviu == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Vis != null) {
        this.jdField_a_of_type_Vis.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramvit = new ArrayList();
      if ((paramviu.a != null) && (paramviu.a.size() > 0))
      {
        paramviu = paramviu.a.iterator();
        for (;;)
        {
          if (!paramviu.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramviu.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            vik localvik = (vik)((Map.Entry)localIterator.next()).getValue();
            if (localvik.jdField_a_of_type_Vjq == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localvik.jdField_a_of_type_Vjq.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramvit.add(localvik.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Vis == null);
    this.jdField_a_of_type_Vis.a(paramErrorMessage, paramvit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vir
 * JD-Core Version:    0.7.0.1
 */