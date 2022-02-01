import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class wrl
  extends QQUIEventReceiver<wri, wkk>
{
  public wrl(@NonNull wri paramwri)
  {
    super(paramwri);
  }
  
  private void b(wri paramwri, wkk paramwkk)
  {
    Object localObject = ((wmr)wri.a(paramwri).getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(3, "");
    if ((localObject != null) && (paramwkk.b.equals(((wly)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    wly localwly;
    do
    {
      return;
      localObject = (wae)wri.a(paramwri).getManager(QQManagerFactory.STORY_HALO_MANAGER);
      localwly = ((wae)localObject).b(paramwkk.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localwly + "\nmanager: " + localObject);
      }
    } while (localwly == null);
    int i = localwly.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        wmq localwmq = (wmq)localwly.a.get(i);
        if ((localwmq.jdField_a_of_type_Long == paramwkk.jdField_a_of_type_Long) && (!localwmq.jdField_a_of_type_Boolean))
        {
          localwmq.jdField_a_of_type_Boolean = true;
          localwly.b -= 1;
        }
      }
      else
      {
        ((wae)localObject).c(localwly);
        ((wae)localObject).b(localwly);
        paramwri = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramwri);
        ThreadManager.getUIHandler().post(paramwri);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull wri paramwri, @NonNull wkk paramwkk)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramwri, paramwkk), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return wkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrl
 * JD-Core Version:    0.7.0.1
 */