import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class wtl
  extends SimpleObserver<List<xfb>>
{
  wtl(wti paramwti, wtm paramwtm, wrs paramwrs) {}
  
  public void a(List<xfb> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Wtm != null) {
      this.jdField_a_of_type_Wtm.a(this.jdField_a_of_type_Wrs, Collections.emptyList());
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
 * Qualified Name:     wtl
 * JD-Core Version:    0.7.0.1
 */