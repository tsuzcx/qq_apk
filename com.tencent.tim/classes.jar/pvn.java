import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class pvn
  extends SimpleObserver<List<qej>>
{
  pvn(pvm parampvm, pvm.a parama, puh parampuh) {}
  
  public void dJ(List<qej> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    qej localqej;
    if (this.jdField_b_of_type_Pvm$a != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new pvo(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localqej = (qej)paramList.next();
          if (i < pvm.a(this.jdField_b_of_type_Pvm)) {
            break label100;
          }
        }
      }
      this.jdField_b_of_type_Pvm$a.a(this.f, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localqej != null) && (!localqej.aBR) && (localqej.g != null))
    {
      localArrayList.add(localqej.g);
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
    if (this.jdField_b_of_type_Pvm$a != null) {
      this.jdField_b_of_type_Pvm$a.a(this.f, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvn
 * JD-Core Version:    0.7.0.1
 */