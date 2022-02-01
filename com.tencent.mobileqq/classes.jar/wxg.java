import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class wxg
  extends SimpleObserver<List<xiw>>
{
  wxg(wxd paramwxd, wxh paramwxh, wvn paramwvn) {}
  
  public void a(List<xiw> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_Wxh != null) {
      this.jdField_a_of_type_Wxh.a(this.jdField_a_of_type_Wvn, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Wxh != null) {
      this.jdField_a_of_type_Wxh.a(this.jdField_a_of_type_Wvn, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxg
 * JD-Core Version:    0.7.0.1
 */