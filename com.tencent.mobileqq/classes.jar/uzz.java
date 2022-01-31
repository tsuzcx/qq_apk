import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class uzz
  extends SimpleObserver<List<vlp>>
{
  uzz(uzw paramuzw, vaa paramvaa, uyg paramuyg) {}
  
  public void a(List<vlp> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyg, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyg, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzz
 * JD-Core Version:    0.7.0.1
 */