import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class wnr
  extends SimpleObserver<List<wzh>>
{
  wnr(wno paramwno, wns paramwns, wly paramwly) {}
  
  public void a(List<wzh> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Wns != null) {
      this.jdField_a_of_type_Wns.a(this.jdField_a_of_type_Wly, Collections.emptyList());
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
 * Qualified Name:     wnr
 * JD-Core Version:    0.7.0.1
 */