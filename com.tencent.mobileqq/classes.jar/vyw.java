import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class vyw
  extends SimpleObserver<List<wkm>>
{
  vyw(vyt paramvyt, vyx paramvyx, vxd paramvxd) {}
  
  public void a(List<wkm> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Vyx != null) {
      this.jdField_a_of_type_Vyx.a(this.jdField_a_of_type_Vxd, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Vyx != null) {
      this.jdField_a_of_type_Vyx.a(this.jdField_a_of_type_Vxd, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyw
 * JD-Core Version:    0.7.0.1
 */