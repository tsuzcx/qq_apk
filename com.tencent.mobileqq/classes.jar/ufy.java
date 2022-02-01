import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class ufy
  extends QQUIEventReceiver<ufr, uhe>
{
  private int a;
  
  ufy(@NonNull ufr paramufr, int paramInt)
  {
    super(paramufr);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull ufr paramufr, @NonNull uhe paramuhe)
  {
    uqf.c("comment", "onEvent,commentEvent.mEventAction:" + paramuhe.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + this.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      uqf.d("comment", "commentPresenter 's hashCode:" + paramufr.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      uqf.c("comment", "commentPresenter 's hashCode:" + paramufr.hashCode() + ", 页面正确,开始响应~");
      switch (paramuhe.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        uqf.b("comment", "default process,commentEvent.mEventAction:" + paramuhe.jdField_a_of_type_Int);
        return;
      case 1: 
        paramufr.b();
        return;
      case 2: 
        ufr.a(paramufr);
        return;
      case 4: 
        if ((paramuhe.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramuhe = (Object[])paramuhe.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramuhe[0]).intValue();
          paramufr.a(i);
          paramuhe = (stSimpleMetaFeed)((usv)paramuhe[1]).a();
          uqf.c("comment", "setCurrentFeed , feedId:" + paramuhe.id + ", position:" + i + ",feed desc:" + paramuhe.feed_desc);
          paramufr.a(paramuhe);
        }
        QZLog.w(this.TAG, "event page change, position:" + ufr.b(paramufr) + " feedId:" + ufr.a(paramufr));
        ufr.a(paramufr, null);
        ufr.a(paramufr, "");
        ufr.b(paramufr, 0L);
        ufr.a(paramufr, false);
        paramuhe = ufr.a(paramufr);
      }
    } while ((!ufr.e(paramufr)) || (paramuhe == null));
    paramufr = paramuhe.a();
    paramufr.removeMessages(11);
    paramufr.sendMessageDelayed(paramufr.obtainMessage(11), 20L);
    return;
    paramufr.a((Object[])paramuhe.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return uhe.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */