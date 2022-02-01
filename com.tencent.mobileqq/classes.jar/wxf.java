import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class wxf
  extends QQUIEventReceiver<wxc, wqe>
{
  public wxf(@NonNull wxc paramwxc)
  {
    super(paramwxc);
  }
  
  private void b(wxc paramwxc, wqe paramwqe)
  {
    Object localObject = ((wsl)wxc.a(paramwxc).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramwqe.b.equals(((wrs)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    wrs localwrs;
    do
    {
      return;
      localObject = (wfp)wxc.a(paramwxc).getManager(197);
      localwrs = ((wfp)localObject).b(paramwqe.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localwrs + "\nmanager: " + localObject);
      }
    } while (localwrs == null);
    int i = localwrs.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        wsk localwsk = (wsk)localwrs.a.get(i);
        if ((localwsk.jdField_a_of_type_Long == paramwqe.jdField_a_of_type_Long) && (!localwsk.jdField_a_of_type_Boolean))
        {
          localwsk.jdField_a_of_type_Boolean = true;
          localwrs.b -= 1;
        }
      }
      else
      {
        ((wfp)localObject).c(localwrs);
        ((wfp)localObject).b(localwrs);
        paramwxc = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramwxc);
        ThreadManager.getUIHandler().post(paramwxc);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull wxc paramwxc, @NonNull wqe paramwqe)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramwxc, paramwqe), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return wqe.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxf
 * JD-Core Version:    0.7.0.1
 */