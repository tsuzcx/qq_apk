import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class pvp
  extends SimpleObserver<List<qej>>
{
  pvp(pvm parampvm, pvm.a parama, puh parampuh) {}
  
  public void dJ(List<qej> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_b_of_type_Pvm$a != null) {
      this.jdField_b_of_type_Pvm$a.a(this.f, Collections.emptyList());
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
 * Qualified Name:     pvp
 * JD-Core Version:    0.7.0.1
 */