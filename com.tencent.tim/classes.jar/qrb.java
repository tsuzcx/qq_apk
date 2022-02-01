import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;

class qrb
  extends SimpleObserver<Void>
{
  qrb(qqz paramqqz, qqz.a parama) {}
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_Qqz.bnI = -1;
    this.jdField_a_of_type_Qqz$a.onError();
  }
  
  public void onNext(Void paramVoid)
  {
    super.onNext(paramVoid);
    ram.d("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_Qqz.bnI = 2;
    this.jdField_a_of_type_Qqz$a.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrb
 * JD-Core Version:    0.7.0.1
 */