import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class yca
  extends SimpleObserver<ycb>
{
  public yca(ybw paramybw) {}
  
  public void a(ycb paramycb)
  {
    super.onNext(paramycb);
    ybw.a(this.a, paramycb, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ybw.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yca
 * JD-Core Version:    0.7.0.1
 */