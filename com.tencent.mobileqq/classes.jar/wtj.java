import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wtj
  extends SimpleObserver<List<xfb>>
{
  wtj(wti paramwti, wtm paramwtm, wrs paramwrs) {}
  
  public void a(List<xfb> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    xfb localxfb;
    if (this.jdField_a_of_type_Wtm != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new wtk(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localxfb = (xfb)paramList.next();
          if (i < wti.a(this.jdField_a_of_type_Wti)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Wtm.a(this.jdField_a_of_type_Wrs, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localxfb != null) && (!localxfb.jdField_a_of_type_Boolean) && (localxfb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localxfb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Wtm != null) {
      this.jdField_a_of_type_Wtm.a(this.jdField_a_of_type_Wrs, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtj
 * JD-Core Version:    0.7.0.1
 */