import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class xuv
  extends SimpleObserver<Void>
{
  xuv(xut paramxut, xux paramxux) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    ykq.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Xut.a = 2;
    this.jdField_a_of_type_Xux.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Xut.a = -1;
    this.jdField_a_of_type_Xux.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuv
 * JD-Core Version:    0.7.0.1
 */