import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class tgw
  extends SimpleObserver<List<tso>>
{
  tgw(tgv paramtgv, tgz paramtgz, tff paramtff) {}
  
  public void a(List<tso> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    tso localtso;
    if (this.jdField_a_of_type_Tgz != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new tgx(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localtso = (tso)paramList.next();
          if (i < tgv.a(this.jdField_a_of_type_Tgv)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Tgz.a(this.jdField_a_of_type_Tff, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localtso != null) && (!localtso.jdField_a_of_type_Boolean) && (localtso.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localtso.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Tgz != null) {
      this.jdField_a_of_type_Tgz.a(this.jdField_a_of_type_Tff, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgw
 * JD-Core Version:    0.7.0.1
 */