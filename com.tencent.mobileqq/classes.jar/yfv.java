import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class yfv
  extends SimpleObserver<yfw>
{
  public yfv(yfr paramyfr) {}
  
  public void a(yfw paramyfw)
  {
    super.onNext(paramyfw);
    yfr.a(this.a, paramyfw, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yfr.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */