import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class vyu
  extends SimpleObserver<List<wkm>>
{
  vyu(vyt paramvyt, vyx paramvyx, vxd paramvxd) {}
  
  public void a(List<wkm> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    wkm localwkm;
    if (this.jdField_a_of_type_Vyx != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new vyv(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localwkm = (wkm)paramList.next();
          if (i < vyt.a(this.jdField_a_of_type_Vyt)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Vyx.a(this.jdField_a_of_type_Vxd, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localwkm != null) && (!localwkm.jdField_a_of_type_Boolean) && (localwkm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localwkm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Vyx != null) {
      this.jdField_a_of_type_Vyx.a(this.jdField_a_of_type_Vxd, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyu
 * JD-Core Version:    0.7.0.1
 */