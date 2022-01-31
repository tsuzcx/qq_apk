import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class ucv
  extends SimpleObserver<ucw>
{
  public ucv(ucr paramucr) {}
  
  public void a(ucw paramucw)
  {
    super.onNext(paramucw);
    ucr.a(this.a, paramucw, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ucr.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucv
 * JD-Core Version:    0.7.0.1
 */