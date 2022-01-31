import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Map;

public class tus
  extends QQUIEventReceiver<tuk, ttq>
{
  public tus(@NonNull tuk paramtuk)
  {
    super(paramtuk);
  }
  
  public void a(@NonNull tuk paramtuk, @NonNull ttq paramttq)
  {
    switch (paramttq.jdField_a_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      FeedCloudMeta.StFeed localStFeed;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramtuk.g();
            return;
            paramtuk.h();
            return;
            tuk.a(paramtuk, false);
            tuk.a(paramtuk, null);
            tuk.a(paramtuk, null);
          } while (!(paramttq.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramttq = (Object[])paramttq.jdField_a_of_type_JavaLangObject;
        } while ((paramttq.length < 2) || (!(paramttq[0] instanceof FeedCloudMeta.StFeed)) || (!(paramttq[1] instanceof Integer)));
        localStFeed = (FeedCloudMeta.StFeed)paramttq[0];
        i = ((Integer)paramttq[1]).intValue();
      } while (!paramtuk.a(localStFeed));
      tuk.c(paramtuk).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    tuk.a(paramtuk, (Object[])paramttq.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return ttq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tus
 * JD-Core Version:    0.7.0.1
 */