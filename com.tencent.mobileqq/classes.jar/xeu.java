import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class xeu
  extends SimpleObserver<xwc>
{
  public xeu(xep paramxep) {}
  
  public void a(xwc paramxwc)
  {
    super.onNext(paramxwc);
    xep.a(this.a, paramxwc, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      xep.a(this.a, xep.a(this.a), new ErrorMessage(), false);
      return;
    }
    xep.a(this.a, xep.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xeu
 * JD-Core Version:    0.7.0.1
 */