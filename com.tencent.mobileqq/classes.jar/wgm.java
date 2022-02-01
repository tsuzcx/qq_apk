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

public class wgm
  implements woy<wgo, wgp>
{
  private HashMap<String, wgf> jdField_a_of_type_JavaUtilHashMap;
  private wgn jdField_a_of_type_Wgn;
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)) {
      if (this.jdField_a_of_type_Wgn != null) {
        this.jdField_a_of_type_Wgn.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler no photo"), null);
      }
    }
    List localList;
    do
    {
      return;
      localList = wfv.a(this.jdField_a_of_type_JavaUtilHashMap);
      if (localList.size() != 0) {
        break;
      }
    } while (this.jdField_a_of_type_Wgn == null);
    this.jdField_a_of_type_Wgn.a(new ErrorMessage(-1, "CheckBlackGeoHashHandler gps error " + this.jdField_a_of_type_JavaUtilHashMap.toString()), null);
    return;
    wgo localwgo = new wgo();
    localwgo.a(localList);
    wow.a().a(localwgo, this);
  }
  
  public void a(@NonNull HashMap<String, wgf> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void a(wgn paramwgn)
  {
    this.jdField_a_of_type_Wgn = paramwgn;
  }
  
  public void a(@NonNull wgo paramwgo, @Nullable wgp paramwgp, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwgp == null) || (paramErrorMessage.isFail())) {
      if (this.jdField_a_of_type_Wgn != null) {
        this.jdField_a_of_type_Wgn.a(paramErrorMessage, null);
      }
    }
    label202:
    do
    {
      return;
      paramwgo = new ArrayList();
      if ((paramwgp.a != null) && (paramwgp.a.size() > 0))
      {
        paramwgp = paramwgp.a.iterator();
        for (;;)
        {
          if (!paramwgp.hasNext()) {
            break label202;
          }
          qqstory_struct.GpsMsg localGpsMsg1 = (qqstory_struct.GpsMsg)paramwgp.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            wgf localwgf = (wgf)((Map.Entry)localIterator.next()).getValue();
            if (localwgf.jdField_a_of_type_Whl == null) {
              break;
            }
            qqstory_struct.GpsMsg localGpsMsg2 = localwgf.jdField_a_of_type_Whl.a();
            if ((localGpsMsg2.lat.get() != localGpsMsg1.lat.get()) || (localGpsMsg2.lng.get() != localGpsMsg1.lng.get())) {
              break;
            }
            paramwgo.add(localwgf.jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (this.jdField_a_of_type_Wgn == null);
    this.jdField_a_of_type_Wgn.a(paramErrorMessage, paramwgo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */