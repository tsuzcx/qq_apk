import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class vap
  extends QQUIEventReceiver<vaj, vbv>
{
  private int a;
  
  vap(@NonNull vaj paramvaj, int paramInt)
  {
    super(paramvaj);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull vaj paramvaj, @NonNull vbv paramvbv)
  {
    vmp.c("comment", "onEvent,commentEvent.mEventAction:" + paramvbv.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + this.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      vmp.d("comment", "commentPresenter 's hashCode:" + paramvaj.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      vmp.c("comment", "commentPresenter 's hashCode:" + paramvaj.hashCode() + ", 页面正确,开始响应~");
      switch (paramvbv.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        vmp.b("comment", "default process,commentEvent.mEventAction:" + paramvbv.jdField_a_of_type_Int);
        return;
      case 1: 
        paramvaj.b();
        return;
      case 2: 
        vaj.a(paramvaj);
        return;
      case 4: 
        if ((paramvbv.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramvbv = (Object[])paramvbv.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramvbv[0]).intValue();
          paramvaj.a(i);
          paramvbv = (stSimpleMetaFeed)((vpj)paramvbv[1]).a();
          vmp.c("comment", "setCurrentFeed , feedId:" + paramvbv.id + ", position:" + i + ",feed desc:" + paramvbv.feed_desc);
          paramvaj.a(paramvbv);
        }
        QZLog.w(this.TAG, "event page change, position:" + vaj.b(paramvaj) + " feedId:" + vaj.a(paramvaj));
        vaj.a(paramvaj, null);
        vaj.a(paramvaj, "");
        vaj.a(paramvaj, 0L);
        vaj.a(paramvaj, false);
        paramvbv = vaj.a(paramvaj);
      }
    } while ((!vaj.c(paramvaj)) || (paramvbv == null));
    paramvaj = paramvbv.a();
    paramvaj.removeMessages(11);
    paramvaj.sendMessageDelayed(paramvaj.obtainMessage(11), 20L);
    return;
    paramvaj.a((Object[])paramvbv.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return vbv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vap
 * JD-Core Version:    0.7.0.1
 */