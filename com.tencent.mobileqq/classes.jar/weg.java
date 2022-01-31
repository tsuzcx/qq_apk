import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class weg
  extends SimpleObserver<weh>
{
  public weg(wec paramwec) {}
  
  public void a(weh paramweh)
  {
    super.onNext(paramweh);
    wec.a(this.a, paramweh, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wec.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     weg
 * JD-Core Version:    0.7.0.1
 */