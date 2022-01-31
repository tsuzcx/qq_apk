import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class upr
  extends SimpleObserver<ups>
{
  public upr(upn paramupn) {}
  
  public void a(ups paramups)
  {
    super.onNext(paramups);
    upn.a(this.a, paramups, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    upn.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upr
 * JD-Core Version:    0.7.0.1
 */