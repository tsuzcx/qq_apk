import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wnp
  extends SimpleObserver<List<wzh>>
{
  wnp(wno paramwno, wns paramwns, wly paramwly) {}
  
  public void a(List<wzh> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    wzh localwzh;
    if (this.jdField_a_of_type_Wns != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new wnq(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localwzh = (wzh)paramList.next();
          if (i < wno.a(this.jdField_a_of_type_Wno)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Wns.a(this.jdField_a_of_type_Wly, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localwzh != null) && (!localwzh.jdField_a_of_type_Boolean) && (localwzh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localwzh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
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
    if (this.jdField_a_of_type_Wns != null) {
      this.jdField_a_of_type_Wns.a(this.jdField_a_of_type_Wly, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */