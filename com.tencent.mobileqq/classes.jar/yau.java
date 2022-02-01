import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class yau
  extends SimpleObserver<Void>
{
  yau(yas paramyas, yaw paramyaw) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    yqp.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Yas.a = 2;
    this.jdField_a_of_type_Yaw.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Yas.a = -1;
    this.jdField_a_of_type_Yaw.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yau
 * JD-Core Version:    0.7.0.1
 */