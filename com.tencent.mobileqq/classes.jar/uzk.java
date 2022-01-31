import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class uzk
  extends QQUIEventReceiver<uzh, usj>
{
  public uzk(@NonNull uzh paramuzh)
  {
    super(paramuzh);
  }
  
  private void b(uzh paramuzh, usj paramusj)
  {
    Object localObject = ((uuq)uzh.a(paramuzh).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramusj.b.equals(((utx)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    utx localutx;
    do
    {
      return;
      localObject = (uhu)uzh.a(paramuzh).getManager(197);
      localutx = ((uhu)localObject).b(paramusj.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localutx + "\nmanager: " + localObject);
      }
    } while (localutx == null);
    int i = localutx.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        uup localuup = (uup)localutx.a.get(i);
        if ((localuup.jdField_a_of_type_Long == paramusj.jdField_a_of_type_Long) && (!localuup.jdField_a_of_type_Boolean))
        {
          localuup.jdField_a_of_type_Boolean = true;
          localutx.b -= 1;
        }
      }
      else
      {
        ((uhu)localObject).c(localutx);
        ((uhu)localObject).b(localutx);
        paramuzh = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramuzh);
        ThreadManager.getUIHandler().post(paramuzh);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull uzh paramuzh, @NonNull usj paramusj)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramuzh, paramusj), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return usj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzk
 * JD-Core Version:    0.7.0.1
 */