import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class whj
  extends SimpleObserver<Void>
{
  whj(whh paramwhh, whl paramwhl) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    wxe.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Whh.a = 2;
    this.jdField_a_of_type_Whl.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Whh.a = -1;
    this.jdField_a_of_type_Whl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whj
 * JD-Core Version:    0.7.0.1
 */