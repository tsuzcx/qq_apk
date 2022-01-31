import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class waf
  extends QQUIEventReceiver<vzz, vzr>
{
  public waf(@NonNull vzz paramvzz)
  {
    super(paramvzz);
  }
  
  public void a(@NonNull vzz paramvzz, @NonNull vzr paramvzr)
  {
    switch (paramvzr.jdField_a_of_type_Int)
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
            paramvzz.i();
            return;
            paramvzz.j();
            return;
            vzz.a(paramvzz, false);
            vzz.a(paramvzz, null);
            vzz.a(paramvzz, null);
          } while (!(paramvzr.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramvzr = (Object[])paramvzr.jdField_a_of_type_JavaLangObject;
        } while ((paramvzr.length < 2) || (!(paramvzr[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramvzr[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramvzr[0];
        i = ((Integer)paramvzr[1]).intValue();
      } while (!paramvzz.a(localStFeed));
      vzz.c(paramvzz).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    vzz.a(paramvzz, (Object[])paramvzr.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return vzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     waf
 * JD-Core Version:    0.7.0.1
 */