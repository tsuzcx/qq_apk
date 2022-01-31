import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class upo
  extends SimpleObserver<upp>
{
  public upo(upk paramupk) {}
  
  public void a(upp paramupp)
  {
    super.onNext(paramupp);
    upk.a(this.a, paramupp, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    upk.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upo
 * JD-Core Version:    0.7.0.1
 */