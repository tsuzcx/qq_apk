import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import mqq.os.MqqHandler;

public final class tks
  extends QQUIEventReceiver<tkp, tdr>
{
  public tks(@NonNull tkp paramtkp)
  {
    super(paramtkp);
  }
  
  private void b(tkp paramtkp, tdr paramtdr)
  {
    Object localObject = ((tfy)tkp.a(paramtkp).getManager(251)).a().a(3, "");
    if ((localObject != null) && (paramtdr.b.equals(((tff)localObject).e))) {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onEvent: invoked. Message: guideInfo: " + localObject);
      }
    }
    tff localtff;
    do
    {
      return;
      localObject = (stc)tkp.a(paramtkp).getManager(197);
      localtff = ((stc)localObject).b(paramtdr.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "syncHaloReadStatus: invoked. Message: haloNodeInfo: " + localtff + "\nmanager: " + localObject);
      }
    } while (localtff == null);
    int i = localtff.a.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        tfx localtfx = (tfx)localtff.a.get(i);
        if ((localtfx.jdField_a_of_type_Long == paramtdr.jdField_a_of_type_Long) && (!localtfx.jdField_a_of_type_Boolean))
        {
          localtfx.jdField_a_of_type_Boolean = true;
          localtff.b -= 1;
        }
      }
      else
      {
        ((stc)localObject).c(localtff);
        ((stc)localObject).b(localtff);
        paramtkp = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.2(this, paramtkp);
        ThreadManager.getUIHandler().post(paramtkp);
        return;
      }
      i -= 1;
    }
  }
  
  public void a(@NonNull tkp paramtkp, @NonNull tdr paramtdr)
  {
    ThreadManager.post(new RecentTabHaloPresenter.ReadStoryVideoEventReceiver.1(this, paramtkp, paramtdr), 8, null, true);
  }
  
  public Class acceptEventClass()
  {
    return tdr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tks
 * JD-Core Version:    0.7.0.1
 */