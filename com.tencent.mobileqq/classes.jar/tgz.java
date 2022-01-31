import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class tgz
  extends SimpleObserver<List<tsr>>
{
  tgz(tgy paramtgy, thc paramthc, tfi paramtfi) {}
  
  public void a(List<tsr> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    tsr localtsr;
    if (this.jdField_a_of_type_Thc != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new tha(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localtsr = (tsr)paramList.next();
          if (i < tgy.a(this.jdField_a_of_type_Tgy)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Thc.a(this.jdField_a_of_type_Tfi, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localtsr != null) && (!localtsr.jdField_a_of_type_Boolean) && (localtsr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localtsr.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Thc != null) {
      this.jdField_a_of_type_Thc.a(this.jdField_a_of_type_Tfi, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgz
 * JD-Core Version:    0.7.0.1
 */