import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class xwb
  extends SimpleObserver<xwc>
{
  public xwb(xvx paramxvx) {}
  
  public void a(xwc paramxwc)
  {
    super.onNext(paramxwc);
    xvx.a(this.a, paramxwc, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvx.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwb
 * JD-Core Version:    0.7.0.1
 */