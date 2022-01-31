import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tzs
  extends QQUIEventReceiver<tzr, tzw>
{
  public tzs(@NonNull tzr paramtzr)
  {
    super(paramtzr);
  }
  
  public void a(@NonNull tzr paramtzr, @NonNull tzw paramtzw)
  {
    if (paramtzw.a.isSuccess())
    {
      veg.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramtzw.toString());
      paramtzr.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return tzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzs
 * JD-Core Version:    0.7.0.1
 */