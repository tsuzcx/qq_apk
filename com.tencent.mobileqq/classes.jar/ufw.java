import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class ufw
  extends QQUIEventReceiver<ufp, uhc>
{
  private int a;
  
  ufw(@NonNull ufp paramufp, int paramInt)
  {
    super(paramufp);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull ufp paramufp, @NonNull uhc paramuhc)
  {
    upe.c("comment", "onEvent,commentEvent.mEventAction:" + paramuhc.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + this.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      upe.d("comment", "commentPresenter 's hashCode:" + paramufp.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      upe.c("comment", "commentPresenter 's hashCode:" + paramufp.hashCode() + ", 页面正确,开始响应~");
      switch (paramuhc.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        upe.b("comment", "default process,commentEvent.mEventAction:" + paramuhc.jdField_a_of_type_Int);
        return;
      case 1: 
        paramufp.b();
        return;
      case 2: 
        ufp.a(paramufp);
        return;
      case 4: 
        if ((paramuhc.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramuhc = (Object[])paramuhc.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramuhc[0]).intValue();
          paramufp.a(i);
          paramuhc = (stSimpleMetaFeed)((uru)paramuhc[1]).a();
          upe.c("comment", "setCurrentFeed , feedId:" + paramuhc.id + ", position:" + i + ",feed desc:" + paramuhc.feed_desc);
          paramufp.a(paramuhc);
        }
        QZLog.w(this.TAG, "event page change, position:" + ufp.b(paramufp) + " feedId:" + ufp.a(paramufp));
        ufp.a(paramufp, null);
        ufp.a(paramufp, "");
        ufp.b(paramufp, 0L);
        ufp.a(paramufp, false);
        paramuhc = ufp.a(paramufp);
      }
    } while ((!ufp.e(paramufp)) || (paramuhc == null));
    paramufp = paramuhc.a();
    paramufp.removeMessages(11);
    paramufp.sendMessageDelayed(paramufp.obtainMessage(11), 20L);
    return;
    paramufp.a((Object[])paramuhc.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return uhc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufw
 * JD-Core Version:    0.7.0.1
 */