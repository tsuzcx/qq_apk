import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Map;

public class tvh
  extends QQUIEventReceiver<tuz, tuf>
{
  public tvh(@NonNull tuz paramtuz)
  {
    super(paramtuz);
  }
  
  public void a(@NonNull tuz paramtuz, @NonNull tuf paramtuf)
  {
    switch (paramtuf.jdField_a_of_type_Int)
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
            paramtuz.h();
            return;
            paramtuz.i();
            return;
            tuz.a(paramtuz, false);
            tuz.a(paramtuz, null);
            tuz.a(paramtuz, null);
          } while (!(paramtuf.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramtuf = (Object[])paramtuf.jdField_a_of_type_JavaLangObject;
        } while ((paramtuf.length < 2) || (!(paramtuf[0] instanceof FeedCloudMeta.StFeed)) || (!(paramtuf[1] instanceof Integer)));
        localStFeed = (FeedCloudMeta.StFeed)paramtuf[0];
        i = ((Integer)paramtuf[1]).intValue();
      } while (!paramtuz.a(localStFeed));
      tuz.c(paramtuz).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    tuz.a(paramtuz, (Object[])paramtuf.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return tuf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */