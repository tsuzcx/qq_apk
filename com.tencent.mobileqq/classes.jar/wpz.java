import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class wpz
  extends SimpleObserver<xhh>
{
  public wpz(wpu paramwpu) {}
  
  public void a(xhh paramxhh)
  {
    super.onNext(paramxhh);
    wpu.a(this.a, paramxhh, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      wpu.a(this.a, wpu.a(this.a), new ErrorMessage(), false);
      return;
    }
    wpu.a(this.a, wpu.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpz
 * JD-Core Version:    0.7.0.1
 */