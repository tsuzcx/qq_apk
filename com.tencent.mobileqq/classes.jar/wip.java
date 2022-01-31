import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class wip
  extends SimpleObserver<wiq>
{
  public wip(wil paramwil) {}
  
  public void a(wiq paramwiq)
  {
    super.onNext(paramwiq);
    wil.a(this.a, paramwiq, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wil.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wip
 * JD-Core Version:    0.7.0.1
 */