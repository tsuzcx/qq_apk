import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class vmz
  extends SimpleObserver<weh>
{
  public vmz(vmu paramvmu) {}
  
  public void a(weh paramweh)
  {
    super.onNext(paramweh);
    vmu.a(this.a, paramweh, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      vmu.a(this.a, vmu.a(this.a), new ErrorMessage(), false);
      return;
    }
    vmu.a(this.a, vmu.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmz
 * JD-Core Version:    0.7.0.1
 */