import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class vdt
  extends QQUIEventReceiver<vdq, uws>
{
  public vdt(@NonNull vdq paramvdq)
  {
    super(paramvdq);
  }
  
  private void b(vdq paramvdq, uws paramuws)
  {
    Object localObject = ((uyz)vdq.a(paramvdq).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramuws.b.equals(((uyg)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    uyg localuyg;
    do
    {
      return;
      localObject = (umd)vdq.a(paramvdq).getManager(197);
      localuyg = ((umd)localObject).b(paramuws.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localuyg + "\nmanager: " + localObject);
      }
    } while (localuyg == null);
    int i = localuyg.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        uyy localuyy = (uyy)localuyg.a.get(i);
        if ((localuyy.jdField_a_of_type_Long == paramuws.jdField_a_of_type_Long) && (!localuyy.jdField_a_of_type_Boolean))
        {
          localuyy.jdField_a_of_type_Boolean = true;
          localuyg.b -= 1;
        }
      }
      else
      {
        ((umd)localObject).c(localuyg);
        ((umd)localObject).b(localuyg);
        paramvdq = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramvdq);
        ThreadManager.getUIHandler().post(paramvdq);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull vdq paramvdq, @NonNull uws paramuws)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramvdq, paramuws), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return uws.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdt
 * JD-Core Version:    0.7.0.1
 */