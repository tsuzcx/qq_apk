import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class xhg
  extends SimpleObserver<xhh>
{
  public xhg(xhc paramxhc) {}
  
  public void a(xhh paramxhh)
  {
    super.onNext(paramxhh);
    xhc.a(this.a, paramxhh, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xhc.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhg
 * JD-Core Version:    0.7.0.1
 */