import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class tyh
  extends SimpleObserver<upp>
{
  public tyh(tyc paramtyc) {}
  
  public void a(upp paramupp)
  {
    super.onNext(paramupp);
    tyc.a(this.a, paramupp, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      tyc.a(this.a, tyc.a(this.a), new ErrorMessage(), false);
      return;
    }
    tyc.a(this.a, tyc.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyh
 * JD-Core Version:    0.7.0.1
 */