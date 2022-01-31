import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzp
  extends QQUIEventReceiver<tzo, tzt>
{
  public tzp(@NonNull tzo paramtzo)
  {
    super(paramtzo);
  }
  
  public void a(@NonNull tzo paramtzo, @NonNull tzt paramtzt)
  {
    if (paramtzt.a.isSuccess())
    {
      ved.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramtzt.toString());
      paramtzo.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return tzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzp
 * JD-Core Version:    0.7.0.1
 */