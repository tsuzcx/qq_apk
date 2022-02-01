import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class ump
  extends QQUIEventReceiver<umj, unv>
{
  private int a;
  
  ump(@NonNull umj paramumj, int paramInt)
  {
    super(paramumj);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull umj paramumj, @NonNull unv paramunv)
  {
    uya.c("comment", "onEvent,commentEvent.mEventAction:" + paramunv.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + this.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      uya.d("comment", "commentPresenter 's hashCode:" + paramumj.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      uya.c("comment", "commentPresenter 's hashCode:" + paramumj.hashCode() + ", 页面正确,开始响应~");
      switch (paramunv.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        uya.b("comment", "default process,commentEvent.mEventAction:" + paramunv.jdField_a_of_type_Int);
        return;
      case 1: 
        paramumj.b();
        return;
      case 2: 
        umj.a(paramumj);
        return;
      case 4: 
        if ((paramunv.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramunv = (Object[])paramunv.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramunv[0]).intValue();
          paramumj.a(i);
          paramunv = (stSimpleMetaFeed)((vaq)paramunv[1]).a();
          uya.c("comment", "setCurrentFeed , feedId:" + paramunv.id + ", position:" + i + ",feed desc:" + paramunv.feed_desc);
          paramumj.a(paramunv);
        }
        QZLog.w(this.TAG, "event page change, position:" + umj.b(paramumj) + " feedId:" + umj.a(paramumj));
        umj.a(paramumj, null);
        umj.a(paramumj, "");
        umj.a(paramumj, 0L);
        umj.a(paramumj, false);
        paramunv = umj.a(paramumj);
      }
    } while ((!umj.c(paramumj)) || (paramunv == null));
    paramumj = paramunv.a();
    paramumj.removeMessages(11);
    paramumj.sendMessageDelayed(paramumj.obtainMessage(11), 20L);
    return;
    paramumj.a((Object[])paramunv.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return unv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ump
 * JD-Core Version:    0.7.0.1
 */