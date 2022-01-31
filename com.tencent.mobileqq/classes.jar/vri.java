import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

public class vri
  extends SimpleObserver<wiq>
{
  public vri(vrd paramvrd) {}
  
  public void a(wiq paramwiq)
  {
    super.onNext(paramwiq);
    vrd.a(this.a, paramwiq, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      vrd.a(this.a, vrd.a(this.a), new ErrorMessage(), false);
      return;
    }
    vrd.a(this.a, vrd.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vri
 * JD-Core Version:    0.7.0.1
 */