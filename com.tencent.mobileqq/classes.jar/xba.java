import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class xba
  extends QQUIEventReceiver<xax, wtz>
{
  public xba(@NonNull xax paramxax)
  {
    super(paramxax);
  }
  
  private void b(xax paramxax, wtz paramwtz)
  {
    Object localObject = ((wwg)xax.a(paramxax).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramwtz.b.equals(((wvn)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    wvn localwvn;
    do
    {
      return;
      localObject = (wjk)xax.a(paramxax).getManager(197);
      localwvn = ((wjk)localObject).b(paramwtz.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localwvn + "\nmanager: " + localObject);
      }
    } while (localwvn == null);
    int i = localwvn.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        wwf localwwf = (wwf)localwvn.a.get(i);
        if ((localwwf.jdField_a_of_type_Long == paramwtz.jdField_a_of_type_Long) && (!localwwf.jdField_a_of_type_Boolean))
        {
          localwwf.jdField_a_of_type_Boolean = true;
          localwvn.b -= 1;
        }
      }
      else
      {
        ((wjk)localObject).c(localwvn);
        ((wjk)localObject).b(localwvn);
        paramxax = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramxax);
        ThreadManager.getUIHandler().post(paramxax);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull xax paramxax, @NonNull wtz paramwtz)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramxax, paramwtz), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return wtz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xba
 * JD-Core Version:    0.7.0.1
 */