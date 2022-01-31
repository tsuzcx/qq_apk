import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class tyk
  extends SimpleObserver<ups>
{
  public tyk(tyf paramtyf) {}
  
  public void a(ups paramups)
  {
    super.onNext(paramups);
    tyf.a(this.a, paramups, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      tyf.a(this.a, tyf.a(this.a), new ErrorMessage(), false);
      return;
    }
    tyf.a(this.a, tyf.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyk
 * JD-Core Version:    0.7.0.1
 */