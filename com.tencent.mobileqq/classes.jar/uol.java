import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class uol
  extends SimpleObserver<Void>
{
  uol(uoj paramuoj, uon paramuon) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    veg.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Uoj.a = 2;
    this.jdField_a_of_type_Uon.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Uoj.a = -1;
    this.jdField_a_of_type_Uon.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uol
 * JD-Core Version:    0.7.0.1
 */