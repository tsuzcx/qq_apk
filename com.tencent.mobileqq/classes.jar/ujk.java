import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ujk
  extends QQUIEventReceiver<uji, tkk>
{
  public ujk(@NonNull uji paramuji)
  {
    super(paramuji);
  }
  
  public void a(@NonNull uji paramuji, @NonNull tkk paramtkk)
  {
    if (paramtkk.a.isSuccess())
    {
      ved.a(this.TAG, "receive user info event. %s.", paramtkk.toString());
      paramuji.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujk
 * JD-Core Version:    0.7.0.1
 */