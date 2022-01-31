import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class uvq
  extends SimpleObserver<List<vhg>>
{
  uvq(uvn paramuvn, uvr paramuvr, utx paramutx) {}
  
  public void a(List<vhg> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Uvr != null) {
      this.jdField_a_of_type_Uvr.a(this.jdField_a_of_type_Utx, Collections.emptyList());
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
 * Qualified Name:     uvq
 * JD-Core Version:    0.7.0.1
 */