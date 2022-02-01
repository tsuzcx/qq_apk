import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class xga
  extends SimpleObserver<Void>
{
  xga(xfy paramxfy, xgc paramxgc) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    xvv.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Xfy.a = 2;
    this.jdField_a_of_type_Xgc.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Xfy.a = -1;
    this.jdField_a_of_type_Xgc.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xga
 * JD-Core Version:    0.7.0.1
 */