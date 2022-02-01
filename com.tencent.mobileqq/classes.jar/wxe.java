import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wxe
  extends SimpleObserver<List<xiw>>
{
  wxe(wxd paramwxd, wxh paramwxh, wvn paramwvn) {}
  
  public void a(List<xiw> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    xiw localxiw;
    if (this.jdField_a_of_type_Wxh != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new wxf(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localxiw = (xiw)paramList.next();
          if (i < wxd.a(this.jdField_a_of_type_Wxd)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Wxh.a(this.jdField_a_of_type_Wvn, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localxiw != null) && (!localxiw.jdField_a_of_type_Boolean) && (localxiw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localxiw.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Wxh != null) {
      this.jdField_a_of_type_Wxh.a(this.jdField_a_of_type_Wvn, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxe
 * JD-Core Version:    0.7.0.1
 */