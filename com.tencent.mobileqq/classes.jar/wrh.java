import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrh
  extends QQUIEventReceiver<wrg, wrl>
{
  public wrh(@NonNull wrg paramwrg)
  {
    super(paramwrg);
  }
  
  public void a(@NonNull wrg paramwrg, @NonNull wrl paramwrl)
  {
    if (paramwrl.a.isSuccess())
    {
      xvv.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramwrl.toString());
      paramwrg.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */