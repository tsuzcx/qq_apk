import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class uvo
  extends SimpleObserver<List<vhg>>
{
  uvo(uvn paramuvn, uvr paramuvr, utx paramutx) {}
  
  public void a(List<vhg> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    vhg localvhg;
    if (this.jdField_a_of_type_Uvr != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new uvp(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localvhg = (vhg)paramList.next();
          if (i < uvn.a(this.jdField_a_of_type_Uvn)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Uvr.a(this.jdField_a_of_type_Utx, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localvhg != null) && (!localvhg.jdField_a_of_type_Boolean) && (localvhg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localvhg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Uvr != null) {
      this.jdField_a_of_type_Uvr.a(this.jdField_a_of_type_Utx, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvo
 * JD-Core Version:    0.7.0.1
 */