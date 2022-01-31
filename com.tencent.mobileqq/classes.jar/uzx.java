import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class uzx
  extends SimpleObserver<List<vlp>>
{
  uzx(uzw paramuzw, vaa paramvaa, uyg paramuyg) {}
  
  public void a(List<vlp> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    vlp localvlp;
    if (this.jdField_a_of_type_Vaa != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new uzy(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localvlp = (vlp)paramList.next();
          if (i < uzw.a(this.jdField_a_of_type_Uzw)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyg, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localvlp != null) && (!localvlp.jdField_a_of_type_Boolean) && (localvlp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localvlp.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyg, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */