import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class tlo
  extends SimpleObserver<ucw>
{
  public tlo(tlj paramtlj) {}
  
  public void a(ucw paramucw)
  {
    super.onNext(paramucw);
    tlj.a(this.a, paramucw, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      tlj.a(this.a, tlj.a(this.a), new ErrorMessage(), false);
      return;
    }
    tlj.a(this.a, tlj.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlo
 * JD-Core Version:    0.7.0.1
 */