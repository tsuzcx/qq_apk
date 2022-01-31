import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tlr
  extends QQUIEventReceiver<tlj, sxr>
{
  public tlr(@NonNull tlj paramtlj)
  {
    super(paramtlj);
  }
  
  public void a(@NonNull tlj paramtlj, @NonNull sxr paramsxr)
  {
    if (paramsxr.a.isSuccess())
    {
      urk.a(this.TAG, "receive user info event. %s.", paramsxr.toString());
      paramtlj = paramtlj.a();
      if (paramtlj != null) {
        paramtlj.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlr
 * JD-Core Version:    0.7.0.1
 */