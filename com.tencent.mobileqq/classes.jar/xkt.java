import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class xkt
  extends SimpleObserver<ycb>
{
  public xkt(xko paramxko) {}
  
  public void a(ycb paramycb)
  {
    super.onNext(paramycb);
    xko.a(this.a, paramycb, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      xko.a(this.a, xko.a(this.a), new ErrorMessage(), false);
      return;
    }
    xko.a(this.a, xko.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkt
 * JD-Core Version:    0.7.0.1
 */