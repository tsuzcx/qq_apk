import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class ubp
  extends SimpleObserver<Void>
{
  ubp(ubn paramubn, ubr paramubr) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    urk.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Ubn.a = 2;
    this.jdField_a_of_type_Ubr.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Ubn.a = -1;
    this.jdField_a_of_type_Ubr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubp
 * JD-Core Version:    0.7.0.1
 */