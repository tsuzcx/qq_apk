import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class wda
  extends SimpleObserver<Void>
{
  wda(wcy paramwcy, wdc paramwdc) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    wsv.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Wcy.a = 2;
    this.jdField_a_of_type_Wdc.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Wcy.a = -1;
    this.jdField_a_of_type_Wdc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wda
 * JD-Core Version:    0.7.0.1
 */