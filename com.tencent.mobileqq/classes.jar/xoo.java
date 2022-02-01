import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class xoo
  extends SimpleObserver<yfw>
{
  public xoo(xoj paramxoj) {}
  
  public void a(yfw paramyfw)
  {
    super.onNext(paramyfw);
    xoj.a(this.a, paramyfw, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      xoj.a(this.a, xoj.a(this.a), new ErrorMessage(), false);
      return;
    }
    xoj.a(this.a, xoj.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoo
 * JD-Core Version:    0.7.0.1
 */