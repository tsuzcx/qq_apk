import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class wcq
  extends QQUIEventReceiver<wcn, vvp>
{
  public wcq(@NonNull wcn paramwcn)
  {
    super(paramwcn);
  }
  
  private void b(wcn paramwcn, vvp paramvvp)
  {
    Object localObject = ((vxw)wcn.a(paramwcn).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramvvp.b.equals(((vxd)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    vxd localvxd;
    do
    {
      return;
      localObject = (vlj)wcn.a(paramwcn).getManager(197);
      localvxd = ((vlj)localObject).b(paramvvp.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localvxd + "\nmanager: " + localObject);
      }
    } while (localvxd == null);
    int i = localvxd.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        vxv localvxv = (vxv)localvxd.a.get(i);
        if ((localvxv.jdField_a_of_type_Long == paramvvp.jdField_a_of_type_Long) && (!localvxv.jdField_a_of_type_Boolean))
        {
          localvxv.jdField_a_of_type_Boolean = true;
          localvxd.b -= 1;
        }
      }
      else
      {
        ((vlj)localObject).c(localvxd);
        ((vlj)localObject).b(localvxd);
        paramwcn = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramwcn);
        ThreadManager.getUIHandler().post(paramwcn);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull wcn paramwcn, @NonNull vvp paramvvp)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramwcn, paramvvp), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return vvp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcq
 * JD-Core Version:    0.7.0.1
 */