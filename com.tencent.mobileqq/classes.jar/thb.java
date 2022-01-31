import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class thb
  extends SimpleObserver<List<tsr>>
{
  thb(tgy paramtgy, thc paramthc, tfi paramtfi) {}
  
  public void a(List<tsr> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Thc != null) {
      this.jdField_a_of_type_Thc.a(this.jdField_a_of_type_Tfi, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Thc != null) {
      this.jdField_a_of_type_Thc.a(this.jdField_a_of_type_Tfi, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thb
 * JD-Core Version:    0.7.0.1
 */