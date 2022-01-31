import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class uoi
  extends SimpleObserver<Void>
{
  uoi(uog paramuog, uok paramuok) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    ved.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Uog.a = 2;
    this.jdField_a_of_type_Uok.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Uog.a = -1;
    this.jdField_a_of_type_Uok.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoi
 * JD-Core Version:    0.7.0.1
 */