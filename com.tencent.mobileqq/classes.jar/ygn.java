import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class ygn
  extends QQUIEventReceiver<ygg, ygc>
{
  public ygn(@NonNull ygg paramygg)
  {
    super(paramygg);
  }
  
  public void a(@NonNull ygg paramygg, @NonNull ygc paramygc)
  {
    switch (paramygc.jdField_a_of_type_Int)
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
            paramygg.g();
            return;
            paramygg.h();
            return;
            ygg.a(paramygg, false);
            ygg.a(paramygg, null);
            ygg.a(paramygg, null);
          } while (!(paramygc.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramygc = (Object[])paramygc.jdField_a_of_type_JavaLangObject;
        } while ((paramygc.length < 2) || (!(paramygc[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramygc[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramygc[0];
        i = ((Integer)paramygc[1]).intValue();
      } while (!paramygg.a(localStFeed));
      ygg.c(paramygg).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    ygg.a(paramygg, (Object[])paramygc.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return ygc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygn
 * JD-Core Version:    0.7.0.1
 */