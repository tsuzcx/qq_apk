import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class yce
  extends QQUIEventReceiver<ybx, ybt>
{
  public yce(@NonNull ybx paramybx)
  {
    super(paramybx);
  }
  
  public void a(@NonNull ybx paramybx, @NonNull ybt paramybt)
  {
    switch (paramybt.jdField_a_of_type_Int)
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
            paramybx.g();
            return;
            paramybx.h();
            return;
            ybx.a(paramybx, false);
            ybx.a(paramybx, null);
            ybx.a(paramybx, null);
          } while (!(paramybt.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramybt = (Object[])paramybt.jdField_a_of_type_JavaLangObject;
        } while ((paramybt.length < 2) || (!(paramybt[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramybt[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramybt[0];
        i = ((Integer)paramybt[1]).intValue();
      } while (!paramybx.a(localStFeed));
      ybx.c(paramybx).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    ybx.a(paramybx, (Object[])paramybt.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return ybt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yce
 * JD-Core Version:    0.7.0.1
 */