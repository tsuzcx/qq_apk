import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class wns
  extends QQUIEventReceiver<wnl, wnd>
{
  public wns(@NonNull wnl paramwnl)
  {
    super(paramwnl);
  }
  
  public void a(@NonNull wnl paramwnl, @NonNull wnd paramwnd)
  {
    switch (paramwnd.jdField_a_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      CertifiedAccountMeta.StFeed localStFeed;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramwnl.i();
            return;
            paramwnl.j();
            return;
            wnl.a(paramwnl, false);
            wnl.a(paramwnl, null);
            wnl.a(paramwnl, null);
          } while (!(paramwnd.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramwnd = (Object[])paramwnd.jdField_a_of_type_JavaLangObject;
        } while ((paramwnd.length < 2) || (!(paramwnd[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramwnd[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramwnd[0];
        i = ((Integer)paramwnd[1]).intValue();
      } while (!paramwnl.a(localStFeed));
      wnl.c(paramwnl).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    wnl.a(paramwnl, (Object[])paramwnd.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return wnd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */