import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class tkv
  extends QQUIEventReceiver<tks, tdu>
{
  public tkv(@NonNull tks paramtks)
  {
    super(paramtks);
  }
  
  private void b(tks paramtks, tdu paramtdu)
  {
    Object localObject = ((tgb)tks.a(paramtks).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramtdu.b.equals(((tfi)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    tfi localtfi;
    do
    {
      return;
      localObject = (stf)tks.a(paramtks).getManager(197);
      localtfi = ((stf)localObject).b(paramtdu.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localtfi + "\nmanager: " + localObject);
      }
    } while (localtfi == null);
    int i = localtfi.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        tga localtga = (tga)localtfi.a.get(i);
        if ((localtga.jdField_a_of_type_Long == paramtdu.jdField_a_of_type_Long) && (!localtga.jdField_a_of_type_Boolean))
        {
          localtga.jdField_a_of_type_Boolean = true;
          localtfi.b -= 1;
        }
      }
      else
      {
        ((stf)localObject).c(localtfi);
        ((stf)localObject).b(localtfi);
        paramtks = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramtks);
        ThreadManager.getUIHandler().post(paramtks);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull tks paramtks, @NonNull tdu paramtdu)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramtks, paramtdu), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return tdu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkv
 * JD-Core Version:    0.7.0.1
 */