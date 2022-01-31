import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class tgy
  extends SimpleObserver<List<tso>>
{
  tgy(tgv paramtgv, tgz paramtgz, tff paramtff) {}
  
  public void a(List<tso> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Tgz != null) {
      this.jdField_a_of_type_Tgz.a(this.jdField_a_of_type_Tff, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Tgz != null) {
      this.jdField_a_of_type_Tgz.a(this.jdField_a_of_type_Tff, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgy
 * JD-Core Version:    0.7.0.1
 */